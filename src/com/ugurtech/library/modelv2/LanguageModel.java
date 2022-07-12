/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.modelv2;

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
    
    
}
