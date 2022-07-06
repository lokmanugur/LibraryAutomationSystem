/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.student;

import com.ugurtech.library.model.SchoolModel;
import com.ugurtech.library.model.StudentModel;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lokman Ugur
 */
public interface StudentDao {
    public StudentModel getStudent(int id);
    public void addStudent(StudentModel studentModel);
    public void updateStudent(StudentModel studentModel);
    public void deleteStudent(String studentId);
    public List<SchoolModel> getAllSchool();
    public ResultSet fillAllStudent(Map<String, String> filters);
    
}

