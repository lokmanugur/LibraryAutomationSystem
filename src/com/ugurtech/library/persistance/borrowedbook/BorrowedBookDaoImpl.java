/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.borrowedbook;

import com.ugurtech.library.persistance.DaoAbstract;
import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author ugur
 */
public class BorrowedBookDaoImpl extends DaoAbstract implements BorrowedBookDao{
    
    private static final String BORROWED_BOOK_SEARCH_QUERY= "SELECT "
            + "b.bookid as Kitap_No,"
            + "b.isbn as ISBN,"
            + "b.bookname as Kitap_Adı,"
            + "p.firstname as Adı," +
              "p.lastname as Soyadı,s.studentnumber as Öğrenci_No," +
              "p.phone as Telefon,p.address as Adres," +
              "pb.startdate Kitap_Aldığı_Tarih," +
              "pb.deadline as Kitap_Teslim_Edilecek_Tarih," +
              "pb.finishdate as Kitap_Teslim_Edilen_Tarih " +
              "FROM personbook pb " +
            "LEFT JOIN person p on pb.personid=p.personid " +
            "LEFT JOIN book b on pb.bookid=b.bookid " +
            "LEFT JOIN student s on p.personid=s.personid WHERE pb.personbookid NOT NULL ";
    @Override
    public ResultSet filtersAllBorrowedBooks(Map<String, String> filters) {
        StringBuilder query = new StringBuilder(BORROWED_BOOK_SEARCH_QUERY);
        fillFilters(query,filters);
        return createResultSet(query.toString());
    }

    private void fillFilters(StringBuilder query, Map<String, String> filters) {
        if(!filters.isEmpty()){
            if(filters.containsKey("allBooks")){
                switch(filters.get("allBooks")) {
                  case "Ödünç Alınmış Bütün Kitaplar":
                    break;
                  case "İade Edilen Kitaplar":
                      query.append("AND ");
                      query.append("pb.finishdate NOT NULL ");
                    break;
                  case "Okuyucuda Bulunan Kitaplar":
                      query.append("AND ");
                      query.append("pb.finishdate IS NULL ");
                    break;
                  case "İade Zamanı Aşan Kitaplar":
                      query.append("AND ");
                      query.append("pb.finishdate IS NULL ");
                      query.append("AND ");
                      query.append("date()>pb.deadline ");
                    break;
                  default:
                    // code block
                }
          
            }
            if(filters.containsKey("isbnNumber")){
              query.append("AND ");
              query.append("b.isbn ");
              query.append("LIKE '%");
              query.append(filters.get("isbnNumber"));
              query.append("%' ");
            }
            
            if(filters.containsKey("bookTitle")){
              query.append("AND ");
              query.append("b.booksname ");
              query.append("LIKE '%");
              query.append(filters.get("bookTitle"));
              query.append("%' ");            
            }
            
            if(filters.containsKey("firstLastName")){
              query.append("AND ");
              query.append("(p.firstname || ' ' || p.lastname) ");
              query.append("LIKE '%");
              query.append(filters.get("firstLastName"));
              query.append("%' ");            
            }
        }
    }
    
}
