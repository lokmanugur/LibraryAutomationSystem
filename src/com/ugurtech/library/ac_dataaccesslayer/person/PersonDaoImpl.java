/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.ac_dataaccesslayer.person;

import com.ugurtech.library.ab_application.af_lib.sql.DbUtils;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ac_dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.ad_model.PersonModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 */
public class PersonDaoImpl extends DaoAbstract implements PersonDao {

    public static final String PERSON_INSERT_QUERY = "INSERT INTO person(firstname,lastname,birthdate,address,phone,createddate,lastupdate) VALUES(?,?,?,?,?,?,?)";
    public static final String PERSON_UPDATE_QUERY = "UPDATE person SET firstname=?,lastname=?,birthdate=?,address=?,phone=?,lastupdate=? WHERE personid=?";
    public static final String PERSON_DELETE_QUERY = "DELETE FROM person WHERE personid=?";
    public static final String PERSON_SEARCH_QUERY = "SELECT "
            + getTableTitle(Tables.Person.personid) + ","
            + getTableTitle(Tables.Person.firstname) + ","
            + getTableTitle(Tables.Person.lastname) + ","
            + getTableTitle(Tables.Person.birthdate) + ","
            + getTableTitle(Tables.Person.address) + ","
            + getTableTitle(Tables.Person.phone) + ","
            + getTableTitle(Tables.Person.createddate) + ","
            + getTableTitle(Tables.Person.lastupdate)
            + " FROM " + Tables.person;

    @Override
    public TableModel search(String searchText) {
        String query = "";
        query += PERSON_SEARCH_QUERY;
        query += " WHERE ";
        query += "(";
        query += setLanguage(Tables.Person.personid) + " LIKE '" + searchText + "%' OR ";
        query += setLanguage(Tables.Person.firstname) + " LIKE '" + searchText + "%' OR ";
        query += setLanguage(Tables.Person.lastname) + " LIKE '" + searchText + "%' OR ";
        query += setLanguage(Tables.Person.phone) + " LIKE '" + searchText + "%' OR ";
        query += setLanguage(Tables.Person.address) + " LIKE '" + searchText + "%'";
        query += ")";
        return DbUtils.resultSetToTableModel(createResultSet(query), setLanguage(Tables.Person.birthdate), setLanguage(Tables.Person.createddate), setLanguage(Tables.Person.lastupdate));
    }

    @Override
    public List<PersonModel> getAll() {
        String query=PERSON_SEARCH_QUERY;
        query+=" WHERE  "+Tables.Person.personid+" NOT IN (SELECT author.personid FROM author) GROUP BY "+Tables.Person.personid;
        List<PersonModel> personsList = null;
        ResultSet resultSet = createResultSet(query);
        try {
            personsList = new ArrayList<>();
            while(resultSet.next()){
                personsList.add( new PersonModel(resultSet.getInt(setLanguage(Tables.Person.personid)),
                        resultSet.getString(setLanguage(Tables.Person.firstname)),
                        resultSet.getString(setLanguage(Tables.Person.lastname))));
            }
            
        } catch (SQLException ex) {
            getLogger(ex, "GetAll Error Query",PersonDaoImpl.class.getName());
        }
        return personsList;
    }

    @Override
    public PersonModel get(int id) {
        PersonModel personModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, PERSON_SEARCH_QUERY, " WHERE ", Tables.Person.personid + "="));
        try {
            personModel = new PersonModel();
            if (resultSet.next()) {
                personModel.setPersonId(resultSet.getInt(setLanguage(Tables.Person.personid)));
                personModel.setFirstName(resultSet.getString(setLanguage(Tables.Person.firstname)));
                personModel.setLastName(resultSet.getString(setLanguage(Tables.Person.lastname)));
                personModel.setBirthDate(resultSet.getLong(setLanguage(Tables.Person.birthdate)));
                personModel.setPhone(resultSet.getString(setLanguage(Tables.Person.phone)));
                personModel.setAddress(resultSet.getString(setLanguage(Tables.Person.address)));
            }
        } catch (SQLException ex) {
           getLogger(ex, "Get error Query",PersonDaoImpl.class.getName());
        }

        return personModel;
    }

    @Override
    public void add(PersonModel personModel) {
        PreparedStatement preparedStatement = createPrepareStatement(PERSON_INSERT_QUERY);
        try {
            preparedStatement.setString(1, personModel.getFirstName());
            preparedStatement.setString(2, personModel.getLastName());
            preparedStatement.setLong(3, personModel.getBirthDate());
            preparedStatement.setString(4, personModel.getAddress());
            preparedStatement.setString(5, personModel.getPhone());
            preparedStatement.setLong(6, new Date().getTime());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            getLogger(ex, "Add Error Query",PersonDaoImpl.class.getName());
        }
    }

    @Override
    public void update(PersonModel v) {
        PreparedStatement preparedStatement = createPrepareStatement(PERSON_UPDATE_QUERY);
        try {
            preparedStatement.setString(1, v.getFirstName());
            preparedStatement.setString(2, v.getLastName());
            preparedStatement.setLong(3, v.getBirthDate());
            preparedStatement.setString(4, v.getAddress());
            preparedStatement.setString(5, v.getPhone());
            preparedStatement.setLong(6, new Date().getTime());
            preparedStatement.setInt(7, v.getPersonId());
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(effectedRow);
        } catch (SQLException ex) {
            getLogger(ex, "Update Error Query",PersonDaoImpl.class.getName());
        }
    }

    @Override
    public void delete(PersonModel v) {
        PreparedStatement preparedStatement = createPrepareStatement(PERSON_DELETE_QUERY);
        try {
            preparedStatement.setInt(1, v.getPersonId());
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effectedRow);
        } catch (SQLException ex) {
            getLogger(ex, "Delete Error Query",PersonDaoImpl.class.getName());
        }
    }

}