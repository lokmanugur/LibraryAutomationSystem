/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service;

import java.util.List;


/**
 *
 * @author ugur
 * @param <V>
 */
public interface Service<V> {
    public List<V> getAll();
    public V get(int id);
    public void add(V v);
    public void update(V v);
    public void delete(int id); 
}