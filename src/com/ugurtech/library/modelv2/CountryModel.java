/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.modelv2;

/**
 *
 * @author Teacher
 */
public class CountryModel {
    private int countryid;
    private String countryName;
    private String abbriviation;

    public CountryModel(int countryid, String countryName, String abbriviation) {
        this.countryid = countryid;
        this.countryName = countryName;
        this.abbriviation = abbriviation;
    }

    public CountryModel() {
    }

    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAbbriviation() {
        return abbriviation;
    }

    public void setAbbriviation(String abbriviation) {
        this.abbriviation = abbriviation;
    }
    
    
}
