/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.student;

import resources.lib.sql.DbUtils;
import resources.lib.validation.UserInfoMessages;
import com.ugurtech.library.dataaccesslayer.DaoAbstract;
import com.ugurtech.library.dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.model.ClassModel;
import com.ugurtech.library.model.SchoolModel;
import com.ugurtech.library.model.StudentModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author ugur
 *
 */
public class StudentDaoImpl extends DaoAbstract<StudentModel> implements StudentDao {

    public static final String PERSON_INSERT_QUERY = "INSERT INTO person(firstname,lastname,birthdate,phone,address,createddate) VALUES(?,?,?,?,?,?)";
    public static final String STUDENT_INSERT_QUERY = "INSERT INTO student(personid,schoolid,classid,studentnumber) VALUES(?,?,?,?)";
    public static final String STUDENT_UPDATE_QUERY = "UPDATE student SET classid=?,schoolid=?,studentnumber=? WHERE studentid = ?";
    public static final String PERSON_UPDATE_QUERY = "UPDATE person SET firstname=?,lastname=?,birthdate=?, phone=?,address=?,lastupdate=? WHERE personid=(SELECT personid FROM student WHERE studentid=?)";
    public static final String STUDENT_DELETE_QUERY = "DELETE FROM student WHERE studentid=?";
    public static final String PERSON_DELETE_QUERY = "DELETE FROM person WHERE personid=(SELECT personid FROM student WHERE studentid=?)";
    public static final String STUDENT_SEARCH_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.Student.studentid) + ","
            + columnNameAsColumnTitle(Tables.Student.studentnumber) + ","
            + columnNameAsColumnTitle(Tables.Person.firstname) + ","
            + columnNameAsColumnTitle(Tables.Person.lastname) + ","
            + columnNameAsColumnTitle(Tables.School.schoolname) + ","
            + columnNameAsColumnTitle(Tables.Clss.classname) + ","
            + columnNameAsColumnTitle(Tables.Person.phone) + ","
            + columnNameAsColumnTitle(Tables.Person.address) + ","
            + columnNameAsColumnTitle(Tables.Person.createddate) + ","
            + columnNameAsColumnTitle(Tables.Person.lastupdate)
            + " FROM " + Tables.person + "," + Tables.student + "," + Tables.clss + "," + Tables.school
            + " WHERE " + Tables.Student.personid + "=" + Tables.Person.personid + " AND " + Tables.Student.schoolid + "=" + Tables.School.schoolid + " AND " + Tables.Student.classid + "=" + Tables.Clss.classid;

    public static final String STUDENT_GET_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.Student.studentid) + ","
            + columnNameAsColumnTitle(Tables.School.schoolid) + ","
            + columnNameAsColumnTitle(Tables.School.schoolname) + ","
            + columnNameAsColumnTitle(Tables.Clss.classid) + ","
            + columnNameAsColumnTitle(Tables.Clss.classname) + ","
            + columnNameAsColumnTitle(Tables.Student.studentnumber) + ","
            + columnNameAsColumnTitle(Tables.Person.personid) + ","
            + columnNameAsColumnTitle(Tables.Person.firstname) + ","
            + columnNameAsColumnTitle(Tables.Person.lastname) + ","
            + columnNameAsColumnTitle(Tables.Person.birthdate) + ","
            + columnNameAsColumnTitle(Tables.Person.phone) + ","
            + columnNameAsColumnTitle(Tables.Person.address)
            + " FROM " + Tables.person + "," + Tables.student + "," + Tables.clss + "," + Tables.school
            + " WHERE " + Tables.Student.personid + "=" + Tables.Person.personid + " AND " + Tables.Student.schoolid + "=" + Tables.School.schoolid + " AND " + Tables.Student.classid + "=" + Tables.Clss.classid;

    @Override
    public void add(StudentModel studentModel) {
        beginTransection();
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
            preparedStatement.setInt(3, studentModel.getClssModel().getClassId());
            preparedStatement.setInt(4, Integer.parseInt(studentModel.getStudentNumber()));
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex,"Add Exception ",StudentDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public void update(StudentModel v) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(PERSON_UPDATE_QUERY);
        try {
            preparedStatement.setString(1, v.getFirstName());
            preparedStatement.setString(2, v.getLastName());
            preparedStatement.setLong(3, v.getBirthDate());
            preparedStatement.setString(4, v.getPhone());
            preparedStatement.setString(5, v.getAddress());
            preparedStatement.setLong(6, new Date().getTime());
            preparedStatement.setInt(7, v.getStudentId());
            int effectedRow = preparedStatement.executeUpdate();
            if (effectedRow > 0) {
                preparedStatement = createPrepareStatement(STUDENT_UPDATE_QUERY);
                preparedStatement.setInt(1, v.getClssModel().getClassId());
                preparedStatement.setInt(2, v.getSchoolModel().getSchoolId());
                preparedStatement.setString(3, v.getStudentNumber());
                preparedStatement.setInt(4, v.getStudentId());
                preparedStatement.executeUpdate();
            }
            UserInfoMessages.getInstance().updateMessage(effectedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex,"Update Exception ",StudentDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public StudentModel get(int id) {
        StudentModel studentModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, STUDENT_GET_QUERY, " AND ", Tables.Student.studentid + "="));
        try {
            studentModel = new StudentModel();
            
            if (resultSet.next()) {
                studentModel.setStudentId(resultSet.getInt(columnTitleWithOutPrime(Tables.Student.studentid)));
                studentModel.setSchoolModel(new SchoolModel());
                studentModel.getSchoolModel().setSchoolId(resultSet.getInt(columnTitleWithOutPrime(Tables.School.schoolid)));
                studentModel.getSchoolModel().setSchoolName(resultSet.getString(columnTitleWithOutPrime(Tables.School.schoolname)));
                studentModel.setClassModel(new ClassModel());
                studentModel.getClssModel().setClassId(resultSet.getInt(columnTitleWithOutPrime(Tables.Clss.classid)));
                studentModel.getClssModel().setClassName(resultSet.getString(columnTitleWithOutPrime(Tables.Clss.classname)));
                studentModel.setStudentNumber(resultSet.getString(columnTitleWithOutPrime(Tables.Student.studentnumber)));
                studentModel.setPersonId(resultSet.getInt(columnTitleWithOutPrime(Tables.Person.personid)));
                studentModel.setFirstName(resultSet.getString(columnTitleWithOutPrime(Tables.Person.firstname)));
                studentModel.setLastName(resultSet.getString(columnTitleWithOutPrime(Tables.Person.lastname)));
                studentModel.setBirthDate(resultSet.getLong(columnTitleWithOutPrime(Tables.Person.birthdate)));
                studentModel.setPhone(resultSet.getString(columnTitleWithOutPrime(Tables.Person.phone)));
                studentModel.setAddress(resultSet.getString(columnTitleWithOutPrime(Tables.Person.address)));                
            }
        } catch (SQLException ex) {
            getLogger(ex,"Get Exception ",StudentDaoImpl.class.getName());
        }

        return studentModel;
    }

    @Override
    public void delete(StudentModel v) {
        beginTransection();
        try {
            PreparedStatement preparedStatement = createPrepareStatement(PERSON_DELETE_QUERY);
            preparedStatement.setInt(1, v.getStudentId());
            preparedStatement.executeUpdate();
            preparedStatement = createPrepareStatement(STUDENT_DELETE_QUERY);
            preparedStatement.setInt(1, v.getStudentId());
            int effectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effectedRow);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex,"Delete Exception ",StudentDaoImpl.class.getName());
        }
        commit();
    }

    @Override
    public List<StudentModel> getAll() {
        String query="SELECT person.personid,person.firstname,person.lastname,person.phone,person.address,"
                + "student.studentnumber,"
                + "school.schoolid,school.schoolname,"
                + "clss.classid,clss.classname "
                + "FROM person "
                + "LEFT JOIN student on person.personid = student.personid  "
                + "LEFT JOIN clss on student.classid = clss.classid "
                + "LEFT JOIN school on student.schoolid = school.schoolid "
                + "WHERE person.personid NOT IN (SELECT author.personid FROM author) ORDER BY person.personid";
        StudentModel studentModel;
        List<StudentModel> studentList = null;
        ResultSet resultSet = createResultSet(query);
        try {
            studentList = new ArrayList<>();
            while(resultSet.next()){
                studentModel = new StudentModel();
                studentModel.setPersonId(resultSet.getInt("personid"));
                studentModel.setFirstName(resultSet.getString("firstname"));
                studentModel.setLastName(resultSet.getString("lastname"));
                studentModel.setAddress(resultSet.getString("address"));
                studentModel.setPhone(resultSet.getString("phone"));
                studentModel.setStudentNumber(resultSet.getString("studentnumber"));
                studentModel.setClassModel(new ClassModel(resultSet.getInt("classid"), resultSet.getString("classname")));
                studentModel.setSchoolModel(new SchoolModel(resultSet.getInt("schoolid"), resultSet.getString("schoolname")));
                studentList.add(studentModel);
            }
        } catch (SQLException ex) {
            getLogger(ex, "Student GetAll Error Query",StudentDaoImpl.class.getName());
        }
        return studentList;
    }

    @Override
    public TableModel search(String searchText) {
        String query = "";
        query += STUDENT_SEARCH_QUERY;
        query += " AND ";
        query += "(";
        query += Tables.Student.studentid + " LIKE '" + searchText + "%' OR ";
        query += Tables.Student.studentnumber + " LIKE '" + searchText + "%' OR ";
        query += Tables.Person.firstname + " LIKE '" + searchText + "%' OR ";
        query += Tables.Person.lastname + " LIKE '" + searchText + "%' OR ";
        query += Tables.Clss.classname + " LIKE '" + searchText + "%' OR ";
        query += Tables.School.schoolname + " LIKE '" + searchText + "%' OR ";
        query += Tables.Person.phone + " LIKE '" + searchText + "%' OR ";
        query += Tables.Person.address + " LIKE '" + searchText + "%'";
        query += ")";
        return DbUtils.resultSetToTableModel(createResultSet(query), columnTitleWithOutPrime(Tables.Person.createddate), columnTitleWithOutPrime(Tables.Person.lastupdate));
    }
}
