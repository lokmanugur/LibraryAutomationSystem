/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.dataaccesslayer.person;

import com.ugurtech.library.dataaccesslayer.Dao;
import com.ugurtech.library.model.PersonModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 */
public interface PersonDao{
    public TableModel search(String searchText);
}
