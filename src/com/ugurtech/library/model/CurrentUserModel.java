/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.model;

import com.ugurtech.library.model.responsmodels.UserTypeModel;

/**
 *
 * @author Ugur
 */
public class CurrentUserModel extends PersonModel {
    
    private int sysUserId;
    private String userName;
    private String userPassword;
    private UserTypeModel userTypeModel;
    private String language;
    private String region;
    private long sessionTime;

    public static final CurrentUserModel INSTANCE = new CurrentUserModel();
    
    private CurrentUserModel(){}
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    public UserTypeModel getUserTypeModel() {
        return userTypeModel;
    }

    public void setUserTypeModel(UserTypeModel userTypeModel) {
        this.userTypeModel = userTypeModel;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(long sessionTime) {
        this.sessionTime = sessionTime;
    } 
}
