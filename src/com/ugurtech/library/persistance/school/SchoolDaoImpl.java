/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.school;

import com.ugurtech.library.persistance.DaoAbstract;
import com.ugurtech.library.persistance.school.SchoolDao;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.model.SchoolModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugur
 */
public class SchoolDaoImpl extends DaoAbstract implements SchoolDao{
    
    private static final String SCHOOL_SEARCH_QUERY="SELECT schoolid as Okul_Kayıt_No, schoolname as Okul_Adı,phone as Telefon, address as Adres FROM school ";
    private static final String SCHOOL_ADD_QUERY="INSERT INTO school(schoolname,phone,address) VALUES(?,?,?)";
    private static final String SCHOOL_DELETE_QUERY="UPDATE school SET deleted=?,lastupdate=? WHERE schoolid=? ";
    private static final String SCHOOL_UPDATE_QUERY="UPDATE school SET schoolname=?,phone=?,address=? WHERE schoolid=?";

    @Override
    public ResultSet getAllSchool(Map<String, String> filters) {
        StringBuilder query= new StringBuilder(SCHOOL_SEARCH_QUERY);
        query.append("WHERE deleted=0 ");
        fillFilter(query,filters);
        return createResultSet(query.toString());
    }
    
    @Override
    public SchoolModel getSchool(int id) {

        return null;
    }

    @Override
    public void addSchool(SchoolModel schoolModel) {
        PreparedStatement preparedStatement = createPrepareStatement(SCHOOL_ADD_QUERY);
        try{
            preparedStatement.setString(1, schoolModel.getSchoolName());
            preparedStatement.setString(2, schoolModel.getPhone());
            preparedStatement.setString(3, schoolModel.getAddress());
            int effactedRow=preparedStatement.executeUpdate();
                UserInfoMessages.getInstance().insertMessage(effactedRow);
            }catch(SQLException ex){
                UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Insert Error");
                Logger.getLogger(SchoolDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateSchool(SchoolModel schoolModel) {
        PreparedStatement preparedStatement = createPrepareStatement(SCHOOL_UPDATE_QUERY);
        try {
            preparedStatement.setString(1, schoolModel.getSchoolName());
            preparedStatement.setString(2, schoolModel.getPhone());
            preparedStatement.setString(3, schoolModel.getAddress());
            preparedStatement.setInt(4, schoolModel.getSchoolId());
            int effectedRow=preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(effectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Update Error");
            Logger.getLogger(SchoolDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteSchool(int schoolId) {
        PreparedStatement preparedStatement=createPrepareStatement(SCHOOL_DELETE_QUERY);
        try {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setInt(3, schoolId);
            int effectedRow=preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Delete Error");
            Logger.getLogger(SchoolDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillFilter(StringBuilder query, Map<String, String> filters) {
        if(!filters.isEmpty()){
            if(filters.containsKey("schoolName")){
                query.append("AND ");
                query.append("schoolname ");
                query.append("LIKE '%");
                query.append(filters.get("schoolName"));
                query.append("%'");
            }
        }
    } 
}
