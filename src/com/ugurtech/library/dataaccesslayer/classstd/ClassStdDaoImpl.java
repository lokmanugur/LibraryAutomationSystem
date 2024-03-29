/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.classstd;

import resources.lib.sql.DbUtils;
import resources.lib.validation.UserInfoMessages;
import com.ugurtech.library.dataaccesslayer.DaoAbstract;
import com.ugurtech.library.dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.model.ClassModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class ClassStdDaoImpl extends DaoAbstract<ClassModel> implements ClassStdDao {

public static final String CLSS_INSERT_QUERY = "INSERT INTO clss (classname) VALUES(?)";
    public static final String CLSS_DELETE_QUERY = "DELETE FROM clss WHERE classid=?";
    public static final String CLSS_UPDATE_QUERY = "UPDATE clss SET classname=? WHERE classid=?";
    public static final String CLSS_SEARCH_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.clss+".classid")+ ","
            + columnNameAsColumnTitle(Tables.clss+".classname")
            + " FROM clss ";


    private final List<ClassModel> classList;
    private final StringBuilder query;

    public ClassStdDaoImpl() {
        classList = new ArrayList<>();
        query = new StringBuilder();
    }

    @Override
    public List<ClassModel> getAll() {
        if (!classList.isEmpty()) {
            classList.clear();
        }
        ResultSet resultSet = createResultSet(CLSS_SEARCH_QUERY);
        try {
            while (resultSet.next()) {
                classList.add(new ClassModel(
                        resultSet.getInt(1), 
                        resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            getLogger(ex,"GetAll Exception ",ClassStdDaoImpl.class.getName());
        }
        return classList;
    }

    @Override
    public ClassModel get(int id) {
        ClassModel classModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, CLSS_SEARCH_QUERY," WHERE"," clss.classid="));
        try {
            classModel = new ClassModel();
            if (resultSet.next()) {
                classModel.setClassId(resultSet.getInt(1));
                classModel.setClassName(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            getLogger(ex,"Get Exception ",ClassStdDaoImpl.class.getName());
        }

        return classModel;
    }

    @Override
    public void add(ClassModel classModel) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(CLSS_INSERT_QUERY);
        try {
            preparedStatement.setString(1, classModel.getClssName());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex,"Add Exception ",ClassStdDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public void update(ClassModel classModel) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(CLSS_UPDATE_QUERY);
        try {
            preparedStatement.setString(1, classModel.getClssName());
            preparedStatement.setInt(2, classModel.getClassId());
            int affectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(affectedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex,"Update Exception ",ClassStdDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public void delete(ClassModel classModel) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(CLSS_DELETE_QUERY);
        try {
            preparedStatement.setInt(1, classModel.getClassId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex,"Delete Exception ",ClassStdDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public TableModel search(String str) {
        query.setLength(0);
        query.append(CLSS_SEARCH_QUERY);
        query.append(" WHERE");
        query.append(" (clss.classid").append(" LIKE '").append(str).append("%'");
        query.append(" or clss.classname").append(" LIKE '").append(str).append("%')");
        return DbUtils.resultSetToTableModel(createResultSet(query.toString()));
    }
    
}
