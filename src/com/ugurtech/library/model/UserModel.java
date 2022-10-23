/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.model;

import com.ugurtech.library.model.responsmodels.UserTypeModel;
import com.ugurtech.library.model.responsmodels.LanguageModel;
import com.ugurtech.library.model.responsmodels.CountryModel;

/**
 *
 * @author ugur
 */
public class UserModel {
    
    private int sysUserId;
    private PersonModel personModel;
    private UserTypeModel userTypeModel;
    private String userName;
    private String userPassword;
    private CountryModel countryModel;
    private LanguageModel languageModel;
    private int sessionTime;

    public int getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
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

    public int getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    }
}