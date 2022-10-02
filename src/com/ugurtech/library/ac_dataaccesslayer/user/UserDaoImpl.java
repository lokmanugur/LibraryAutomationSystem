/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.user;

import com.ugurtech.library.ab_application.af_lib.sql.DbUtils;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ac_dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.ad_model.PersonModel;
import com.ugurtech.library.ad_model.UserModel;
import com.ugurtech.library.ad_model.responsmodels.CountryModel;
import com.ugurtech.library.ad_model.responsmodels.LanguageModel;
import com.ugurtech.library.ad_model.responsmodels.UserTypeModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 *
 */
public class UserDaoImpl extends DaoAbstract implements UserDao {

    public static String USER_INSERT_QUERY = "INSERT INTO sysuser(personid,usertypeid,countryid,languageid,username,userpassword,sessiontime,createddate) VALUES(?,?,?,?,?,?,?,?)";
    public static String USER_UPDATE_QUERY = "UPDATE sysuser SET personid=?,usertypeid=?,countryid=?,languageid=?,username=?,userpassword=?,sessiontime=?,lastupdate=? WHERE sysuserid=?";
    public static String USER_DELETE_QUERY = "DELETE FROM sysuser WHERE sysuserid=?";
    public static String USER_SEARCH_QUERY = "SELECT "
            +columnNameAsColumnTitle(Tables.SysUser.sysuserid)+","
            +columnNameAsColumnTitle(Tables.Person.firstname)+","
            +columnNameAsColumnTitle(Tables.Person.lastname)+","
            +columnNameAsColumnTitle(Tables.SysUser.username)+","
            +"CASE WHEN "+Tables.SysUser.userpassword+" NOT NULL"+" THEN '******' END AS "+columnValue(Tables.SysUser.userpassword)+","
            +columnNameAsColumnTitle(Tables.UserType.usertypename)+","
            +columnNameAsColumnTitle(Tables.Country.countryname)+","
            +columnNameAsColumnTitle(Tables.Language.languagename)+","
            +columnNameAsColumnTitle(Tables.SysUser.sessiontime)+","
            +columnNameAsColumnTitle(Tables.SysUser.createddate)+","
            +columnNameAsColumnTitle(Tables.SysUser.lastupdate)
            +" FROM "
            +Tables.sysuser+","
            +Tables.person+","
            +Tables.usertype+","
            +Tables.country+","
            +Tables.language
            +" WHERE "
            +Tables.SysUser.personid+"="+Tables.Person.personid+" AND "
            +Tables.SysUser.usertypeid+"="+Tables.UserType.usertypeid+" AND "
            +Tables.SysUser.countryid+"="+Tables.Country.countryid+" AND "
            +Tables.SysUser.languageid+"="+Tables.Language.languageid;
    
        public static String USER_SINGLE_SEARCH_QUERY = "SELECT "
            +columnNameAsColumnTitle(Tables.SysUser.sysuserid)+","
            +columnNameAsColumnTitle(Tables.Person.personid)+","
            +columnNameAsColumnTitle(Tables.Person.firstname)+","
            +columnNameAsColumnTitle(Tables.Person.lastname)+","
            +columnNameAsColumnTitle(Tables.SysUser.username)+","
            +columnNameAsColumnTitle(Tables.SysUser.userpassword)+","
            +columnNameAsColumnTitle(Tables.UserType.usertypeid)+","
            +columnNameAsColumnTitle(Tables.UserType.usertypename)+","
            +columnNameAsColumnTitle(Tables.Country.countryid)+","
            +columnNameAsColumnTitle(Tables.Country.countryname)+","
            +columnNameAsColumnTitle(Tables.Language.languageid)+","
            +columnNameAsColumnTitle(Tables.Language.languagename)+","
            +columnNameAsColumnTitle(Tables.SysUser.sessiontime)+","
            +columnNameAsColumnTitle(Tables.SysUser.createddate)+","
            +columnNameAsColumnTitle(Tables.SysUser.lastupdate)
            +" FROM "
            +Tables.sysuser+","
            +Tables.person+","
            +Tables.usertype+","
            +Tables.country+","
            +Tables.language
            +" WHERE "
            +Tables.SysUser.personid+"="+Tables.Person.personid+" AND "
            +Tables.SysUser.usertypeid+"="+Tables.UserType.usertypeid+" AND "
            +Tables.SysUser.countryid+"="+Tables.Country.countryid+" AND "
            +Tables.SysUser.languageid+"="+Tables.Language.languageid;

    @Override
    public TableModel search(String searchText) {
        String query=USER_SEARCH_QUERY;
        query+=" AND ";
        query+="(";
        query+=Tables.SysUser.sysuserid+" LIKE '"+searchText+"%' OR ";
        query+=Tables.SysUser.username+" LIKE '"+searchText+"%' OR ";
        query+=Tables.SysUser.sessiontime+" LIKE '"+searchText+"%' OR ";
        query+=Tables.Person.firstname+" LIKE '"+searchText+"%' OR ";
        query+=Tables.Person.lastname+" LIKE '"+searchText+"%' OR ";
        query+=Tables.Country.countryname+" LIKE '"+searchText+"%' OR ";
        query+=Tables.Language.languagename+" LIKE '"+searchText+"%'";
        query+=")";
        return DbUtils.resultSetToTableModel(createResultSet(query), columnTitleWithoutPrime(Tables.SysUser.createddate),columnTitleWithoutPrime(Tables.SysUser.lastupdate));
    }

    @Override
    public List<UserModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserModel get(int id) {
        UserModel userModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, USER_SINGLE_SEARCH_QUERY, " AND ", columnTitleWithoutPrime(Tables.SysUser.sysuserid)+"="));
        try {
            userModel = new UserModel();
            userModel.setCountryModel(new CountryModel());
            userModel.setLanguageModel(new LanguageModel());
            userModel.setUserTypeModel(new UserTypeModel());
            userModel.setPersonModel(new PersonModel());
            while(resultSet.next()) {
                userModel.setSysUserId(resultSet.getInt(columnTitleWithoutPrime(Tables.SysUser.sysuserid)));
                userModel.setUserName(resultSet.getString(columnTitleWithoutPrime(Tables.SysUser.username)));
                userModel.setUserPassword(resultSet.getString(columnTitleWithoutPrime(Tables.SysUser.userpassword)));
                userModel.setSessionTime(resultSet.getInt(columnTitleWithoutPrime(Tables.SysUser.sessiontime)));
                userModel.getPersonModel().setPersonId(resultSet.getInt(columnTitleWithoutPrime(Tables.Person.personid)));
                userModel.getPersonModel().setFirstName(resultSet.getString(columnTitleWithoutPrime(Tables.Person.firstname)));
                userModel.getPersonModel().setLastName(resultSet.getString(columnTitleWithoutPrime(Tables.Person.lastname)));
                userModel.getUserTypeModel().setUserTypeId(resultSet.getInt(columnTitleWithoutPrime(Tables.UserType.usertypeid)));
                userModel.getUserTypeModel().setUserTypeName(resultSet.getString(columnTitleWithoutPrime(Tables.UserType.usertypename)));
                userModel.getCountryModel().setCountryid(resultSet.getInt(columnTitleWithoutPrime(Tables.Country.countryid)));
                userModel.getCountryModel().setCountryName(resultSet.getString(columnTitleWithoutPrime(Tables.Country.countryname)));
                userModel.getLanguageModel().setLanguageid(resultSet.getInt(columnTitleWithoutPrime(Tables.Language.languageid)));
                userModel.getLanguageModel().setLanguagename(resultSet.getString(columnTitleWithoutPrime(Tables.Language.languagename)));
            }
        } catch (SQLException ex) {
            getLogger(ex, "Get User Error", UserDaoImpl.class.getName());
        }

        return userModel;
    }

    @Override
    public void add(UserModel v) {
        PreparedStatement preparedStatement = createPrepareStatement(USER_INSERT_QUERY);
        try {
            preparedStatement.setInt(1, v.getPersonModel().getPersonId());
            preparedStatement.setInt(2, v.getUserTypeModel().getUserTypeId());
            preparedStatement.setInt(3, v.getCountryModel().getCountryid());
            preparedStatement.setInt(4, v.getLanguageModel().getLanguageid());
            preparedStatement.setString(5, v.getUserName());
            preparedStatement.setString(6, v.getUserPassword());
            preparedStatement.setInt(7, v.getSessionTime());
            preparedStatement.setLong(8, new Date().getTime());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            getLogger(ex, " User Add Error", UserDaoImpl.class.getName());
        }
    }

    @Override
    public void update(UserModel v) {
        PreparedStatement preparedStatement = createPrepareStatement(USER_UPDATE_QUERY);
        try {
            preparedStatement.setInt(1, v.getPersonModel().getPersonId());
            preparedStatement.setInt(2, v.getUserTypeModel().getUserTypeId());
            preparedStatement.setInt(3, v.getCountryModel().getCountryid());
            preparedStatement.setInt(4, v.getLanguageModel().getLanguageid());
            preparedStatement.setString(5, v.getUserName());
            preparedStatement.setString(6, v.getUserPassword());
            preparedStatement.setInt(7, v.getSessionTime());
            preparedStatement.setLong(8, new Date().getTime());
            preparedStatement.setInt(9, v.getSysUserId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            getLogger(ex, " User Add Error", UserDaoImpl.class.getName());
        }
    }

    @Override
    public void delete(UserModel v) {
        PreparedStatement preparedStatement = createPrepareStatement(USER_DELETE_QUERY);
        try {
            preparedStatement.setInt(1, v.getSysUserId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            getLogger(ex, " User Add Error", UserDaoImpl.class.getName());
        }
    }

}
