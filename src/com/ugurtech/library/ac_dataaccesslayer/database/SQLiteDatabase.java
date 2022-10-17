/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.database;

import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import java.nio.file.Paths;
import java.sql.*;

public class SQLiteDatabase {

    private static SQLiteDatabase sqLiteDatabase;
    private Connection connection;

    public static SQLiteDatabase getInstance() {
        if (sqLiteDatabase == null) {
            return sqLiteDatabase = new SQLiteDatabase();
        } else {
            return sqLiteDatabase;
        }
    }

    private SQLiteDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            String databaseUrl = "jdbc:sqlite:" + Paths.get("").toAbsolutePath().toString() + "/SQLite/library.sqlite";
            connection = DriverManager.getConnection(databaseUrl);
        } catch (ClassNotFoundException | SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(sqLiteDatabase.getClass().getName(), ex.getMessage(), "File Not Found or SQLException");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
