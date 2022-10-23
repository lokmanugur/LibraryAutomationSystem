/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.application.service.person;

import com.ugurtech.library.application.service.Service;
import com.ugurtech.library.model.PersonModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 */
public interface PersonService extends Service<PersonModel> {
    public TableModel search(String searchText);
}
