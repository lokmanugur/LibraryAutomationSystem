/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.model;

/**
 *
 * @author ugur
 */
public class UserModel extends PersonModel {
    
    private int sysUserId;
    private int userTypeId;
    private String userName;
    private String userPassword;

    public UserModel(int sysUserId, int userTypeId, String userName, String userPassword) {
        this.sysUserId = sysUserId;
        this.userTypeId = userTypeId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    
    public UserModel(){
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public int getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
}