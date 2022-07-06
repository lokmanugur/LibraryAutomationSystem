/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.model;

/**
 *
 * @author Lokman Ugur 
 */
public class SettingsModel {
    private int settingsId;
    private int sysuserid;
    private String language;
    private String country;

    public SettingsModel(int settingsId, int sysuserid, String language, String country) {
        this.settingsId = settingsId;
        this.sysuserid = sysuserid;
        this.language = language;
        this.country = country;
    }
    

    public int getSettingsId() {
        return settingsId;
    }

    public void setSettingsId(int settingsId) {
        this.settingsId = settingsId;
    }

    public int getSysuserid() {
        return sysuserid;
    }

    public void setSysuserid(int sysuserid) {
        this.sysuserid = sysuserid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
