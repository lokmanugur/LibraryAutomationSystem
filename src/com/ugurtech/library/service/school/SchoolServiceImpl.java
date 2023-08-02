/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.school;

import com.ugurtech.library.dataaccesslayer.school.SchoolDao;
import com.ugurtech.library.model.SchoolModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class SchoolServiceImpl implements SchoolService{

    private final SchoolDao schoolDao;

    public SchoolServiceImpl(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }
    
    @Override
    public TableModel search(String arg) {
       return schoolDao.search(arg);
    }

    @Override
    public List<SchoolModel> getAll() {
        return schoolDao.getAll();
    }

    @Override
    public SchoolModel get(int id) {
        return schoolDao.get(id);
    }

    @Override
    public void add(SchoolModel v) {
        schoolDao.add(v);
    }

    @Override
    public void update(SchoolModel v) {
        schoolDao.update(v);
    }

    @Override
    public void delete(int id) {
        schoolDao.delete(get(id));
    }
    
}
