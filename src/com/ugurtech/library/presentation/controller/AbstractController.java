/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ugurtech.library.presentation.controller;

import com.ugurtech.library.application.lib.localization.Internationalization;
import com.ugurtech.library.application.lib.localization.LanguageImpl;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.application.lib.writetofile.TableToExcelImpl;
import javax.swing.JInternalFrame;
import javax.swing.JTable;

/**
 *
 * @author Teacher
 * 
 */
public abstract class AbstractController extends JInternalFrame {

    protected String setLanguage(String strng) {
        return LanguageImpl.setLanguage(Internationalization::setLanguage, strng);
    }

    protected boolean deleteApproveMessage(int selectedRow) {
        if (selectedRow == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
            return false;
        }
        return UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"));
    }

    protected boolean updateUnSelectRowMessage(int selectedRow) {
        if (selectedRow == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.update.unselectedrow"));
            return false;
        } else {
            return true;
        }
    }
    
    protected void write(JTable table,String title){
        new TableToExcelImpl(table, title).writeToTable();
    }
}
