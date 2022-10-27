/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.user;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.user.UserForm;
import com.ugurtech.library.presentation.view.user.UserSearchForm;

/**
 *
 * @author ugur
 *
 */
public final class UserSearchFormController extends UserController implements Initialize {

    private final UserSearchForm userSearchForm;

    public UserSearchFormController(UserSearchForm userTableForm) {
        this.userSearchForm = userTableForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        setLanguage();
        search();
    }

    @Override
    public void initController() {
        userSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

        userSearchForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
        });

        userSearchForm.getButtonWrite().addActionListener((java.awt.event.ActionEvent evt) -> {
            write();
        });

        userSearchForm.getButtonAdd().addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
        });

        userSearchForm.getButtonUpdate().addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
        });
    }

    public void search() {
        userSearchForm.getTableSearch().setModel(search(userSearchForm.getTextFieldSearch().getText()));
    }

    private void write() {
        write(userSearchForm.getTableSearch(), userSearchForm.getTitle());
    }

    private void add() {
        MainForm.getInstance().addDesktopPane(UserForm.INSTANCE);
    }

    private void update() {
        int selectedRow = userSearchForm.getTableSearch().getSelectedRow();
       if(updateUnSelectRowMessage(selectedRow)){
           MainForm.getInstance().addDesktopPane(UserForm.INSTANCE);
           UserForm.INSTANCE.getUserFormController().modelToForm(get((int)userSearchForm.getTableSearch().
                   getValueAt(userSearchForm.getTableSearch().getSelectedRow(), 0)));
       }
    }

    private void delete() {
        int selectedRow = userSearchForm.getTableSearch().getSelectedRow();
        if (deleteApproveMessage(selectedRow)) {
            delete((int) userSearchForm.getTableSearch().getValueAt(selectedRow, 0));
        }
        search();
    }

    private void setLanguage() {
        userSearchForm.setTitle(setLanguage("usersearchform.title"));
        userSearchForm.getButtonAdd().setText(setLanguage("table.button.add"));
        userSearchForm.getButtonUpdate().setText(setLanguage("table.button.update"));
        userSearchForm.getButtonDelete().setText(setLanguage("table.button.delete"));
        userSearchForm.getButtonWrite().setText(setLanguage("table.button.write.excel"));
        userSearchForm.getLabelSearch().setText(setLanguage("table.search"));
    }
}
