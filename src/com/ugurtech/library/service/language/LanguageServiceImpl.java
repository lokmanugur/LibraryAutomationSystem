/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.service.language;

import com.ugurtech.library.modelv2.responsmodels.LanguageModel;
import com.ugurtech.library.persistancev2.language.LanguageDao;
import java.util.List;

/**
 *
 * @author Teacher
 */
public class LanguageServiceImpl implements LanguageService {
    
    private final LanguageDao languageDao;

    public LanguageServiceImpl(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public List<LanguageModel> getAll() {
        return languageDao.getAll(); 
    }

    @Override
    public LanguageModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(LanguageModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(LanguageModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(LanguageModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
