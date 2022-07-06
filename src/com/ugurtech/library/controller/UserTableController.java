/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controller;

import com.ugurtech.library.persistance.user.UserDao;
import com.ugurtech.library.persistance.user.UserDaoImpl;
import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.view.user.UserTableForm;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 */
public class UserTableController {
    
    private final UserTableForm userTableForm;
    private final UserDao userDao;

    public UserTableController(UserTableForm userTableForm) {
        this.userTableForm = userTableForm;
        userDao=new UserDaoImpl();
    }

    public void fillAllUser() {
        Map<String,String> filters = new HashMap<>();
        Optional.ofNullable(userTableForm.getUserIdTextField().getText())
                .filter(value->!value.isEmpty())
                .ifPresent(value->filters.put("userId", value));
        Optional.ofNullable(userTableForm.getUserNameTextField().getText())
                .filter(value->!value.isEmpty())
                .ifPresent(value->filters.put("userName", value));
        userTableForm.getSysuserTable().setModel(DbUtils.resultSetToTableModel(userDao.fillAllUser(filters)));
    }

    public void deleteUser() {
        if (userTableForm.getSysuserTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages("Lütfen silmek istediğiniz veriyi seçin");
        } else if (UserInfoMessages.getInstance().showApproveMessages("Seçilen satırı silmek istediğinize eminmisiniz?", "Silme İşlemi Onay Formu")) {
            userDao.deleteUser((int) userTableForm.getSysuserTable().getModel().getValueAt(userTableForm.getSysuserTable().getSelectedRow(), 0));
        }
        fillAllUser();
    }

    public void updateUser() {
    }
    
}
