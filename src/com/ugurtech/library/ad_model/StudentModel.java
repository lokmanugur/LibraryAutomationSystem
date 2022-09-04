/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ad_model;

/**
 *
 * @author ugur
 */
public class StudentModel extends PersonModel {

    private int studentId;
    private String studentNumber;
    private int studentSchool;
    private ClassModel studentClass;
    private SchoolModel schoolModel;

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

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public ClassModel getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(ClassModel studentClass) {
        this.studentClass = studentClass;
    }

    public SchoolModel getSchoolModel() {
        return schoolModel;
    }

    public void setSchoolModel(SchoolModel schoolModel) {
        this.schoolModel = schoolModel;
    }
    
    

}
