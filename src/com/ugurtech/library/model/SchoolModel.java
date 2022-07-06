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
public class SchoolModel extends DateModel {
    
    private int schoolId;
    private String schoolName;
    private String phone;
    private String address;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }else{
            return obj.hashCode() == this.hashCode();
        }
    }
    
    @Override
    public int hashCode() {
        return this.schoolId;
    }

    @Override
    public String toString() {
        return  schoolName;
    }
}
