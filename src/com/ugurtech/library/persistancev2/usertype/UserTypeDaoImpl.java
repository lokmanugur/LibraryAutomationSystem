/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.persistancev2.usertype;

import com.ugurtech.library.modelv2.responsmodels.UserTypeModel;
import com.ugurtech.library.persistance.DaoAbstract;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teacher
 */
public class UserTypeDaoImpl extends DaoAbstract implements UserTypeDao {
    public static final String ALL_COUNTRY_QUERY="SELECT * FROM usertype";
    
    @Override
    public List<UserTypeModel> getAll() {
                List<UserTypeModel> userTypeList = new ArrayList<>();
        ResultSet resultSet = createResultSet(ALL_COUNTRY_QUERY);
        try {
            while(resultSet.next())
            userTypeList.add(new UserTypeModel(resultSet.getInt("usertypeid"),resultSet.getString("usertypename")));
        } catch (SQLException ex) {
            Logger.getLogger(UserTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userTypeList;
    }

    @Override
    public UserTypeModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
