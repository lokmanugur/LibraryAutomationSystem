/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.dataaccesslayer.login;

import com.ugurtech.library.model.CurrentUserModel;
import com.ugurtech.library.dataaccesslayer.DaoAbstract;
import com.ugurtech.library.model.responsmodels.UserTypeModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Teacher
 * 
 */
public class LoginDaoImpl extends DaoAbstract<CurrentUserModel> implements LoginDao{
    private static final String SEARCH_SYSTEM_USER = "SELECT * FROM sysuser";
    private static final String USER_LOGIN = "SELECT s.sysuserid,s.usertypeid,s.personid,s.username,s.userpassword,s.createddate,s.lastupdate,s.sessiontime,"
            + "p.firstname,p.lastname,p.phone,p.address,p.birthdate,"
            + "c.abbriviation,l.abbriviation "
            + "FROM sysuser s, person p,country c, language l ";
    
    @Override
    public List<CurrentUserModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CurrentUserModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(CurrentUserModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(CurrentUserModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(CurrentUserModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean checkExistUsers() {
        try {
            return createResultSet(SEARCH_SYSTEM_USER).next();
        } catch (SQLException ex) {
            getLogger(ex,"Check Empty Databese Error",LoginDaoImpl.class.getName());
            return false;
        }
    }

    @Override
    public boolean checkUser(CurrentUserModel currentUser) {
            StringBuilder query = new StringBuilder(USER_LOGIN);
            query.append("WHERE s.username = '").append(currentUser.getUserName()).append("' ");
            query.append("AND s.userpassword = '").append(currentUser.getUserPassword()).append("' ");
            query.append("AND s.personid = p.personid AND s.languageid=l.languageid AND s.countryid=c.countryid ");

        try {
            ResultSet resultSet;
            resultSet = createResultSet(query.toString());
            if (resultSet.next()) {
                currentUser.setSysUserId(resultSet.getInt("sysuserid"));
                currentUser.setUserTypeModel(new UserTypeModel(resultSet.getInt("usertypeid")));
                currentUser.setPersonId(resultSet.getInt("personid"));
                currentUser.setUserName(resultSet.getString("username"));
                currentUser.setFirstName(resultSet.getString("firstname"));
                currentUser.setLastName(resultSet.getString("lastname"));
                currentUser.setUserPassword(resultSet.getString("userpassword"));
                currentUser.setBirthDate(resultSet.getLong("birthdate"));
                currentUser.setPhone(resultSet.getString("phone"));
                currentUser.setAddress(resultSet.getString("address"));
                currentUser.setCreatedDate(resultSet.getLong("createddate"));
                currentUser.setLastUpdate(resultSet.getLong("lastupdate"));
                currentUser.setSessionTime(resultSet.getInt("sessiontime"));
                currentUser.setRegion(resultSet.getString(13));
                currentUser.setLanguage(resultSet.getString(14));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            getLogger(ex,"Check User Error",LoginDaoImpl.class.getName());
            return false;
        }
    }
}
