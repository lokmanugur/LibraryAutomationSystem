/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistancev2.author;

import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.persistancev2.DaoAbstract;
import com.ugurtech.library.service.validation.UserInfoMessages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class AuthorDaoImpl extends DaoAbstract implements AuthorDao {

    public static final String ALL_AUTHOR_QUERY = "SELECT a.authorid as AuthorId,a.personid as PersonId,p.firstname as FirstName,p.lastname as LastName FROM author a,person p WHERE p.personid = a.personid";
    public static final String AUTHOR_UPDATE_QUERY = "UPDATE person SET firstname=?,lastname=?,birthdate=?,phone=?,address=?,lastupdate=? WHERE personid=(SELECT personid FROM author WHERE authorid=?)";
    public static final String AUTHOR_DELETE_QUERY = "UPDATE person SET deleted=?,lastupdate=? WHERE personid=(SELECT personid FROM author WHERE authorid=?)";
    public static final String AUTHOR_INSERT_QUERY = "INSERT INTO author(personid) VALUES(?)";
    public static final String PERSON_INSERT_QUERY = "INSERT INTO person(firstname,lastname,birthdate,address,phone,createddate) VALUES(?,?,?,?,?,?)";
    public static final String AUTHOR_SEARCH_QUERY = "SELECT "
            + getTableTitle("a.authorid") + ","
            + getTableTitle("p.firstname") + ","
            + getTableTitle("p.lastname") + ","
            + getTableTitle("p.birthdate") + ","
            + getTableTitle("p.phone") + ","
            + getTableTitle("p.address") + ","
            + getTableTitle("p.createddate") + ","
            + getTableTitle("p.lastupdate") + ""
            + " FROM author a,person p ";
    public static final String SINGLE_AUTHOR_QUERY = "SELECT "
            + getTableTitle("a.authorid") + ","
            + getTableTitle("p.firstname") + ","
            + getTableTitle("p.lastname") + ""
            + " FROM author a,person p ";

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
        query.setLength(0);
        query.append(AUTHOR_SEARCH_QUERY);
        query.append(" WHERE");
        query.append(" p.deleted = 0 AND a.personid=p.personid");
        ResultSet resultSet = createResultSet(query.toString());
        try {
            while (resultSet.next()) {
                authorList.add(new AuthorModel(
                        resultSet.getInt(setLanguage("a.authorid")),
                        resultSet.getString(setLanguage("p.firstname")),
                        resultSet.getString(setLanguage("p.lastname"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authorList;
    }

    @Override
    public AuthorModel get(int id) {
        AuthorModel authorModel = null;
        ResultSet resultSet = createResultSet(getID(id));
        try {
            while (resultSet.next()) {
                authorModel= new AuthorModel(
                        resultSet.getInt(setLanguage("a.authorid")),
                        resultSet.getString(setLanguage("p.firstname")),
                        resultSet.getString(setLanguage("p.lastname")));
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
            preparedStatement.setString(4, am.getAddress());
            preparedStatement.setString(5, am.getPhone());
            preparedStatement.setLong(6, new Date().getTime());
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
            //preparedStatement.setString(3, am.getBirthDate().toString());
            preparedStatement.setString(4, v.getPhone());
            preparedStatement.setString(5, v.getAddress());
            preparedStatement.setString(6, new Date().toString());
            preparedStatement.setInt(7, v.getAuthorId());
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(effectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Update Error");
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(AuthorModel v) {
        PreparedStatement preparedStatement = createPrepareStatement(AUTHOR_DELETE_QUERY);
        try {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setInt(3, v.getAuthorId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Delete Error");
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet search(String string) {
        query.setLength(0);
        query.append(AUTHOR_SEARCH_QUERY);
        query.append(" WHERE");
        query.append(" (").append(setLanguage("a.authorid")).append(" LIKE '%").append(string).append("%'");
        query.append(" or ").append(setLanguage("p.firstname")).append(" LIKE '%").append(string).append("%'");
        query.append(" or ").append(setLanguage("p.lastname")).append(" LIKE '%").append(string).append("%'");
        query.append(" or ").append(setLanguage("p.birthdate")).append(" LIKE '%").append(string).append("%' ");
        query.append(" or ").append(setLanguage("p.phone")).append(" LIKE '%").append(string).append("%'");
        query.append(" or ").append(setLanguage("p.address")).append(" LIKE '%").append(string).append("%'");
        query.append(" or ").append(setLanguage("p.createddate")).append(" LIKE '%").append(string).append("%'");
        query.append(" or ").append(setLanguage("p.lastupdate")).append(" LIKE '%").append(string).append("%' ");
        query.append(") AND p.deleted = 0 AND a.personid=p.personid");
        return createResultSet(query.toString());
    }

    private String getID(int id) {
        query.setLength(0);
        query.append(SINGLE_AUTHOR_QUERY);
        query.append(" WHERE");
        query.append(" a.authorid=").append(id);
        return query.toString();
    }

}
