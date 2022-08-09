/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.modelv2;

import java.util.Objects;

/**
 *
 * @author ugur
 */
public class BookTypeModel extends DateModel {
    private int bookTypeId;
    private String typeName;
    private String abbrivation;

    public BookTypeModel(int bookTypeId, String typeName, String abbrivation, long createdDate, long lastUpdate) {
        super(createdDate, lastUpdate);
        this.bookTypeId = bookTypeId;
        this.typeName = typeName;
        this.abbrivation = abbrivation;
    }

    public BookTypeModel() {
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAbbrivation() {
        return abbrivation;
    }

    public void setAbbrivation(String abbrivation) {
        this.abbrivation = abbrivation;
    }
    
    @Override
    public String toString(){
        return typeName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.bookTypeId;
        hash = 23 * hash + Objects.hashCode(this.typeName);
        hash = 23 * hash + Objects.hashCode(this.abbrivation);
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
        final BookTypeModel other = (BookTypeModel) obj;
        if (this.bookTypeId != other.bookTypeId) {
            return false;
        }
        if (!Objects.equals(this.typeName, other.typeName)) {
            return false;
        }
        if (!Objects.equals(this.abbrivation, other.abbrivation)) {
            return false;
        }
        return true;
    }

}
