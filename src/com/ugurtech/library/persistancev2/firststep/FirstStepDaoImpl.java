/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.persistancev2.firststep;

import com.ugurtech.library.modelv2.requestmodels.FirstStepModel;
import com.ugurtech.library.persistancev2.DaoAbstract;
import com.ugurtech.library.service.validation.UserInfoMessages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teacher
 */
public class FirstStepDaoImpl extends DaoAbstract implements FirstStepDao {

    private static final String INSERT_PERSON = "INSERT INTO person (firstname,lastname,birthdate,address,phone,createddate) VALUES (?, ?, ?, ?, ?,?)";
    private static final String INSERT_SYSTEM_USER = "INSERT INTO sysuser (personid,usertypeid,countryid,languageid,username,userpassword,sessiontime,createddate) VALUES (?,?,?,?,?,?,?,?)";


    @Override
    public List<FirstStepModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FirstStepModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(FirstStepModel v) {
        PreparedStatement preparedStatement = createPrepareStatement(INSERT_PERSON);
        try {
            preparedStatement.setString(1, v.getFirstName());
            preparedStatement.setString(2, v.getLastName());
            preparedStatement.setLong(3, v.getBirthDate());
            preparedStatement.setString(4, v.getAddress());
            preparedStatement.setString(5, v.getPhone());
            long date = new Date().getTime();
            preparedStatement.setLong(6, date);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            preparedStatement = createPrepareStatement(INSERT_SYSTEM_USER);
            preparedStatement.setInt(1, resultSet.getInt(1));
            preparedStatement.setInt(2, v.getUserTypeId());
            preparedStatement.setInt(3, v.getCountryId());
            preparedStatement.setInt(4, v.getLanguageId());
            preparedStatement.setString(5, v.getUserName());
            preparedStatement.setString(6, v.getPassword());
            preparedStatement.setInt(7, v.getSessionTime());
            preparedStatement.setLong(8, date);
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(FirstStepModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(FirstStepModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(FirstStepModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
