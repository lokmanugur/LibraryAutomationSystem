/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.modelv2;

/**
 *
 * @author ugur
 */
public class UserModel extends PersonModel {
    
    private int sysUserId;
    private UserTypeModel userTypeModel;
    private String userName;
    private String userPassword;
    private CountryModel countryModel;
    private LanguageModel languageModel;

    public UserModel(int sysUserId, UserTypeModel userTypeModel, String userName, String userPassword, CountryModel countryModel, LanguageModel languageModel) {
        this.sysUserId = sysUserId;
        this.userTypeModel = userTypeModel;
        this.userName = userName;
        this.userPassword = userPassword;
        this.countryModel = countryModel;
        this.languageModel = languageModel;
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

    public CountryModel getCountryModel() {
        return countryModel;
    }

    public void setCountryModel(CountryModel countryModel) {
        this.countryModel = countryModel;
    }

    public LanguageModel getLanguageModel() {
        return languageModel;
    }

    public void setLanguageModel(LanguageModel languageModel) {
        this.languageModel = languageModel;
    }
    
    
}