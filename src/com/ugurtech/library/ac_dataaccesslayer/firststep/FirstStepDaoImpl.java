/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.ac_dataaccesslayer.firststep;

import com.ugurtech.library.ad_model.requestmodels.FirstStepModel;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
        beginTransection();
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
            rollBack();
            getLogger(ex,"FirstStep Exception ",FirstStepModel.class.getName());
        }
        commit();
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
