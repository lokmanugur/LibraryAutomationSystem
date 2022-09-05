/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.ugurtech.library.ac_dataaccesslayer.enumeration;

/**
 *
 * @author Teacher
 */
public enum PersonBook {
    personbookid, personid, bookid, startdate, deadline, finishdate, lastupdate;

    @Override
    public String toString() {
        return this.name();
    }
}
