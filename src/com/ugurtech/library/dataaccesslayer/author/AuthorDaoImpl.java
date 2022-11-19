/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.author;

import com.ugurtech.library.application.lib.sql.DbUtils;
import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.dataaccesslayer.DaoAbstract;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.dataaccesslayer.enumeration.Tables;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public static final String AUTHOR_SEARCH_QUERY_GET = "SELECT "
            + columnNameAsColumnTitle(Tables.author + ".authorid") + ","
            + columnNameAsColumnTitle(Tables.person + ".personid") + ","
            + columnNameAsColumnTitle(Tables.person + ".firstname") + ","
            + columnNameAsColumnTitle(Tables.person + ".lastname") + ","
            + columnNameAsColumnTitle(Tables.person + ".birthdate") + ""
            + " FROM author,person ";
    public static final String AUTHOR_SEARCH_QUERY_GETALL = "SELECT "
            + columnNameAsColumnTitle(Tables.author + ".authorid") + ","
            + columnNameAsColumnTitle(Tables.person + ".firstname") + ","
            + columnNameAsColumnTitle(Tables.person + ".lastname") + ","
            + columnNameAsColumnTitle(Tables.person + ".birthdate") + ","
            + columnNameAsColumnTitle(Tables.person + ".createddate") + ","
            + columnNameAsColumnTitle(Tables.person + ".lastupdate") + ""
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
        ResultSet resultSet = createResultSet(getExistID(0,
                AUTHOR_SEARCH_QUERY_GETALL,
                " WHERE",
                " author.personid = person.personid"));
        try {
            while (resultSet.next()) {
                authorList.add(new AuthorModel(
                        resultSet.getInt(columnTitleWithOutPrime("author.authorid")),
                        resultSet.getString(columnTitleWithOutPrime("person.firstname")),
                        resultSet.getString(columnTitleWithOutPrime("person.lastname"))));
            }
        } catch (SQLException ex) {
            getLogger(ex, "Author Add Exception", AuthorDaoImpl.class.getName());
        }
        return authorList;
    }

    @Override
    public AuthorModel get(int id) {
        AuthorModel authorModel = new AuthorModel();
        ResultSet resultSet = createResultSet(getExistID(id,
                AUTHOR_SEARCH_QUERY_GET,
                " WHERE person.personid = author.personid",
                " AND author.authorid ="));
        try {
            while (resultSet.next()) {
                authorModel.setAuthorId(resultSet.getInt(columnTitleWithOutPrime("author.authorid")));
                authorModel.setPersonId(resultSet.getInt(columnTitleWithOutPrime("person.personid")));
                authorModel.setFirstName(resultSet.getString(columnTitleWithOutPrime("person.firstname")));
                authorModel.setLastName(resultSet.getString(columnTitleWithOutPrime("person.lastname")));
                authorModel.setBirthDate(resultSet.getLong(columnTitleWithOutPrime("person.birthdate")));
            }
        } catch (SQLException ex) {
            getLogger(ex, "Author Add Exception", AuthorDaoImpl.class.getName());
        }

        return authorModel;
    }

    @Override
    public void add(AuthorModel am) {
        beginTransection();
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
            rollBack();
            getLogger(ex, "Author Add Exception", AuthorDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public void update(AuthorModel v) {
        beginTransection();
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
            rollBack();
            getLogger(ex, "Author Add Exception", AuthorDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public void delete(AuthorModel v) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(AUTHOR_DELETE_QUERY);
        try {
            preparedStatement.setInt(1, v.getPersonId());
            int effactedRow = preparedStatement.executeUpdate();

            preparedStatement = createPrepareStatement(PERSON_DELETE_QUERY);
            preparedStatement.setInt(1, v.getAuthorId());
            if (effactedRow > 0) {
                preparedStatement.executeUpdate();
            }
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, "Author Add Exception", AuthorDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public TableModel search(String string) {
        query.setLength(0);
        query.append(AUTHOR_SEARCH_QUERY_GETALL);
        query.append(" WHERE");
        query.append(" (").append(columnTitleWithPrime(Tables.Author.authorid)).append(" LIKE '").append(string).append("%'");
        query.append(" or ").append(columnTitleWithPrime(Tables.Person.firstname)).append(" LIKE '").append(string).append("%'");
        query.append(" or ").append(columnTitleWithPrime(Tables.Person.lastname)).append(" LIKE '").append(string).append("%'");
        query.append(" or ").append(columnTitleWithPrime(Tables.Person.birthdate)).append(" LIKE '").append(string).append("%' ");
        query.append(" or ").append(columnTitleWithPrime(Tables.Person.createddate)).append(" LIKE '").append(string).append("%'");
        query.append(" or ").append(columnTitleWithPrime(Tables.Person.lastupdate)).append(" LIKE '").append(string).append("%' ");
        query.append(") AND author.personid=person.personid");
        try {
            return DbUtils.resultSetToTableModel(
                    createResultSet(query.toString()),
                    columnTitleWithOutPrime("person.birthdate"),
                    columnTitleWithOutPrime("person.createddate"),
                    columnTitleWithOutPrime("person.lastupdate"));
        } catch (Exception e) {
            getLogger(e, "search error", AuthorDaoImpl.class.getName());
            return null;
        }
        
    }
}
