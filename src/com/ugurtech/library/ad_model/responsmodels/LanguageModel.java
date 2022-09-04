/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.ad_model.responsmodels;

import java.util.Objects;

/**
 *
 * @author Teacher
 */
public class LanguageModel {
    private int languageid;
    private String languagename;
    private String abbriviation;

    public LanguageModel(int languageid, String languagename, String abbriviation) {
        this.languageid = languageid;
        this.languagename = languagename;
        this.abbriviation = abbriviation;
    }
    
    public int getLanguageid() {
        return languageid;
    }

    public void setLanguageid(int languageid) {
        this.languageid = languageid;
    }

    public String getLanguagename() {
        return languagename;
    }

    public void setLanguagename(String languagename) {
        this.languagename = languagename;
    }

    public String getAbbriviation() {
        return abbriviation;
    }

    public void setAbbriviation(String abbriviation) {
        this.abbriviation = abbriviation;
    }

    @Override
    public String toString() {
        return  languagename;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.languageid;
        hash = 37 * hash + Objects.hashCode(this.languagename);
        hash = 37 * hash + Objects.hashCode(this.abbriviation);
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
        final LanguageModel other = (LanguageModel) obj;
        if (this.languageid != other.languageid) {
            return false;
        }
        if (!Objects.equals(this.languagename, other.languagename)) {
            return false;
        }
        return Objects.equals(this.abbriviation, other.abbriviation);
    }
    
    
}
