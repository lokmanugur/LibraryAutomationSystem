/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.student;

import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ac_dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.ad_model.StudentModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author ugur
 *
 */
public class StudentDaoImpl extends DaoAbstract implements StudentDao {

    public static final String PERSON_INSERT_QUERY = "INSERT INTO person(firstname,lastname,birthdate,phone,address,createddate) VALUES(?,?,?,?,?,?)";
    public static final String STUDENT_INSERT_QUERY = "INSERT INTO student(personid,schoolid,classid,studentnumber) VALUES(?,?,?,?)";
    public static final String STUDENT_UPDATE_QUERY = "UPDATE student SET classid=?,schoolid=?,studentnumber=? WHERE studentid = ?";
    public static final String PERSON_UPDATE_QUERY = "UPDATE person SET firstname=?,lastname=?,birthdate=?, phone=?,address=?,lastupdate=? WHERE personid=(SELECT personid FROM student WHERE studentid=?)";
    
    public static final String STUDENT_SEARCH_QUERY = "SELECT "
            +getTableTitle(Tables.Student.studentid)+","
            +getTableTitle(Tables.Student.studentnumber)+","
            +getTableTitle(Tables.Person.firstname)+","
            +getTableTitle(Tables.Person.lastname)+","
            +getTableTitle(Tables.Clss.classname)+",";


    @Override
    public void add(StudentModel studentModel) {

        PreparedStatement preparedStatement = createPrepareStatement(PERSON_INSERT_QUERY);
        try {
            preparedStatement.setString(1, studentModel.getFirstName());
            preparedStatement.setString(2, studentModel.getLastName());
            preparedStatement.setLong(3, studentModel.getBirthDate());
            preparedStatement.setString(4, studentModel.getPhone());
            preparedStatement.setString(5, studentModel.getAddress());
            preparedStatement.setLong(6, new Date().getTime());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            preparedStatement = createPrepareStatement(STUDENT_INSERT_QUERY);
            preparedStatement.setInt(1, resultSet.getInt(1));
            preparedStatement.setInt(2, studentModel.getSchoolModel().getSchoolId());
            preparedStatement.setInt(3, studentModel.getStudentClass().getClassId());
            preparedStatement.setInt(4, Integer.valueOf(studentModel.getStudentNumber()));
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(StudentModel studentModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StudentModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(StudentModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StudentModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TableModel search(String searchText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
