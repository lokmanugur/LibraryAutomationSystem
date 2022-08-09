/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.modelv2;

/**
 *
 * @author ugur
 * 
 */
public class AuthorModel extends PersonModel {
    private int authorId;
    private int personId;

    public AuthorModel(int authorId, int personId,String firstName,String lastName) {
        super(firstName, lastName);
        this.authorId = authorId;
        this.personId = personId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public int getPersonId() {
        return personId;
    }

    @Override
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    
    @Override
    public String toString(){
        return getFirstName()+" "+getLastName();
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.authorId;
        hash = 89 * hash + this.personId;
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
        return this.personId == other.personId;
    }
    
}
