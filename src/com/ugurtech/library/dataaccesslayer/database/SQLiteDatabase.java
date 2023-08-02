/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.database;

import com.ugurtech.library.presentation.view.logFrame.LogInternalFrame;
import com.ugurtech.library.service.database.DatabaseServiceImpl;
import java.nio.file.Paths;
import java.sql.*;

public class SQLiteDatabase {

    public static final SQLiteDatabase INSTANCE = new SQLiteDatabase();
    private DatabaseServiceImpl databaseService = new DatabaseServiceImpl();
    private Connection connection;

    private SQLiteDatabase() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            String databaseUrl = "jdbc:sqlite:" + Paths.get("").toAbsolutePath().toString() + databaseService.get().getFilePath();
            connection = DriverManager.getConnection(databaseUrl);
        } catch (ClassNotFoundException | SQLException ex) {
            LogInternalFrame.INSTANCE.exceptionInfoMessages(INSTANCE.getClass().getName(), ex, "File Not Found or SQLException");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
