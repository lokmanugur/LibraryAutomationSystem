/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.classstd;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import com.ugurtech.library.application.service.classstd.ClassStdService;
import com.ugurtech.library.application.service.classstd.ClassStdServiceImpl;
import com.ugurtech.library.dataaccesslayer.classstd.ClassStdDaoImpl;
import com.ugurtech.library.model.ClassModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class ClassController extends AbstractController implements Controller<ClassModel> {

    private ClassStdService classStdService = new ClassStdServiceImpl(new ClassStdDaoImpl());
    protected ClassModel classModel;
    @Override
    public List<ClassModel> getAll() {
        return classStdService.getAll();
    }

    @Override
    public ClassModel get(int id) {
        return classStdService.get(id);
    }

    @Override
    public void add(ClassModel v) {
        classStdService.add(v);
    }

    @Override
    public void update(ClassModel v) {
        classStdService.update(v);
    }

    @Override
    public void delete(int id) {
        classStdService.delete(id);
    }
    
    public TableModel search(String str){
        return classStdService.search(str);
    }
    
}
