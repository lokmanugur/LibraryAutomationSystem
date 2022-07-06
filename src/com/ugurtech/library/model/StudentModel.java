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
public class StudentModel extends PersonModel {

    private int studentId;
    private String studenNumber;
    private int studentSchool;
    private String studentClass;

    public int getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(int studentSchool) {
        this.studentSchool = studentSchool;
    }
    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudenNumber() {
        return studenNumber;
    }

    public void setStudenNumber(String studenNumber) {
        this.studenNumber = studenNumber;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

}
