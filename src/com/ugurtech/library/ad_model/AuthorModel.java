/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ad_model;

/**
 *
 * @author ugur
 * 
 */
public class AuthorModel extends PersonModel {
    private int authorId;

    public AuthorModel() {
    }

    public AuthorModel(int authorId,String firstName,String lastName) {
        super(firstName, lastName);
        this.authorId = authorId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    
    @Override
    public String toString(){
        return getFirstName()+" "+getLastName();
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.authorId;
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
        final AuthorModel other = (AuthorModel) obj;
        if (this.authorId != other.authorId) {
            return false;
        }
        return true;
    }
    
}
