/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.ac_dataaccesslayer.country;

import com.ugurtech.library.ad_model.responsmodels.CountryModel;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Teacher
 */
public class CountryDaoImpl extends DaoAbstract implements CountryDao {
    public static final String ALL_COUNTRY_QUERY="SELECT * FROM country";
    
    List<CountryModel> countryList = new ArrayList<>();
    
    @Override
    public List<CountryModel> getAll() {    
        if(!countryList.isEmpty()){
            countryList.clear();
        }
        ResultSet resultSet = createResultSet(ALL_COUNTRY_QUERY);
        try {
            while(resultSet.next())
            countryList.add(new CountryModel(resultSet.getInt("countryid"),resultSet.getString("countryname"),resultSet.getString("abbriviation")));
        } catch (SQLException ex) {
            getLogger(ex,"GetAll Exception ",CountryDaoImpl.class.getName());
        }
        return countryList;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(CountryModel v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
