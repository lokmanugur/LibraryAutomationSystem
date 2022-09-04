/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ad_model;

/**
 *
 * @author ugur
 */
public class DateModel {
    private long createdDate;
    private long lastUpdate;

    public DateModel(long createdDate, long lastUpdate) {
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
    }

    public DateModel() {
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    
}
