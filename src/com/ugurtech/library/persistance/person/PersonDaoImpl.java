/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.person;

import com.ugurtech.library.persistance.DaoAbstract;
import com.ugurtech.library.persistance.person.PersonDao;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.model.PersonModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugur
 * 
 * 
 */
public class PersonDaoImpl extends DaoAbstract implements PersonDao{

    private static final String PERSON_DELETE_QUERY ="UPDATE person SET deleted=?,lastupdate=? WHERE personid=?";
    private static final String PERSON_INSERT_QUERY = "INSERT INTO person(firstname,lastname,birthdate,phone,address,createddate) VALUES(?,?,?,?,?,?)";
    private static final String PERSON_SEARCH_QUERY ="SELECT p.personid as Kullanıcı_No,p.firstname as Adı,"
            + "p.lastname as Soyadı,p.birthdate as Doğum_Tarihi,p.phone as Telefon,p.address as Adres FROM person p "
            + "LEFT JOIN author a ON p.personid=a.personid ";
    
    @Override
    public ResultSet fillAllPerson(Map<String, String> filters) {
        StringBuilder query = new StringBuilder(PERSON_SEARCH_QUERY);
        query.append("WHERE a.personid IS NULL AND deleted=0 ");
        fillFilters(query,filters);        
        return createResultSet(query.toString());
    }
    
    @Override
    public void insertPerson(PersonModel personModel) {
        PreparedStatement preparedStatement = createPrepareStatement(PERSON_INSERT_QUERY);
        try {
            preparedStatement.setString(1, personModel.getFirstName());
            preparedStatement.setString(2, personModel.getLastName());
            preparedStatement.setString(3, personModel.getBirthDate()==null?null:personModel.getBirthDate().toString());
            preparedStatement.setString(4, personModel.getPhone());
            preparedStatement.setString(5, personModel.getAddress());
            preparedStatement.setString(6, new Date().toString());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Insert Error");
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }



    @Override
    public void updatePerson(PersonModel person) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePerson(int personId) {
        PreparedStatement preparedStatement=createPrepareStatement(PERSON_DELETE_QUERY);
        try {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setInt(3, personId);
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(), "Delete Query Error");
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PersonModel getPerson(int personId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
//    @Override
//    public List<PersonModel> allPerson(){
//        String sqlQueryAllPerson = "SELECT personid,firstname,lastname,birthdate,phone,address FROM person";
//        List<PersonModel> personLists = new ArrayList<>();
//        PersonModel personModel;
//        ResultSet resultSet = createResultSet(sqlQueryAllPerson);
//        try {
//            while(resultSet.next()){
//                personModel = new PersonModel();
//                personModel.setPersonId(resultSet.getInt("personid"));
//                personModel.setFirstName(resultSet.getString("firstname"));
//                personModel.setLastName(resultSet.getString("lastname"));
//                personModel.setBirthDate(resultSet.getDate("birthdate"));
//                personModel.setPhone(resultSet.getString("phone"));
//                personModel.setAddress(resultSet.getString("address"));
//                personLists.add(personModel);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return personLists;
//    }

    private void fillFilters(StringBuilder query, Map<String, String> filters) {
        if(!filters.isEmpty()){
            if(filters.containsKey("firstName")){
                query.append("AND ");
                query.append("firstname ");
                query.append("LIKE '%");
                query.append(filters.get("firstName"));
                query.append("%'");
            }
            if(filters.containsKey("lastName")){
                query.append("AND ");
                query.append("lastname ");
                query.append("LIKE '%");
                query.append(filters.get("lastName"));
                query.append("%'");
            }
        }
    }


}
