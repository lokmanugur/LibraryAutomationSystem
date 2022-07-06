/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service;

import java.sql.ResultSet;

/**
 *
 * @author ugur
 */
public interface Service<T> {
    public ResultSet getAll();
    public T get(int id);
    public void add(T t);
    public void update(T t);
    public void delete(T t); 
}
