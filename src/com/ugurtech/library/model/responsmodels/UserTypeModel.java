/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.model.responsmodels;

import com.ugurtech.library.model.DateModel;
import java.util.Objects;

/**
 *
 * @author ugur
 *
 */
public class UserTypeModel extends DateModel {

    private int userTypeId;
    private String userTypeName;
    private boolean authorform;
    private boolean authorsearchform;
    private boolean authoraddbutton;
    private boolean authorupdatebutton;
    private boolean authordeletebutton;
    private boolean authorwritebutton;
    private boolean bookform;
    private boolean booksearchform;
    private boolean bookaddbutton;
    private boolean bookupdatebutton;
    private boolean bookdeletebutton;
    private boolean bookwritebutton;
    private boolean booktypeform;
    private boolean booktypesearchform;
    private boolean bookypeaddbutton;
    private boolean booktypeupdatebutton;
    private boolean booktypedeletebutton;
    private boolean booktypewritebutton;
    private boolean bookborrowform;
    private boolean finishborrowform;
    private boolean startborrowform;
    private boolean classform;
    private boolean classsearchform;
    private boolean classaddbutton;
    private boolean classupdatebutton;
    private boolean classdeletebutton;
    private boolean classwritebutton;
    private boolean databaseui;
    private boolean personform;
    private boolean personsearchform;
    private boolean personaddbutton;
    private boolean personupdatebutton;
    private boolean persondeletebutton;
    private boolean personwritebutton;
    private boolean publisherform;
    private boolean publishersearchform;
    private boolean publisheraddbutton;
    private boolean publisherupdatebutton;
    private boolean publisherdeletebutton;
    private boolean publisherwritebutton;
    private boolean schoolform;
    private boolean schoolsearchform;
    private boolean schooladdbutton;
    private boolean settings;
    private boolean studentform;
    private boolean studentsearchform;
    private boolean studentaddbutton;
    private boolean studentupdatebutton;
    private boolean studentdeletebutton;
    private boolean studentwritebutton;
    private boolean userform;
    private boolean usersearchform;
    private boolean useraddbutton;
    private boolean userupdatebutton;
    private boolean userdeletebutton;
    private boolean userwritebutton;
    private boolean usertypeform;

    public UserTypeModel(int userTypeId, String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
    }

    public UserTypeModel(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public UserTypeModel() {
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

    public boolean isAuthorform() {
        return authorform;
    }

    public void setAuthorform(boolean authorform) {
        this.authorform = authorform;
    }

    public boolean isAuthorsearchform() {
        return authorsearchform;
    }

    public void setAuthorsearchform(boolean authorsearchform) {
        this.authorsearchform = authorsearchform;
    }

    public boolean isAuthoraddbutton() {
        return authoraddbutton;
    }

    public void setAuthoraddbutton(boolean authoraddbutton) {
        this.authoraddbutton = authoraddbutton;
    }

    public boolean isAuthorupdatebutton() {
        return authorupdatebutton;
    }

    public void setAuthorupdatebutton(boolean authorupdatebutton) {
        this.authorupdatebutton = authorupdatebutton;
    }

    public boolean isAuthordeletebutton() {
        return authordeletebutton;
    }

    public void setAuthordeletebutton(boolean authordeletebutton) {
        this.authordeletebutton = authordeletebutton;
    }

    public boolean isAuthorwritebutton() {
        return authorwritebutton;
    }

    public void setAuthorwritebutton(boolean authorwritebutton) {
        this.authorwritebutton = authorwritebutton;
    }

    public boolean isBookform() {
        return bookform;
    }

    public void setBookform(boolean bookform) {
        this.bookform = bookform;
    }

    public boolean isBooksearchform() {
        return booksearchform;
    }

    public void setBooksearchform(boolean booksearchform) {
        this.booksearchform = booksearchform;
    }

    public boolean isBookaddbutton() {
        return bookaddbutton;
    }

    public void setBookaddbutton(boolean bookaddbutton) {
        this.bookaddbutton = bookaddbutton;
    }

    public boolean isBookupdatebutton() {
        return bookupdatebutton;
    }

    public void setBookupdatebutton(boolean bookupdatebutton) {
        this.bookupdatebutton = bookupdatebutton;
    }

    public boolean isBookdeletebutton() {
        return bookdeletebutton;
    }

    public void setBookdeletebutton(boolean bookdeletebutton) {
        this.bookdeletebutton = bookdeletebutton;
    }

    public boolean isBookwritebutton() {
        return bookwritebutton;
    }

    public void setBookwritebutton(boolean bookwritebutton) {
        this.bookwritebutton = bookwritebutton;
    }

    public boolean isBooktypeform() {
        return booktypeform;
    }

    public void setBooktypeform(boolean booktypeform) {
        this.booktypeform = booktypeform;
    }

    public boolean isBooktypesearchform() {
        return booktypesearchform;
    }

    public void setBooktypesearchform(boolean booktypesearchform) {
        this.booktypesearchform = booktypesearchform;
    }

    public boolean isBookypeaddbutton() {
        return bookypeaddbutton;
    }

    public void setBookypeaddbutton(boolean bookypeaddbutton) {
        this.bookypeaddbutton = bookypeaddbutton;
    }

    public boolean isBooktypeupdatebutton() {
        return booktypeupdatebutton;
    }

    public void setBooktypeupdatebutton(boolean booktypeupdatebutton) {
        this.booktypeupdatebutton = booktypeupdatebutton;
    }

    public boolean isBooktypedeletebutton() {
        return booktypedeletebutton;
    }

    public void setBooktypedeletebutton(boolean booktypedeletebutton) {
        this.booktypedeletebutton = booktypedeletebutton;
    }

    public boolean isBooktypewritebutton() {
        return booktypewritebutton;
    }

    public void setBooktypewritebutton(boolean booktypewritebutton) {
        this.booktypewritebutton = booktypewritebutton;
    }

    public boolean isBookborrowform() {
        return bookborrowform;
    }

    public void setBookborrowform(boolean bookborrowform) {
        this.bookborrowform = bookborrowform;
    }

    public boolean isFinishborrowform() {
        return finishborrowform;
    }

    public void setFinishborrowform(boolean finishborrowform) {
        this.finishborrowform = finishborrowform;
    }

    public boolean isStartborrowform() {
        return startborrowform;
    }

    public void setStartborrowform(boolean startborrowform) {
        this.startborrowform = startborrowform;
    }

    public boolean isClassform() {
        return classform;
    }

    public void setClassform(boolean classform) {
        this.classform = classform;
    }

    public boolean isClasssearchform() {
        return classsearchform;
    }

    public void setClasssearchform(boolean classsearchform) {
        this.classsearchform = classsearchform;
    }

    public boolean isClassaddbutton() {
        return classaddbutton;
    }

    public void setClassaddbutton(boolean classaddbutton) {
        this.classaddbutton = classaddbutton;
    }

    public boolean isClassupdatebutton() {
        return classupdatebutton;
    }

    public void setClassupdatebutton(boolean classupdatebutton) {
        this.classupdatebutton = classupdatebutton;
    }

    public boolean isClassdeletebutton() {
        return classdeletebutton;
    }

    public void setClassdeletebutton(boolean classdeletebutton) {
        this.classdeletebutton = classdeletebutton;
    }

    public boolean isClasswritebutton() {
        return classwritebutton;
    }

    public void setClasswritebutton(boolean classwritebutton) {
        this.classwritebutton = classwritebutton;
    }

    public boolean isDatabaseui() {
        return databaseui;
    }

    public void setDatabaseui(boolean databaseui) {
        this.databaseui = databaseui;
    }

    public boolean isPersonform() {
        return personform;
    }

    public void setPersonform(boolean personform) {
        this.personform = personform;
    }

    public boolean isPersonsearchform() {
        return personsearchform;
    }

    public void setPersonsearchform(boolean personsearchform) {
        this.personsearchform = personsearchform;
    }

    public boolean isPersonaddbutton() {
        return personaddbutton;
    }

    public void setPersonaddbutton(boolean personaddbutton) {
        this.personaddbutton = personaddbutton;
    }

    public boolean isPersonupdatebutton() {
        return personupdatebutton;
    }

    public void setPersonupdatebutton(boolean personupdatebutton) {
        this.personupdatebutton = personupdatebutton;
    }

    public boolean isPersondeletebutton() {
        return persondeletebutton;
    }

    public void setPersondeletebutton(boolean persondeletebutton) {
        this.persondeletebutton = persondeletebutton;
    }

    public boolean isPersonwritebutton() {
        return personwritebutton;
    }

    public void setPersonwritebutton(boolean personwritebutton) {
        this.personwritebutton = personwritebutton;
    }

    public boolean isPublisherform() {
        return publisherform;
    }

    public void setPublisherform(boolean publisherform) {
        this.publisherform = publisherform;
    }

    public boolean isPublishersearchform() {
        return publishersearchform;
    }

    public void setPublishersearchform(boolean publishersearchform) {
        this.publishersearchform = publishersearchform;
    }

    public boolean isPublisheraddbutton() {
        return publisheraddbutton;
    }

    public void setPublisheraddbutton(boolean publisheraddbutton) {
        this.publisheraddbutton = publisheraddbutton;
    }

    public boolean isPublisherupdatebutton() {
        return publisherupdatebutton;
    }

    public void setPublisherupdatebutton(boolean publisherupdatebutton) {
        this.publisherupdatebutton = publisherupdatebutton;
    }

    public boolean isPublisherdeletebutton() {
        return publisherdeletebutton;
    }

    public void setPublisherdeletebutton(boolean publisherdeletebutton) {
        this.publisherdeletebutton = publisherdeletebutton;
    }

    public boolean isPublisherwritebutton() {
        return publisherwritebutton;
    }

    public void setPublisherwritebutton(boolean publisherwritebutton) {
        this.publisherwritebutton = publisherwritebutton;
    }

    public boolean isSchoolform() {
        return schoolform;
    }

    public void setSchoolform(boolean schoolform) {
        this.schoolform = schoolform;
    }

    public boolean isSchoolsearchform() {
        return schoolsearchform;
    }

    public void setSchoolsearchform(boolean schoolsearchform) {
        this.schoolsearchform = schoolsearchform;
    }

    public boolean isSchooladdbutton() {
        return schooladdbutton;
    }

    public void setSchooladdbutton(boolean schooladdbutton) {
        this.schooladdbutton = schooladdbutton;
    }

    public boolean isSettings() {
        return settings;
    }

    public void setSettings(boolean settings) {
        this.settings = settings;
    }

    public boolean isStudentform() {
        return studentform;
    }

    public void setStudentform(boolean studentform) {
        this.studentform = studentform;
    }

    public boolean isStudentsearchform() {
        return studentsearchform;
    }

    public void setStudentsearchform(boolean studentsearchform) {
        this.studentsearchform = studentsearchform;
    }

    public boolean isStudentaddbutton() {
        return studentaddbutton;
    }

    public void setStudentaddbutton(boolean studentaddbutton) {
        this.studentaddbutton = studentaddbutton;
    }

    public boolean isStudentupdatebutton() {
        return studentupdatebutton;
    }

    public void setStudentupdatebutton(boolean studentupdatebutton) {
        this.studentupdatebutton = studentupdatebutton;
    }

    public boolean isStudentdeletebutton() {
        return studentdeletebutton;
    }

    public void setStudentdeletebutton(boolean studentdeletebutton) {
        this.studentdeletebutton = studentdeletebutton;
    }

    public boolean isStudentwritebutton() {
        return studentwritebutton;
    }

    public void setStudentwritebutton(boolean studentwritebutton) {
        this.studentwritebutton = studentwritebutton;
    }

    public boolean isUserform() {
        return userform;
    }

    public void setUserform(boolean userform) {
        this.userform = userform;
    }

    public boolean isUsersearchform() {
        return usersearchform;
    }

    public void setUsersearchform(boolean usersearchform) {
        this.usersearchform = usersearchform;
    }

    public boolean isUseraddbutton() {
        return useraddbutton;
    }

    public void setUseraddbutton(boolean useraddbutton) {
        this.useraddbutton = useraddbutton;
    }

    public boolean isUserupdatebutton() {
        return userupdatebutton;
    }

    public void setUserupdatebutton(boolean userupdatebutton) {
        this.userupdatebutton = userupdatebutton;
    }

    public boolean isUserdeletebutton() {
        return userdeletebutton;
    }

    public void setUserdeletebutton(boolean userdeletebutton) {
        this.userdeletebutton = userdeletebutton;
    }

    public boolean isUserwritebutton() {
        return userwritebutton;
    }

    public void setUserwritebutton(boolean userwritebutton) {
        this.userwritebutton = userwritebutton;
    }

    public boolean isUsertypeform() {
        return usertypeform;
    }

    public void setUsertypeform(boolean usertypeform) {
        this.usertypeform = usertypeform;
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
