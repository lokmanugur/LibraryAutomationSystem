/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugurtech.library.dataaccesslayer;

import java.util.List;

/**
 *
 * @author www.lokmanugur.com
 * @param <V>
 */
public interface Dao<V> {
    public List<V> getAll();
    public V get(int id);
    public void add(V v);
    public void update(V v);
    public void delete(V v);
}
