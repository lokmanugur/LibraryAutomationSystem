/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.dataaccesslayer.usertype;

import com.ugurtech.library.application.lib.sql.DbUtils;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.model.responsmodels.UserTypeModel;
import com.ugurtech.library.dataaccesslayer.DaoAbstract;
import com.ugurtech.library.dataaccesslayer.enumeration.Tables;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 */
public class UserTypeDaoImpl extends DaoAbstract implements UserTypeDao {

    public static final String ALL_USERTYPE_QUERY = "SELECT "
        +columnNameAsColumnTitle(Tables.UserType.usertypeid)+","
        +columnNameAsColumnTitle(Tables.UserType.usertypename)
        +" FROM usertype";
    public static final String USERTYPE_DELETE_QUERY = "DELETE FROM usertype WHERE sysuserid=?";

    @Override
    public List<UserTypeModel> getAll() {
        List<UserTypeModel> userTypeList = null;
        ResultSet resultSet = createResultSet(ALL_USERTYPE_QUERY);
        try {
            userTypeList = new ArrayList<>();
            while (resultSet.next()) {
                userTypeList.add(new UserTypeModel(resultSet.getInt("usertypeid"), resultSet.getString("usertypename")));
            }
        } catch (SQLException ex) {
            getLogger(ex,"GetAll Exception ",UserTypeDaoImpl.class.getName());
        }
        return userTypeList;
    }

    @Override
    public UserTypeModel get(int id) {
        UserTypeModel userTypeModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, ALL_USERTYPE_QUERY, " WHERE ", Tables.SysUser.sysuserid+"="));
        try {
            userTypeModel = new UserTypeModel();
            while(resultSet.next()) {
                userTypeModel.setUserTypeId(resultSet.getInt(columnTitleWithOutPrime(Tables.UserType.usertypeid)));
                userTypeModel.setUserTypeName(resultSet.getString(columnTitleWithOutPrime(Tables.UserType.usertypename)));
            }
        } catch (SQLException ex) {
            getLogger(ex, "Get UserType Error", UserTypeDaoImpl.class.getName());
        }

        return userTypeModel;
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
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(USERTYPE_DELETE_QUERY);
        try {
            preparedStatement.setInt(1, v.getUserTypeId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, " UserType Add Error", UserTypeDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public TableModel search(String searchText) {
        String query=ALL_USERTYPE_QUERY;
        query+=" WHERE ";
        query+="(";
        query+=Tables.UserType.usertypeid+" LIKE '"+searchText+"%' OR ";
        query+=Tables.UserType.usertypename+" LIKE '"+searchText+"%' ";
        query+=")";
        return DbUtils.resultSetToTableModel(createResultSet(query));
    }

}
