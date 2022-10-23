/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer;

import com.ugurtech.library.dataaccesslayer.database.SQLiteDatabase;
import com.ugurtech.library.application.lib.localization.Internationalization;
import com.ugurtech.library.application.lib.localization.LanguageImpl;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.dataaccesslayer.borrow.BorrowDaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            getLogger(ex,"isClosed Method Exception",DaoAbstract.class.getName());
        }
        return isClose;
    }

    public void closeConnection() {
        try {
            statement.close();
            dataBase.getConnection().close();
        } catch (SQLException ex) {
            getLogger(ex,"CloseConnectin Method Exception",DaoAbstract.class.getName());
        }
    }

    public Statement createStatemen() {

        try {
            openConnection();
            statement = dataBase.getConnection().createStatement();
        } catch (SQLException ex) {
            getLogger(ex,"Create Statment Exception",DaoAbstract.class.getName());
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
            getLogger(ex,"CreateResoultSet Exception",DaoAbstract.class.getName());
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
            getLogger(ex,"createPrepareStatement Exception",DaoAbstract.class.getName());
        }

        return preparedStatement;
    }

    public int executeUpdate() {
        int efactedRow = 0;
        try {
            efactedRow = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            getLogger(ex,"ExecuteUpdate Exception",DaoAbstract.class.getName());
        }
        return efactedRow;
    }

    protected static String columnTitleWithOutPrime(String columnName) {
        String value = LanguageImpl.setLanguage(Internationalization::setLanguage, columnName).replaceAll("'", "");
        return value;
    }

    protected static <V> String columnTitleWithOutPrime(V columnName) {
        String value = LanguageImpl.setLanguage(Internationalization::setLanguage, columnName.toString()).replaceAll("'", "");
        return value;
    }

    protected static String columnValue(String columnValue) {
        return LanguageImpl.setLanguage(Internationalization::setLanguage, columnValue);
    }

    protected static <V> String columnValue(V columnValue) {
        return LanguageImpl.setLanguage(Internationalization::setLanguage, columnValue.toString());
    }

    protected static <V> String columnTitleWithPrime(V columnName) {
        return LanguageImpl.setLanguage(Internationalization::setLanguage, columnName.toString());
    }

    protected static <V> String columnNameAsColumnTitle(V columnName) {
        return columnName + " as " + LanguageImpl.setLanguage(Internationalization::setLanguage, columnName.toString());
    }

    protected String getExistID(int id, String... strQuery) {
        String string = "";
        for (String str : strQuery) {
            string += str;
        }
        if (id > 0) {
            string += String.valueOf(id);
        }
        return string;
    }

    public void getLogger(SQLException exception, String errorTitle, String className) {
        UserInfoMessages.getInstance().exceptionInfoMessages(className, exception.toString(), errorTitle);
    }

    protected void beginTransection() {
        try {
            createPrepareStatement("BEGIN TRANSACTION; ").executeUpdate();
        } catch (SQLException ex) {
            getLogger(ex, "Begin Transection error", DaoAbstract.class.getName());
        }
    }

    protected void rollBack() {
        try {
            createPrepareStatement("ROLLBACK;").executeUpdate();
        } catch (SQLException ex) {
            getLogger(ex, "Transection rollback error", BorrowDaoImpl.class.getName());
        }
    }

    protected void commit() {
        try {
            createPrepareStatement("COMMIT;").executeUpdate();
        } catch (SQLException ex) {
            getLogger(ex, "Transection Commit error", BorrowDaoImpl.class.getName());
        }
    }

}
