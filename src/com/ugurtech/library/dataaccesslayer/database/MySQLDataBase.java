/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.database;

import com.ugurtech.library.presentation.view.logFrame.LogInternalFrame;
import com.ugurtech.library.service.database.DatabaseServiceImpl;
import java.sql.*;

public class MySQLDataBase implements DatabaseDao {
    
    private Connection connection;
    private Statement statement;
    private final DatabaseServiceImpl databaseService;

    public MySQLDataBase() {
        this.databaseService = new DatabaseServiceImpl();
    }
    public Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String databaseUrl = "jdbc:mysql://"+databaseService.get().getIpAdress()+":"+databaseService.get().getPortNumber()+"/"+databaseService.get().getDatabaseName()+"?useUnicode=true&characterEncoding=UTF-8";
            connection = DriverManager.getConnection(databaseUrl,databaseService.get().getUserName(),databaseService.get().getPassword());
            statement = connection.createStatement();
            
        }catch(ClassNotFoundException | SQLException ex){
            LogInternalFrame.INSTANCE.exceptionInfoMessages(MySQLDataBase.class.getName(),ex,"Open Database Error");
        }
        return connection;
    }
         // close and cleanup
    public void closeConnection(){           
        try {
            statement.close();
            connection.close();
        }catch (SQLException ex){  
            LogInternalFrame.INSTANCE.exceptionInfoMessages(MySQLDataBase.class.getName(),ex,"Close Database Error");
        }
    }
}