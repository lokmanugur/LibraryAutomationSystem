/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.author;

import com.ugurtech.library.persistance.DaoAbstract;
import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.model.AuthorModel;
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
 */
public class AuthorDaoImpl extends DaoAbstract implements AuthorDao {
    
    private static final String AUTHOR_UPDATE_QUERY="UPDATE person SET firstname=?,lastname=?,birthdate=?,phone=?,address=?,lastupdate=? WHERE personid=(SELECT personid FROM author WHERE authorid=?)";
    private static final String AUTHOR_DELETE_QUERY="UPDATE person SET deleted=?,lastupdate=? WHERE personid=(SELECT personid FROM author WHERE authorid=?)";
    private static final String AUTHOR_INSERT_QUERY="INSERT INTO author(personid) VALUES(?)";
    private static final String PERSON_INSERT_QUERY="INSERT INTO person(firstname,lastname,birthdate,address,phone,createddate) VALUES(?,?,?,?,?,?)";
    private static final String AUTHOR_SEARCH_QUERY="SELECT a.authorid as Yazar_No,p.firstname as Adı,p.lastname as Soyadı,"
                + "p.birthdate as Doğum_Tarihi,p.phone as Telefon,p.address as Adres,p.createddate as Oluşturma_Tarihi,"
                + "p.lastupdate as Son_Güncelleme_Tarihi "
                + "FROM author a,person p ";

    @Override
    public ResultSet fillAllAuthor(Map<String, String> filters) {
        StringBuilder query = new StringBuilder(AUTHOR_SEARCH_QUERY);
        query.append("WHERE ");
        query.append("a.personid = p.personid ");
        query.append("AND p.deleted=0 ");
        fillFilters(query,filters);
        return createResultSet(query.toString());
    }

    @Override
    public AuthorModel getAuthor(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAuthor(AuthorModel am) {
        PreparedStatement preparedStatement=createPrepareStatement(PERSON_INSERT_QUERY);
        try {
            preparedStatement.setString(1, am.getFirstName());
            preparedStatement.setString(2, am.getLastName());
            preparedStatement.setString(3, am.getBirthDate()==null?null:am.getBirthDate().toString());
            preparedStatement.setString(4, am.getAddress());
            preparedStatement.setString(5, am.getPhone());
            preparedStatement.setString(6, new Date().toString());
            preparedStatement.executeUpdate();
            ResultSet genId = preparedStatement.getGeneratedKeys();
            am.setPersonId(genId.getInt(1));
            preparedStatement = createPrepareStatement(AUTHOR_INSERT_QUERY);
            preparedStatement.setInt(1, am.getPersonId());
            int numberOfData = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(numberOfData);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Insert Error");
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateAuthor(AuthorModel am) {
        PreparedStatement preparedStatement=createPrepareStatement(AUTHOR_UPDATE_QUERY);
        try {
            preparedStatement.setString(1, am.getFirstName());
            preparedStatement.setString(2, am.getLastName());
            //preparedStatement.setString(3, am.getBirthDate().toString());
            preparedStatement.setString(4, am.getPhone());
            preparedStatement.setString(5, am.getAddress());
            preparedStatement.setString(6, new Date().toString());
            preparedStatement.setInt(7, am.getAuthorId());
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(effectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Update Error");
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteAuthor(int authorId) {
        PreparedStatement preparedStatement=createPrepareStatement(AUTHOR_DELETE_QUERY);
        try {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setInt(3, authorId);
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Delete Error");
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillFilters(StringBuilder query, Map<String, String> filters) {
        if(!filters.isEmpty()){
            if(filters.containsKey("authorName")){
                query.append("AND ");
                query.append("(p.firstname || ' ' || p.lastname) ");
                query.append("LIKE '%");
                query.append(filters.get("authorName"));
                query.append("%' ");
            }
            
            if(filters.containsKey("authorId")){
                query.append("AND ");
                query.append("a.authorid ");
                query.append("LIKE '");
                query.append(filters.get("authorId"));
                query.append("%' ");
            }
        }
    }
}
