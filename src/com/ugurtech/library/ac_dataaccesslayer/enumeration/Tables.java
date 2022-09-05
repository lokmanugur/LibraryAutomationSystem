/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.ugurtech.library.ac_dataaccesslayer.enumeration;

/**
 *
 * @author Teacher
 */
public enum Tables {
    author, book, bookauthor, booktype, booktypebook, borrowedbook, country, language, person, personbook, publisher, school, student, sysuser, usertype, clss;

    @Override
    public String toString() {
        return this.name();
    }

    public enum Author {
        authorid, personid;

        @Override
        public String toString() {
            return this.name();
        }

    }
}
