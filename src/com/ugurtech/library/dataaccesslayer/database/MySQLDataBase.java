/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.database;

import com.ugurtech.library.presentation.view.logFrame.LogInternalFrame;
import java.sql.*;

public class MySQLDataBase extends Database{
    
    private static MySQLDataBase mySQLDataBase;
    
    public static MySQLDataBase getInstance(){
        if(mySQLDataBase == null)
           return mySQLDataBase = new MySQLDataBase();
        else
            return mySQLDataBase;
    }
   
    public Connection openDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String databaseUrl = "jdbc:mysql://"+getDataBaseServer()+":"+getPortNumber()+"/"+getDatabaseName()+"?useUnicode=true&characterEncoding=UTF-8";
            setConnection(DriverManager.getConnection(databaseUrl,getUserName(),getUserPassword()));
            setStatement(getConnection().createStatement());
            
        }catch(ClassNotFoundException | SQLException ex){
            LogInternalFrame.INSTANCE.exceptionInfoMessages(MySQLDataBase.class.getName(),ex,"Open Database Error");
            
        }
        return getConnection();
    }
         // close and cleanup
    public void closeDatabase(){           
        try {
            getStatement().close();
            getConnection().close();
        }catch (SQLException ex){  
            LogInternalFrame.INSTANCE.exceptionInfoMessages(MySQLDataBase.class.getName(),ex,"Close Database Error");
        }
    }
}