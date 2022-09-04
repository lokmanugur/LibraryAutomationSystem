/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.ab_application.service.firstStep;

import com.ugurtech.library.ad_model.requestmodels.FirstStepModel;
import com.ugurtech.library.ac_dataaccesslayer.firststep.FirstStepDao;
import java.util.List;

/**
 *
 * @author Teacher
 */
public class FirstStepServiceImpl implements FirstStepService{
    private final FirstStepDao firstStepDao;
            
    public FirstStepServiceImpl(FirstStepDao firstStepDao){
        this.firstStepDao = firstStepDao;
    }

    @Override
    public List<FirstStepModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FirstStepModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(FirstStepModel v) {
        firstStepDao.add(v);
    }

    @Override
    public void update(FirstStepModel v) {
        firstStepDao.update(v);
    }

    @Override
    public void delete(int id) {
        firstStepDao.delete(get(id));
    }
}
