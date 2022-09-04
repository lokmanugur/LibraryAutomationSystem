/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service.student;

import com.ugurtech.library.ac_dataaccesslayer.student.StudentDao;
import com.ugurtech.library.ad_model.StudentModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class StudentServiceImpl implements StudentService{
    
    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<StudentModel> getAll() {
        return studentDao.getAll();
    }

    @Override
    public StudentModel get(int id) {
        return studentDao.get(id);
    }

    @Override
    public void add(StudentModel v) {
        studentDao.add(v);
    }

    @Override
    public void update(StudentModel v) {
        studentDao.update(v);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(get(id));
    }

    @Override
    public TableModel search(String searchText) {
        return studentDao.search(searchText);
    }
    
}
