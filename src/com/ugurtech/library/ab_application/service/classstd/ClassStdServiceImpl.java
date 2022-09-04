/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service.classstd;

import com.ugurtech.library.ac_dataaccesslayer.classstd.ClassStdDao;
import com.ugurtech.library.ad_model.ClassModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * 
 */
public class ClassStdServiceImpl implements ClassStdService{
    
    private ClassStdDao classStdDao;

    public ClassStdServiceImpl(ClassStdDao classStdDao) {
        this.classStdDao = classStdDao;
    }

    @Override
    public List<ClassModel> getAll() {
        return classStdDao.getAll();
    }

    @Override
    public ClassModel get(int id) {
        return classStdDao.get(id);
    }

    @Override
    public void add(ClassModel v) {
         classStdDao.add(v);
    }

    @Override
    public void update(ClassModel v) {
        classStdDao.update(v);
    }

    @Override
    public void delete(int id) {
        classStdDao.delete(get(id));
    }

    @Override
    public TableModel search(String str) {
       return classStdDao.search(str);
    }
    
}
