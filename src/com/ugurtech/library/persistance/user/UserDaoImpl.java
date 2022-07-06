/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package com.ugurtech.library.persistance.user;

import com.ugurtech.library.persistance.DaoAbstract;
import com.ugurtech.library.persistance.person.PersonDaoImpl;
import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.model.PersonModel;
import com.ugurtech.library.model.CurrentUserModel;
import com.ugurtech.library.model.UserModel;
import com.ugurtech.library.model.UserTypeModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugur
 *
 */
public class UserDaoImpl extends DaoAbstract implements UserDao {

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
    private static final String USER_LOGIN = "SELECT s.sysuserid,s.personid,s.username,s.userpassword,p.firstname,p.lastname,p.phone,p.address,p.birthdate,s.createddate,s.lastupdate "
                + "FROM sysuser s, person p ";

    public boolean checkUser(CurrentUserModel currentUser) {
            StringBuilder query = new StringBuilder(USER_LOGIN);
            query.append("WHERE s.username = '").append(currentUser.getUserName()).append("' ");
            query.append("AND s.userpassword = '").append(currentUser.getUserPassword()).append("' ");
            query.append("AND s.personid = p.personid AND s.deleted=0");

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
                currentUser.setBirthDate(resultSet.getDate("birthdate"));
                currentUser.setPhone(resultSet.getString("phone"));
                currentUser.setAddress(resultSet.getString("address"));
                currentUser.setCreatedDate(new java.sql.Date(resultSet.getDate("createddate").getTime()));
                currentUser.setLastUpdate(new java.sql.Date(resultSet.getDate("lastupdate").getTime()));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Check User Error");
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<PersonModel> allPerson() {
        List<PersonModel> personLists = new ArrayList<>();
        PersonModel personModel;
        ResultSet resultSet = createResultSet(PERSON_SEARCH_QUERY);
        try {
            while (resultSet.next()) {
                personModel = new PersonModel();
                personModel.setPersonId(resultSet.getInt("personid"));
                personModel.setFirstName(resultSet.getString("firstname"));
                personModel.setLastName(resultSet.getString("lastname"));
                personModel.setBirthDate(resultSet.getDate("birthdate"));
                personModel.setPhone(resultSet.getString("phone"));
                personModel.setAddress(resultSet.getString("address"));
                personLists.add(personModel);
            }
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Search Error");
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personLists;
    }

    @Override
    public ResultSet fillAllUser(Map<String, String> filters) {
        StringBuilder query = new StringBuilder(SYSUSER_SEARCH_QUERY);
        query.append("WHERE s.personid=p.personid ");
        query.append("AND s.usertypeid=u.usertypeid ");
        query.append("AND s.deleted=0 ");
        fillFilter(query, filters);
        return createResultSet(query.toString());
    }

    @Override
    public UserModel getUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(UserModel userModel) {
        PreparedStatement preparedStatement = createPrepareStatement(SYSUSER_INSERT_QUERY);
        try {
            preparedStatement.setInt(1, userModel.getPersonId());
            preparedStatement.setInt(2, userModel.getUserTypeId());
            preparedStatement.setString(3, userModel.getUserName());
            preparedStatement.setString(4, userModel.getUserPassword());
            preparedStatement.setString(5, new Date().toString());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateUser(UserModel userModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(int userId) {
        PreparedStatement preparedStatement = createPrepareStatement(SYSUSER_DELETE_QUERY);
        try {
            preparedStatement.setBoolean(2, true);
            preparedStatement.setString(1, new Date().toString());
            preparedStatement.setInt(3, userId);
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Delete Query Error");
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<UserTypeModel> allUserType() {
        UserTypeModel userTypeModel;
        List<UserTypeModel> userTypeLists = new ArrayList<>();
        ResultSet resultSet = createResultSet(USERTYPE_SEARCH_QUERY);
        try {
            while (resultSet.next()) {
                userTypeModel = new UserTypeModel();
                userTypeModel.setUserTypeId(resultSet.getInt("usertypeid"));
                userTypeModel.setUserTypeName(resultSet.getString("usertypename"));
                userTypeModel.setCreatedDate(resultSet.getDate("createddate"));
                userTypeModel.setLastUpdate(resultSet.getDate("lastupdate"));
                userTypeLists.add(userTypeModel);
            }
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Search Error");
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userTypeLists;
    }

    private void fillFilter(StringBuilder query, Map<String, String> filters) {
        if (!filters.isEmpty()) {
            if (filters.containsKey("userId")) {
                query.append("AND ");
                query.append("s.sysuserid ");
                query.append("LIKE '");
                query.append(filters.get("userId"));
                query.append("%'");
            }
            if (filters.containsKey("userName")) {
                query.append("AND ");
                query.append("(p.firstname || ' ' || p.lastname) ");
                query.append("LIKE '%");
                query.append(filters.get("userName"));
                query.append("%'");
            }
        }
    }

}
