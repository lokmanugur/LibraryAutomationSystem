/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ad_model;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class ClassModel {
    private int classId;
    private String className;

    public ClassModel(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public ClassModel() {
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.classId;
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
        final ClassModel other = (ClassModel) obj;
        if (this.classId != other.classId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return className;
    }
    
    
}
