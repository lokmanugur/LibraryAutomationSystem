/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.modelv2;

/**
 *
 * @author Ugur
 */
public class CurrentUserModel extends PersonModel {
    
    private int sysUserId;
    private String userName;
    private String userPassword;
    private String language;
    private String region;
    private int sessionTime=60*60*5;
    private static CurrentUserModel currentUser;
    
    private CurrentUserModel(){}
    
    public static CurrentUserModel getInstance(){
        if(currentUser == null)
            return currentUser = new CurrentUserModel();        
        else
           return currentUser;
    }
    
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

    public int getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    } 
}
