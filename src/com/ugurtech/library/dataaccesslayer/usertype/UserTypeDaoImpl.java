/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.dataaccesslayer.usertype;

import com.ugurtech.library.application.lib.sql.DbUtils;
import com.ugurtech.library.application.lib.sql.ListUtils;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.model.responsmodels.UserTypeModel;
import com.ugurtech.library.dataaccesslayer.DaoAbstract;
import com.ugurtech.library.dataaccesslayer.enumeration.Tables;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 */
public class UserTypeDaoImpl extends DaoAbstract implements UserTypeDao {

    public static final String ALL_USERTYPE_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.UserType.usertypeid) + ","
            + columnNameAsColumnTitle(Tables.UserType.usertypename)
            + " FROM usertype";
    public static final String USERTYPE_DELETE_QUERY = "DELETE FROM usertype WHERE sysuserid=?";
    public static final String USERTYPE_OPTION_SELECTION_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.UserType.usertypeid) + ","
            + columnNameAsColumnTitle(Tables.UserType.usertypename) + ","
            + columnNameAsColumnTitle(Tables.UserType.authorform) + ","
            + columnNameAsColumnTitle(Tables.UserType.authorsearchform) + ","
            + columnNameAsColumnTitle(Tables.UserType.authoraddbutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.authorupdatebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.authordeletebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.authorwritebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.bookform) + ","
            + columnNameAsColumnTitle(Tables.UserType.booksearchform) + ","
            + columnNameAsColumnTitle(Tables.UserType.bookaddbutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.bookupdatebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.bookdeletebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.bookwritebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.booktypeform) + ","
            + columnNameAsColumnTitle(Tables.UserType.booktypesearchform) + ","
            + columnNameAsColumnTitle(Tables.UserType.booktypeaddbutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.booktypeupdatebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.booktypedeletebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.booktypewritebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.bookborrowform) + ","
            + columnNameAsColumnTitle(Tables.UserType.finishborrowform) + ","
            + columnNameAsColumnTitle(Tables.UserType.startborrowform) + ","
            + columnNameAsColumnTitle(Tables.UserType.classform) + ","
            + columnNameAsColumnTitle(Tables.UserType.classsearchform) + ","
            + columnNameAsColumnTitle(Tables.UserType.classaddbutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.classupdatebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.classdeletebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.classwritebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.databaseui) + ","
            + columnNameAsColumnTitle(Tables.UserType.personform) + ","
            + columnNameAsColumnTitle(Tables.UserType.personsearchform) + ","
            + columnNameAsColumnTitle(Tables.UserType.personaddbutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.personupdatebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.persondeletebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.personwritebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.publisherform) + ","
            + columnNameAsColumnTitle(Tables.UserType.publishersearchform) + ","
            + columnNameAsColumnTitle(Tables.UserType.publisheraddbutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.publisherupdatebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.publisherdeletebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.publisherwritebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.schoolform) + ","
            + columnNameAsColumnTitle(Tables.UserType.schoolsearchform) + ","
            + columnNameAsColumnTitle(Tables.UserType.schooladdbutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.settings) + ","
            + columnNameAsColumnTitle(Tables.UserType.studentform) + ","
            + columnNameAsColumnTitle(Tables.UserType.studentsearchform) + ","
            + columnNameAsColumnTitle(Tables.UserType.studentaddbutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.studentupdatebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.studentdeletebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.studentwritebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.userform) + ","
            + columnNameAsColumnTitle(Tables.UserType.usersearchform) + ","
            + columnNameAsColumnTitle(Tables.UserType.useraddbutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.userupdatebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.userdeletebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.userwritebutton) + ","
            + columnNameAsColumnTitle(Tables.UserType.usertypeform)
            + " FROM usertype";

    @Override
    public List<UserTypeModel> getAll() {
        List<UserTypeModel> userTypeList = null;
        ResultSet resultSet = createResultSet(ALL_USERTYPE_QUERY);
        try {
            userTypeList = new ArrayList<>();
            while (resultSet.next()) {
                userTypeList.add(new UserTypeModel(resultSet.getInt(columnTitleWithOutPrime(Tables.UserType.usertypeid)), resultSet.getString(columnTitleWithOutPrime(Tables.UserType.usertypename))));
            }
        } catch (SQLException ex) {
            getLogger(ex, "GetAll Exception ", UserTypeDaoImpl.class.getName());
        }
        return userTypeList;
    }

    @Override
    public UserTypeModel get(int id) {
        UserTypeModel userTypeModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, USERTYPE_OPTION_SELECTION_QUERY, " WHERE ", Tables.UserType.usertypeid + "="));
        try {
            userTypeModel = new UserTypeModel();
            while (resultSet.next()) {
                userTypeModel.setUserTypeId(resultSet.getInt(columnTitleWithOutPrime(Tables.UserType.usertypeid)));
                userTypeModel.setUserTypeName(resultSet.getString(columnTitleWithOutPrime(Tables.UserType.usertypename)));
                userTypeModel.setAuthorform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.authorform)));
                userTypeModel.setAuthorsearchform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.authorsearchform)));
                userTypeModel.setAuthoraddbutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.authoraddbutton)));
                userTypeModel.setAuthorupdatebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.authorupdatebutton)));
                userTypeModel.setAuthordeletebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.authordeletebutton)));
                userTypeModel.setAuthorwritebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.authorwritebutton)));
                userTypeModel.setBookform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.bookform)));
                userTypeModel.setBooksearchform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.booksearchform)));
                userTypeModel.setBookaddbutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.bookaddbutton)));
                userTypeModel.setBookupdatebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.bookupdatebutton)));
                userTypeModel.setBookdeletebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.bookdeletebutton)));
                userTypeModel.setBookwritebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.bookwritebutton)));
                userTypeModel.setBooktypeform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.booktypeform)));
                userTypeModel.setBooktypesearchform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.booktypesearchform)));
                userTypeModel.setBookaddbutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.booktypeaddbutton)));
                userTypeModel.setBooktypeupdatebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.booktypeupdatebutton)));
                userTypeModel.setBooktypedeletebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.booktypedeletebutton)));
                userTypeModel.setBooktypewritebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.booktypewritebutton)));
                userTypeModel.setBookborrowform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.bookborrowform)));
                userTypeModel.setFinishborrowform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.finishborrowform)));
                userTypeModel.setStartborrowform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.startborrowform)));
                userTypeModel.setClassform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.classform)));
                userTypeModel.setClasssearchform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.classsearchform)));
                userTypeModel.setClassaddbutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.classaddbutton)));
                userTypeModel.setClassupdatebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.classupdatebutton)));
                userTypeModel.setClassdeletebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.classdeletebutton)));
                userTypeModel.setClasswritebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.classwritebutton)));
                userTypeModel.setDatabaseui(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.databaseui)));
                userTypeModel.setPersonform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.personform)));
                userTypeModel.setPersonsearchform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.personsearchform)));
                userTypeModel.setPersonaddbutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.personaddbutton)));
                userTypeModel.setPersonupdatebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.personupdatebutton)));
                userTypeModel.setPersondeletebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.persondeletebutton)));
                userTypeModel.setPersonwritebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.personwritebutton)));
                userTypeModel.setPublisherform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.publisherform)));
                userTypeModel.setPublishersearchform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.publishersearchform)));
                userTypeModel.setPublisheraddbutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.publisheraddbutton)));
                userTypeModel.setPublisherupdatebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.publisherupdatebutton)));
                userTypeModel.setPublisherdeletebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.publisherdeletebutton)));
                userTypeModel.setPublisherwritebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.publisherwritebutton)));
                userTypeModel.setSchoolform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.schoolform)));
                userTypeModel.setSchoolsearchform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.schoolsearchform)));
                userTypeModel.setSchooladdbutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.schooladdbutton)));
                userTypeModel.setSettings(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.settings)));
                userTypeModel.setStudentform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.studentform)));
                userTypeModel.setStudentsearchform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.studentsearchform)));
                userTypeModel.setStudentaddbutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.studentaddbutton)));
                userTypeModel.setStudentupdatebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.studentupdatebutton)));
                userTypeModel.setStudentdeletebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.studentdeletebutton)));
                userTypeModel.setStudentwritebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.studentwritebutton)));
                userTypeModel.setUserform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.userform)));
                userTypeModel.setUsersearchform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.usersearchform)));
                userTypeModel.setUseraddbutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.useraddbutton)));
                userTypeModel.setUserupdatebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.userupdatebutton)));
                userTypeModel.setUserdeletebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.userdeletebutton)));
                userTypeModel.setUserwritebutton(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.userwritebutton)));
                userTypeModel.setUsertypeform(resultSet.getBoolean(columnTitleWithOutPrime(Tables.UserType.usertypeform)));
            }
        } catch (SQLException ex) {
            getLogger(ex, "Get UserType Error", UserTypeDaoImpl.class.getName());
        }

        return userTypeModel;
    }

    @Override
    public void add(UserTypeModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(UserTypeModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(UserTypeModel v) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(USERTYPE_DELETE_QUERY);
        try {
            preparedStatement.setInt(1, v.getUserTypeId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, " UserType Add Error", UserTypeDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public TableModel search(String searchText) {
        String query = ALL_USERTYPE_QUERY;
        query += " WHERE ";
        query += "(";
        query += Tables.UserType.usertypeid + " LIKE '" + searchText + "%' OR ";
        query += Tables.UserType.usertypename + " LIKE '" + searchText + "%' ";
        query += ")";
        return DbUtils.resultSetToTableModel(createResultSet(query));
    }

    @Override
    public TableModel options() {
        String query = USERTYPE_OPTION_SELECTION_QUERY;
        return ListUtils.resultSetToTableModel(createResultSet(query));
    }
}
