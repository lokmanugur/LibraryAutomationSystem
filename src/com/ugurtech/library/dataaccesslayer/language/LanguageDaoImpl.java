/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.dataaccesslayer.language;

import com.ugurtech.library.model.responsmodels.LanguageModel;
import com.ugurtech.library.dataaccesslayer.DaoAbstract;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            getLogger(ex,"FirstStep Exception ",LanguageDaoImpl.class.getName());
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
