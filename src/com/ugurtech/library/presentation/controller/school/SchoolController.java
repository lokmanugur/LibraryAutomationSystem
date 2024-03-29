/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.school;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import com.ugurtech.library.service.school.SchoolService;
import com.ugurtech.library.service.school.SchoolServiceImpl;
import com.ugurtech.library.dataaccesslayer.school.SchoolDaoImpl;
import com.ugurtech.library.model.SchoolModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class SchoolController extends AbstractController implements Controller<SchoolModel> {

    private final SchoolService schoolService = new SchoolServiceImpl(new SchoolDaoImpl());
    protected SchoolModel schoolModel;
    @Override
    public List<SchoolModel> getAll() {
        return schoolService.getAll();
    }

    @Override
    public SchoolModel get(int id) {
        return schoolService.get(id);
    }

    @Override
    public void add(SchoolModel v) {
        schoolService.add(v);
    }

    @Override
    public void update(SchoolModel v) {
        schoolService.update(v);
    }

    @Override
    public void delete(int id) {
        schoolService.delete(id);
    }
    
    public TableModel search(String arg){
        return schoolService.search(arg);
    }
    
}
