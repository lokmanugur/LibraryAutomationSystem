/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.ac_dataaccesslayer.person;

import com.ugurtech.library.ac_dataaccesslayer.Dao;
import com.ugurtech.library.ad_model.PersonModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 */
public interface PersonDao extends Dao<PersonModel> {
    public TableModel search(String searchText);
}
