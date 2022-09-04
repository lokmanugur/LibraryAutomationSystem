/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ad_model.responsmodels;

import com.ugurtech.library.ad_model.DateModel;
import java.util.Objects;


/**
 *
 * @author ugur
 */
public class UserTypeModel extends DateModel {
    private int userTypeId;
    private String userTypeName;

    public UserTypeModel(int userTypeId, String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
    }
    
    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.userTypeId;
        hash = 79 * hash + Objects.hashCode(this.userTypeName);
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
        final UserTypeModel other = (UserTypeModel) obj;
        if (this.userTypeId != other.userTypeId) {
            return false;
        }
        return Objects.equals(this.userTypeName, other.userTypeName);
    }

    @Override
    public String toString() {
        return userTypeName;
    }

    
}
