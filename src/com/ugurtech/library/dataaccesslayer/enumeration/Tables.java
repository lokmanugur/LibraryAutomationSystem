/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.ugurtech.library.dataaccesslayer.enumeration;

/**
 *
 * @author Teacher
 */
public enum Tables {
    author, book, bookauthor, booktype, booktypebook, borrowedbook, country, language, person, personbook, publisher, school, student, sysuser, usertype, clss,date;
    
    public enum Author {
       author, authorid, personid,name;

        @Override
        public String toString() {
            return Tables.author+"."+this.name();
        }
    }
    
    public enum Book{
        book,bookid,isbn,publisherid,sysuserid,bookname,publishdate,quantity,pages,stock,sherlf,lastupdate;
        
        @Override        
        public String toString() {
            return Tables.book+"."+this.name();
        }
    }

    public enum Bookauthor {
      bookauthor, bookauthorid, bookid, authorid;

        @Override
        public String toString() {
            return Tables.bookauthor+"."+this.name();
        }
    }

    public enum BookTypeBook {
      booktypebook, booktypebookid, bookid, booktypeid;

        @Override
        public String toString() {
            return Tables.booktypebook+"."+this.name();
        }
    }

    public enum BookType {
       booktypeid,typename,abbreviation;

        @Override
        public String toString() {
            return Tables.booktype+"."+this.name();
        }
    }

    public enum Clss {
       clss, classid, classname;

        @Override
        public String toString() {
            return Tables.clss+"."+this.name();
        }
    }

    public enum Country {
       country, countryid, countryname, abbriviation;

        @Override
        public String toString() {
            return Tables.country+"."+this.name();
        }
    }

    public enum Language {
       language, languageid, languagename, abbriviation;

        @Override
        public String toString() {
            return Tables.language+"."+this.name();
        }
    }

    public enum Person {
       person, personid, firstname, lastname, birthdate, address, phone, createddate, lastupdate;

        @Override
        public String toString() {
            return Tables.person+"."+this.name();
        }
    }

    public enum PersonBook {
       personbook, personbookid, personid, bookid, startdate, deadline, finishdate, readpage;

        @Override
        public String toString() {
            return Tables.personbook+"."+this.name();
        }
    }

    public enum Publisher {
      publisher, publisherid, publishername, phone, address;

        @Override
        public String toString() {
            return Tables.publisher+"."+this.name();
        }
    }

    public enum School {
       school, schoolid, schoolname, phone, address;

        @Override
        public String toString() {
            return Tables.school+"."+this.name();
        }
    }

    public enum Student {
       student, studentid, personid, schoolid, classid, studentnumber;

        @Override
        public String toString() {
            return Tables.student+"."+this.name();
        }
    }

    public enum SysUser {
       sysuser, sysuserid, personid, usertypeid, countryid, languageid, username, userpassword, createddate, lastupdate, sessiontime;

        @Override
        public String toString() {
            return Tables.sysuser+"."+this.name();
        }
    }

    public enum UserType {
       usertype, usertypeid, usertypename;

        @Override
        public String toString() {
            return Tables.usertype+"."+this.name();
        }
    }
}
