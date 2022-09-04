/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.ab_application.service.country;

import com.ugurtech.library.ad_model.responsmodels.CountryModel;
import com.ugurtech.library.ac_dataaccesslayer.country.CountryDao;
import java.util.List;

/**
 *
 * @author Teacher
 */
public class CountryServiceImpl implements CountryService {
    
    private final CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
    
    @Override
    public List<CountryModel> getAll() {
        return countryDao.getAll();
    }

    @Override
    public CountryModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(CountryModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(CountryModel v) {
        countryDao.update(v);
    }

    @Override
    public void delete(int id) {
        countryDao.delete(get(id));
    }
    
}
