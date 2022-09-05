/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.author;

import com.ugurtech.library.ab_application.af_lib.sql.DbUtils;
import com.ugurtech.library.ad_model.AuthorModel;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ac_dataaccesslayer.enumeration.Tables;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class AuthorDaoImpl extends DaoAbstract implements AuthorDao {

    public static final String AUTHOR_UPDATE_QUERY = "UPDATE person SET firstname=?,lastname=?,birthdate=?,lastupdate=? WHERE personid=(SELECT personid FROM author WHERE authorid=?)";
    public static final String AUTHOR_INSERT_QUERY = "INSERT INTO author(personid) VALUES(?)";
    public static final String PERSON_INSERT_QUERY = "INSERT INTO person(firstname,lastname,birthdate,createddate,lastupdate) VALUES(?,?,?,?,?)";
    public static final String AUTHOR_DELETE_QUERY = "DELETE FROM author WHERE authorid=?";
    public static final String PERSON_DELETE_QUERY = "DELETE FROM person WHERE personid=?";

    public static final String AUTHOR_SEARCH_QUERY2 = "SELECT "
            + getTableTitle(Tables.author + ".authorid") + ","
            + getTableTitle(Tables.person + ".personid") + ","
            + getTableTitle(Tables.person + ".firstname") + ","
            + getTableTitle(Tables.person + ".lastname") + ","
            + getTableTitle(Tables.person + ".birthdate") + ""
            + " FROM author,person ";
    public static final String AUTHOR_SEARCH_QUERY = "SELECT "
            + getTableTitle(Tables.author + ".authorid") + ","
            + getTableTitle(Tables.person + ".firstname") + ","
            + getTableTitle(Tables.person + ".lastname") + ","
            + getTableTitle(Tables.person + ".birthdate") + ","
            + getTableTitle(Tables.person + ".createddate") + ","
            + getTableTitle(Tables.person + ".lastupdate") + ""
            + " FROM author,person ";

    private final List<AuthorModel> authorList;
    private final StringBuilder query;

    public AuthorDaoImpl() {
        authorList = new ArrayList<>();
        query = new StringBuilder();
    }

    @Override
    public List<AuthorModel> getAll() {

        if (!authorList.isEmpty()) {
            authorList.clear();
        }        
        ResultSet resultSet = createResultSet(getExistID(
                0, 
                AUTHOR_SEARCH_QUERY,
                " WHERE",
                " author.personid = person.personid"));
        try {
            while (resultSet.next()) {
                authorList.add(new AuthorModel(
                        resultSet.getInt(setLanguage("author.authorid")),
                        resultSet.getString(setLanguage("person.firstname")),
                        resultSet.getString(setLanguage("person.lastname"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authorList;
    }
    
    @Override
    public AuthorModel get(int id) {
        AuthorModel authorModel = new AuthorModel();
        ResultSet resultSet = createResultSet(
                getExistID(id,
                        AUTHOR_SEARCH_QUERY2,
                        " WHERE person.personid = author.personid",
                        " AND author.authorid ="));
        try {
            while (resultSet.next()) {
                authorModel.setAuthorId(resultSet.getInt(setLanguage("author.authorid")));
                authorModel.setPersonId(resultSet.getInt(setLanguage("person.personid")));
                authorModel.setFirstName(resultSet.getString(setLanguage("person.firstname")));
                authorModel.setLastName(resultSet.getString(setLanguage("person.lastname")));
                authorModel.setBirthDate(resultSet.getLong(setLanguage("person.birthdate")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return authorModel;
    }

    @Override
    public void add(AuthorModel am) {
        PreparedStatement preparedStatement = createPrepareStatement(PERSON_INSERT_QUERY);
        try {
            preparedStatement.setString(1, am.getFirstName());
            preparedStatement.setString(2, am.getLastName());
            preparedStatement.setLong(3, am.getBirthDate());
            preparedStatement.setLong(4, new Date().getTime());
            preparedStatement.setLong(5, new Date().getTime());
            preparedStatement.executeUpdate();
            ResultSet genId = preparedStatement.getGeneratedKeys();
            am.setPersonId(genId.getInt(1));
            preparedStatement = createPrepareStatement(AUTHOR_INSERT_QUERY);
            preparedStatement.setInt(1, am.getPersonId());
            int numberOfData = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(numberOfData);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(AuthorModel v) {
        PreparedStatement preparedStatement = createPrepareStatement(AUTHOR_UPDATE_QUERY);
        try {
            preparedStatement.setString(1, v.getFirstName());
            preparedStatement.setString(2, v.getLastName());
            preparedStatement.setLong(3, v.getBirthDate());
            preparedStatement.setLong(4, new Date().getTime());
            preparedStatement.setInt(5, v.getAuthorId());
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(effectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Update Error");
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(AuthorModel v) {
        PreparedStatement preparedStatementAuthor = createPrepareStatement(AUTHOR_DELETE_QUERY);
        PreparedStatement preparedStatementPerson = createPrepareStatement(PERSON_DELETE_QUERY);
        try {
            preparedStatementPerson.setInt(1, v.getPersonId());
            int effactedRow = preparedStatementPerson.executeUpdate();
            preparedStatementAuthor.setInt(1,v.getAuthorId());
            if(effactedRow>0)
            preparedStatementAuthor.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Delete Error");
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public TableModel search(String string) {
        query.setLength(0);
        query.append(AUTHOR_SEARCH_QUERY);
        query.append(" WHERE");
        query.append(" (").append(setLanguage(Tables.author + ".authorid")).append(" LIKE '").append(string).append("%'");
        query.append(" or ").append(setLanguage(Tables.person + ".firstname")).append(" LIKE '").append(string).append("%'");
        query.append(" or ").append(setLanguage(Tables.person + ".lastname")).append(" LIKE '").append(string).append("%'");
        query.append(" or ").append(setLanguage(Tables.person + ".birthdate")).append(" LIKE '").append(string).append("%' ");
        query.append(" or ").append(setLanguage(Tables.person + ".createddate")).append(" LIKE '").append(string).append("%'");
        query.append(" or ").append(setLanguage(Tables.person + ".lastupdate")).append(" LIKE '").append(string).append("%' ");
        query.append(") AND author.personid=person.personid");
        return  DbUtils.resultSetToTableModel(createResultSet(query.toString()),
                setLanguage("person.birthdate"),
                setLanguage("person.createddate"),
                setLanguage("person.lastupdate"));
    }
}