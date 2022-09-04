/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.ac_dataaccesslayer.login;

import com.ugurtech.library.ad_model.CurrentUserModel;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ac_dataaccesslayer.firststep.FirstStepDaoImpl;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teacher
 * 
 */
public class LoginDaoImpl extends DaoAbstract implements LoginDao{
    private static final String SEARCH_SYSTEM_USER = "SELECT * FROM sysuser";
    private static final String SYSUSER_DELETE_QUERY = "UPDATE sysuser SET lastupdate=?, deleted=? WHERE sysuserid=?";
    private static final String USERTYPE_SEARCH_QUERY = "SELECT * FROM  usertype";
    private static final String PERSON_SEARCH_QUERY = "SELECT p.personid,p.firstname,p.lastname,p.birthdate,p.phone,p.address "
            + "FROM person p "
            + "LEFT JOIN author a ON p.personid=a.personid "
            + "WHERE a.personid IS NULL AND p.deleted=0";
    private static final String SYSUSER_INSERT_QUERY = "INSERT INTO sysuser(personid,usertypeid,username,userpassword,createddate) VALUES(?,?,?,?,?)";
    private static final String SYSUSER_SEARCH_QUERY = "SELECT s.sysuserid as Kullanıcı_No,p.firstname as Adı,"
            + "p.lastname as Soyadı,u.usertypename as Kullanıcı_Tipi,s.createddate as Oluşturma_Tarihi,"
            + "s.lastupdate as Son_Güncelleme_tarihi "
            + "FROM sysuser s, usertype u,person p ";
    private static final String USER_LOGIN = "SELECT s.sysuserid,s.personid,s.username,s.userpassword,s.createddate,s.lastupdate,s.sessiontime,"
            + "p.firstname,p.lastname,p.phone,p.address,p.birthdate,"
            + "c.abbriviation,l.abbriviation "
            + "FROM sysuser s, person p,country c, language l ";
    private static final String EXIST_USERS = "SELECT * FROM sysuser";
    
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
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Check User Error");
            Logger.getLogger(FirstStepDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                currentUser.setPersonId(resultSet.getInt("personid"));
                currentUser.setUserName(resultSet.getString("username"));
                currentUser.setFirstName(resultSet.getString("firstname"));
                currentUser.setLastName(resultSet.getString("lastname"));
                currentUser.setUserPassword(resultSet.getString("userpassword"));
                currentUser.setBirthDate(resultSet.getDate("birthdate").getTime());
                currentUser.setPhone(resultSet.getString("phone"));
                currentUser.setAddress(resultSet.getString("address"));
                currentUser.setCreatedDate(resultSet.getDate("createddate").getTime());
                currentUser.setLastUpdate(resultSet.getDate("lastupdate").getTime());
                currentUser.setSessionTime(resultSet.getInt("sessiontime"));
                currentUser.setRegion(resultSet.getString(13));
                currentUser.setLanguage(resultSet.getString(14));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Check User Error");
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
