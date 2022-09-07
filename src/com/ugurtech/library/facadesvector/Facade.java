/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.facadesvector;
import java.util.Vector;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * @param <V>
 */
public interface Facade<V> {
   public Vector<V> getAll();
   public V get(int id);
}
