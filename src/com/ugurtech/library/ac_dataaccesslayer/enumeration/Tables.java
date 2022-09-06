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

    public enum Author {
        authorid, personid;

        @Override
        public String toString() {
            return Tables.author+"."+this.name();
        }
    }

    public enum Bookauthor {
        bookauthorid, bookid, authorid;

        @Override
        public String toString() {
            return Tables.bookauthor+"."+this.name();
        }
    }

    public enum Booktypebook {
        booktypebookid, bookid, booktypeid;

        @Override
        public String toString() {
            return Tables.booktypebook+"."+this.name();
        }
    }

    public enum Borrowedbook {
        borrowedbookid, bookid;

        @Override
        public String toString() {
            return Tables.borrowedbook+"."+this.name();
        }
    }

    public enum Clss {
        clssid, classname;

        @Override
        public String toString() {
            return Tables.clss+"."+this.name();
        }
    }

    public enum Country {
        countryid, countryname, abbriviation;

        @Override
        public String toString() {
            return Tables.country+"."+this.name();
        }
    }

    public enum Language {
        languageid, languagename, abbriviation;

        @Override
        public String toString() {
            return Tables.language+"."+this.name();
        }
    }

    public enum Person {
        personid, firstname, lastname, birtdate, address, phone, createddate, lastupdate;

        @Override
        public String toString() {
            return Tables.person+"."+this.name();
        }
    }

    public enum PersonBook {
        personbookid, personid, bookid, startdate, deadline, finishdate, lastupdate;

        @Override
        public String toString() {
            return Tables.personbook+"."+this.name();
        }
    }

    public enum Publisher {
        publisherid, publishername, phone, address;

        @Override
        public String toString() {
            return Tables.publisher+"."+this.name();
        }
    }

    public enum School {
        schoolid, schoolname, phone, address;

        @Override
        public String toString() {
            return Tables.school+"."+this.name();
        }
    }

    public enum Student {
        studentid, personid, schoolid, classid, studentnumber;

        @Override
        public String toString() {
            return Tables.student+"."+this.name();
        }
    }

    public enum SysUser {
        sysuserid, personid, usertypeid, countryid, languageid, username, userpassword, createddate, lastupdate, sessiontime;

        @Override
        public String toString() {
            return Tables.sysuser+"."+this.name();
        }
    }

    public enum UserType {
        usertypeid, usertypename;

        @Override
        public String toString() {
            return Tables.usertype+"."+this.name();
        }
    }
}
