/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.modelv2;

import java.util.Objects;

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

    @Override
    public String toString() {
        return  countryName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.countryid;
        hash = 89 * hash + Objects.hashCode(this.countryName);
        hash = 89 * hash + Objects.hashCode(this.abbriviation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CountryModel other = (CountryModel) obj;
        if (this.countryid != other.countryid) {
            return false;
        }
        if (!Objects.equals(this.countryName, other.countryName)) {
            return false;
        }
        return Objects.equals(this.abbriviation, other.abbriviation);
    }
    
    
}
