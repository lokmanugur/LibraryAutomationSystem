/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.borrowedbook;

import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author ugur
 */
public interface BorrowedBookDao {
    public ResultSet filtersAllBorrowedBooks(Map<String,String> filters);
    
}
