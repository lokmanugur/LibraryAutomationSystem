/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.student;

import com.ugurtech.library.application.service.classstd.ClassStdService;
import com.ugurtech.library.application.service.classstd.ClassStdServiceImpl;
import com.ugurtech.library.application.service.school.SchoolService;
import com.ugurtech.library.application.service.school.SchoolServiceImpl;
import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import com.ugurtech.library.application.service.student.StudentService;
import com.ugurtech.library.application.service.student.StudentServiceImpl;
import com.ugurtech.library.dataaccesslayer.classstd.ClassStdDaoImpl;
import com.ugurtech.library.dataaccesslayer.school.SchoolDaoImpl;
import com.ugurtech.library.dataaccesslayer.student.StudentDaoImpl;
import com.ugurtech.library.model.StudentModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class StudentController extends AbstractController implements Controller<StudentModel>{
    protected final SchoolService schoolService = new SchoolServiceImpl(new SchoolDaoImpl());
    protected final ClassStdService classStdService = new ClassStdServiceImpl(new ClassStdDaoImpl());
    private final StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
    protected StudentModel studentModel;
    @Override
    public List<StudentModel> getAll() {
        return studentService.getAll();
    }

    @Override
    public StudentModel get(int id) {
        return studentService.get(id);
    }

    @Override
    public void add(StudentModel v) {
        studentService.add(v);
    }

    @Override
    public void update(StudentModel v) {
        studentService.update(v);
    }

    @Override
    public void delete(int id) {
        studentService.delete(id);
    }
    
    public TableModel search(String searchText){
        return studentService.search(searchText);
    }
    
}
