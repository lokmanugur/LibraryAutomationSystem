/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.student;

import com.ugurtech.library.persistance.DaoAbstract;
import com.ugurtech.library.persistance.student.StudentDao;
import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.model.SchoolModel;
import com.ugurtech.library.model.StudentModel;
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
public class StudentDaoImpl extends DaoAbstract implements StudentDao {

    private static final String PERSON_INSERT_QUERY = "INSERT INTO person(firstname,lastname,birthdate,phone,address,createddate) VALUES(?,?,?,?,?,?)";
    private static final String STUDENT_INSERT_QUERY = "INSERT INTO student(personid,schoolid,studentclass,studentnumber) VALUES(?,?,?,?)";
    private static final String SCHOOL_SEARCH_QUERY = "SELECT * FROM school";
    private static final String STUDENT_DELETE_QUERY = "UPDATE person SET deleted=?,lastupdate=? WHERE personid=(SELECT personid FROM student WHERE studentnumber =?);";
    private static final String STUDENT_SEARCH_QUERY = "SELECT s.studentnumber as Öğrenci_No,"
            + "p.firstname as Adı,p.lastname as Soyadı,"
            + "s.studentclass as Sınıfı,sch.schoolname as Okul_Adı,p.phone as Telefon,p.address as Adres "
            + "FROM student s,person p,school sch ";

    @Override
    public void addStudent(StudentModel studentModel) {

        PreparedStatement preparedStatement = createPrepareStatement(PERSON_INSERT_QUERY);
        try {
            preparedStatement.setString(1, studentModel.getFirstName());
            preparedStatement.setString(2, studentModel.getLastName());
            preparedStatement.setString(3, studentModel.getBirthDate().toString());
            preparedStatement.setString(4, studentModel.getPhone());
            preparedStatement.setString(5, studentModel.getAddress());
            preparedStatement.setString(6, new Date().toString());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            preparedStatement = createPrepareStatement(STUDENT_INSERT_QUERY);
            preparedStatement.setInt(1, resultSet.getInt(1));
            preparedStatement.setInt(2, studentModel.getStudentSchool());
            preparedStatement.setString(3, studentModel.getStudentClass());
            preparedStatement.setString(4, studentModel.getStudenNumber());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet fillAllStudent(Map<String, String> filters) {
        StringBuilder query = new StringBuilder(STUDENT_SEARCH_QUERY);
        query.append("WHERE ");
        query.append("s.personid=p.personid ");
        query.append("AND s.schoolid=sch.schoolid ");
        query.append("AND p.deleted=0 ");
        fillFilters(query, filters);
        return createResultSet(query.toString());
    }

    @Override
    public StudentModel getStudent(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStudent(StudentModel studentModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteStudent(String studentId) {
        PreparedStatement preparedStatement = createPrepareStatement(STUDENT_DELETE_QUERY);
        try {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setString(3, studentId);
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Delete Error");
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<SchoolModel> getAllSchool() {
        List<SchoolModel> allSchool = new ArrayList<>();
        SchoolModel schoolModel;
        if (allSchool.isEmpty()) {
        } else {
            allSchool.clear();
        }
        ResultSet resultSet = createResultSet(SCHOOL_SEARCH_QUERY);
        try {
            while (resultSet.next()) {
                schoolModel = new SchoolModel();
                schoolModel.setSchoolId(resultSet.getInt("schoolid"));
                schoolModel.setSchoolName(resultSet.getString("schoolname"));
                schoolModel.setPhone(resultSet.getString("phone"));
                schoolModel.setAddress(resultSet.getString("address"));
                schoolModel.setLastUpdate(resultSet.getDate("lastupdate"));
                allSchool.add(schoolModel);
            }
            return allSchool;
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Search Error");
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void fillFilters(StringBuilder query, Map<String, String> filters) {
        if (!filters.isEmpty()) {
            if (filters.containsKey("studentName")) {
                query.append("AND ");
                query.append("(p.firstname || ' ' || p.lastname) ");
                query.append("LIKE '%");
                query.append(filters.get("studentName"));
                query.append("%' ");
            }

            if (filters.containsKey("studentNumber")) {
                query.append("AND ");
                query.append("s.studentnumber ");
                query.append("LIKE '%");
                query.append(filters.get("studentNumber"));
                query.append("%' ");
            }
        }
    }
}
