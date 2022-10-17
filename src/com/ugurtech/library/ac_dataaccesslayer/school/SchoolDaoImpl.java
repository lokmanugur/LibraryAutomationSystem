/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.school;

import com.ugurtech.library.ab_application.af_lib.sql.DbUtils;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ac_dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.ad_model.SchoolModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * 
 */
public class SchoolDaoImpl extends DaoAbstract implements SchoolDao {

    public static final String SCHOOL_INSERT_QUERY = "INSERT INTO school (schoolname,phone,address) VALUES(?,?,?)";
    public static final String SCHOOL_UDATE_QUERY = "UPDATE school SET schoolname=?,address=?,phone=? WHERE schoolid=?";
    public static final String SCHOOL_DELETE_QUERY = "DELETE FROM school WHERE schoolid=?";
    public static final String SCHOOL_SEARCH_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.school + ".schoolid") + ","
            + columnNameAsColumnTitle(Tables.school + ".schoolname") + ","
            + columnNameAsColumnTitle(Tables.school + ".phone") + ","
            + columnNameAsColumnTitle(Tables.school + ".address")
            + " FROM school ";

    private List<SchoolModel> schoolList;

    @Override
    public TableModel search(String str) {
        String query = "";
        query += SCHOOL_SEARCH_QUERY;
        query += " WHERE";
        query += " " + columnTitleWithPrime(Tables.School.schoolid) + " LIKE '" + str + "%'";
        query += " OR " + columnTitleWithPrime(Tables.School.schoolname) + " LIKE '" + str + "%'";
        query += " OR " + columnTitleWithPrime(Tables.School.phone) + " LIKE '" + str + "%'";
        query += " OR " + columnTitleWithPrime(Tables.School.address) + " LIKE '" + str + "%'";
        return DbUtils.resultSetToTableModel(createResultSet(query));
    }

    @Override
    public List<SchoolModel> getAll() {
        if (schoolList != null) {
            if (!schoolList.isEmpty()) {
                schoolList.clear();
            }
        } else {
            schoolList = new ArrayList<>();
        }
        ResultSet resultSet = createResultSet(SCHOOL_SEARCH_QUERY);
        try {
            SchoolModel schoolModel;
            while (resultSet.next()) {
                schoolModel = new SchoolModel();
                schoolModel.setSchoolId(resultSet.getInt(columnTitleWithOutPrime(Tables.school + ".schoolid")));
                schoolModel.setSchoolName(resultSet.getString(columnTitleWithOutPrime(Tables.school + ".schoolname")));
                schoolModel.setPhone(resultSet.getString(columnTitleWithOutPrime(Tables.school + ".phone")));
                schoolModel.setAddress(resultSet.getString(columnTitleWithOutPrime(Tables.school + ".address")));
                schoolList.add(schoolModel);
            }
        } catch (SQLException ex) {
            getLogger(ex,"GetAll Exception ",SchoolDaoImpl.class.getName());
        }
        return schoolList;
    }

    @Override
    public SchoolModel get(int id) {

        SchoolModel schoolModel = null;
        ResultSet resultSet = createResultSet(getExistID(id,
                        SCHOOL_SEARCH_QUERY,
                        " WHERE ",
                        columnTitleWithOutPrime(Tables.school + ".schoolid"), "="));
        try {
            schoolModel = new SchoolModel();
            if (resultSet.next()) {
                schoolModel.setSchoolId(resultSet.getInt(columnTitleWithOutPrime(Tables.school + ".schoolid")));
                schoolModel.setSchoolName(resultSet.getString(columnTitleWithOutPrime(Tables.school + ".schoolname")));
                schoolModel.setPhone(resultSet.getString(columnTitleWithOutPrime(Tables.school + ".phone")));
                schoolModel.setAddress(resultSet.getString(columnTitleWithOutPrime(Tables.school + ".address")));
            }
        } catch (SQLException ex) {
            getLogger(ex,"Get Exception ",SchoolDaoImpl.class.getName());
        }
        return schoolModel;
    }

    @Override
    public void add(SchoolModel schoolModel) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(SCHOOL_INSERT_QUERY);
        try {
            preparedStatement.setString(1, schoolModel.getSchoolName());
            preparedStatement.setString(2, schoolModel.getPhone());
            preparedStatement.setString(3, schoolModel.getAddress());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex,"Add Exception ",SchoolDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public void update(SchoolModel schoolModel) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(SCHOOL_UDATE_QUERY);
        try {
            preparedStatement.setString(1, schoolModel.getSchoolName());
            preparedStatement.setString(2, schoolModel.getPhone());
            preparedStatement.setString(3, schoolModel.getAddress());
            preparedStatement.setInt(4, schoolModel.getSchoolId());
            int affectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(affectedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex,"Update Exception ",SchoolDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public void delete(SchoolModel schoolModel) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(SCHOOL_DELETE_QUERY);
        try {
            preparedStatement.setInt(1, schoolModel.getSchoolId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex,"Delete Exception ",SchoolDaoImpl.class.getName());
        }
        commit();
    }

}
