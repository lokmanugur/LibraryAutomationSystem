/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.facadesvector;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * @param <SOURCE>
 * @param <TARGET>
 */
public interface Populator<SOURCE,TARGET> {
    void populate(SOURCE source,TARGET target);
}
