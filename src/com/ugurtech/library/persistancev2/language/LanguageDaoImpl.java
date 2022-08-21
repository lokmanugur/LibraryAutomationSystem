/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.persistancev2.language;

import com.ugurtech.library.modelv2.responsmodels.LanguageModel;
import com.ugurtech.library.persistancev2.DaoAbstract;
import com.ugurtech.library.persistancev2.country.CountryDaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teacher
 */
public class LanguageDaoImpl extends DaoAbstract implements LanguageDao{
    public static final String ALL_COUNTRY_QUERY="SELECT * FROM language";
    
    @Override
    public List<LanguageModel> getAll() {
        
        List<LanguageModel> languageList = new ArrayList<>();
        ResultSet resultSet = createResultSet(ALL_COUNTRY_QUERY);
        try {
            while(resultSet.next())
            languageList.add(new LanguageModel(resultSet.getInt("languageid"),resultSet.getString("languagename"),resultSet.getString("abbriviation")));
        } catch (SQLException ex) {
            Logger.getLogger(CountryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return languageList;
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
