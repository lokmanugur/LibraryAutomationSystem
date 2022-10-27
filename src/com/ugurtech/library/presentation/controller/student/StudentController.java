/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.student;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import com.ugurtech.library.application.service.student.StudentService;
import com.ugurtech.library.application.service.student.StudentServiceImpl;
import com.ugurtech.library.dataaccesslayer.student.StudentDaoImpl;
import com.ugurtech.library.model.StudentModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class StudentController extends AbstractController implements Controller<StudentModel>{

    private final StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
    
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