/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller;

import java.util.List;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * @param <V>
 */
public interface Controller<V> {
    public List<V> getAll();
    public V get(int id);
    public void add(V v);
    public void update(V v);
    public void delete(int id); 
}
