/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.settings;

import com.ugurtech.library.model.SettingsModel;

/**
 *
 * @author Lokman Ugur 
 */
public interface SettingsDao {
    public SettingsModel getSettings(int id);
    public void addSettings(SettingsModel settingsModel);
    public void updateSettings(SettingsModel settingsModel);
    public void deleteSettings(String settingsId);
}

