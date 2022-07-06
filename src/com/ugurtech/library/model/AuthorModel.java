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
public class AuthorModel extends PersonModel {
    private int authorId;
    private int personId;

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
        return String.format(getFirstName()+" "+getLastName());
        
    }
}
