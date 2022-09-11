/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.user;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.main.MainForm;
import com.ugurtech.library.aa_presentation.view.user.UserForm;
import com.ugurtech.library.aa_presentation.view.user.UserSearchForm;

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

    }

    @Override
    public void initController() {
        userSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
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
    
    public void search(){
        userSearchForm.getTableSearch().setModel(search(userSearchForm.getTextFieldSearch().getText()));
    }

    private void write() {
        write(userSearchForm.getTableSearch(), userSearchForm.getTitle());
    }

    private void add() {
        MainForm.getInstance().addDesktopPane(UserForm.INSTANCE);
    }

    private void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
