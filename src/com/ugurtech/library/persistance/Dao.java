/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance;

import java.sql.ResultSet;

/**
 *
 * @author ugur
 */
interface Dao<T> {
    public ResultSet getAllObject();
    public T getObject(int id);
    public void addObject(T t);
    public void updateObject(T t);
    public void deleteObject(T t); 
}
