/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer;

import com.ugurtech.library.ac_dataaccesslayer.database.SQLiteDatabase;
import com.ugurtech.library.ab_application.af_lib.localization.Internationalization;
import com.ugurtech.library.ab_application.af_lib.localization.LanguageImpl;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugur
 *
 */
public abstract class DaoAbstract {

    private SQLiteDatabase dataBase;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public DaoAbstract() {
    }

    public SQLiteDatabase openConnection() {
        dataBase = SQLiteDatabase.getInstance();
        return dataBase;
    }

    public boolean isClosed() {
        boolean isClose = false;
        try {
            isClose = dataBase.getConnection().isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(DaoAbstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isClose;
    }

    public void closeConnection() {
        try {
            statement.close();
            dataBase.getConnection().close();
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Database Close Error");
            Logger.getLogger(DaoAbstract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Statement createStatemen() {

        try {
            openConnection();
            statement = dataBase.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DaoAbstract.class.getName()).log(Level.SEVERE, null, ex);
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Database CreateStatment Error");
        }
        return statement;
    }

    /**
     * executes a SELECT statement
     *
     * @param sqlQuery Sql string query
     * @return returns a ResultSet object which contains results returned by the
     * query
     */
    public ResultSet createResultSet(String sqlQuery) {
        try {
            openConnection();
            resultSet = createStatemen().executeQuery(sqlQuery);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Database CreateResultset Error");
            Logger.getLogger(DaoAbstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    /**
     * executes an INSERT, UPDATE or DELETE statement (e.g. 1 row inserted, or 2
     * rows updated, or 0 rows affected).
     *
     * @param sqlQuery Sql String query
     * @return update account indicating number of rows affected
     */
    public PreparedStatement createPrepareStatement(String sqlQuery) {

        try {
            openConnection();
            preparedStatement = dataBase.getConnection().prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Database CreatePrepareStatment Error");
            Logger.getLogger(DaoAbstract.class.getName()).log(Level.SEVERE, null, ex);
        }

        return preparedStatement;
    }

    public int executeUpdate() {
        int efactedRow = 0;
        try {
            efactedRow = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Database ExecuteUpdate Error");
            Logger.getLogger(DaoAbstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        return efactedRow;
    }

    protected static String setLanguage(String strng) {
        return LanguageImpl.setLanguage(Internationalization::setLanguage, strng);
    }
    
    protected static<V> String setLanguage(V v) {
        return LanguageImpl.setLanguage(Internationalization::setLanguage, v.toString());
    }

    protected static <V> String getTableTitle(V tableColumn) {
        return tableColumn + " as " + setLanguage(tableColumn.toString());
    }

    protected String getExistID(int id, String... strQuery) {
        String string ="";
        for (String str : strQuery) {
            string +=str;
        }
        if(id>0){
            string +=String.valueOf(id);
        }
       return string;
    }

    public void getLogger(SQLException ex,String errorTitle,String className){
        UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), errorTitle);
        Logger.getLogger(className).log(Level.SEVERE, null, ex);
    }    

}
