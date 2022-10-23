/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.author;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.application.lib.writetofile.TableToExcelImpl;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.author.AuthorForm;
import com.ugurtech.library.presentation.view.author.AuthorSearchForm;

/**
 *
 * @author ugur
 */
public final class AuthorSearchController extends AuthorController implements Initialize {

    private final AuthorSearchForm authorSearchForm;

    public AuthorSearchController(AuthorSearchForm authorSearchForm) {
        this.authorSearchForm = authorSearchForm;
        initView();
        initController();

    }

    private void search() {
        authorSearchForm.getAuthorTable().setModel(search(authorSearchForm.getTextFieldSearch().getText()));
    }

    private void delete() {
        if (authorSearchForm.getAuthorTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
        } else if (UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"))) {
            delete((int) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 0));
        }
    }

    private void update() {
        if (authorSearchForm.getAuthorTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.update.unselectedrow"));
        } else {
            authorModel = get((int) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 0));
            MainForm.getInstance().addDesktopPane(AuthorForm.getInstance());
            AuthorForm.getInstance().setAuthorModel(authorModel);
            AuthorForm.getInstance().getAuthorFormController().modelToForm();
        }
    }

    @Override
    public void initView() {
        setLanguage();
        search();
    }

    @Override
    public void initController() {
        authorSearchForm.getButtonUpdate().addActionListener((java.awt.event.ActionEvent evt) -> {
            this.update();
        });

        authorSearchForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
            search();
        });

        authorSearchForm.getButtonAdd().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.getInstance().addDesktopPane(AuthorForm.getInstance());
        });

        authorSearchForm.getButtonWriteFile().addActionListener((java.awt.event.ActionEvent evt) -> {
            writeExel();
        });

        authorSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });
    }

    private void setLanguage() {
        authorSearchForm.setTitle(setLanguage("authorsearchform.title"));
        authorSearchForm.getLabelSearch().setText(setLanguage("authorsearchform.paneltoolbar.labelsearch"));
        authorSearchForm.getButtonAdd().setText(setLanguage("authorsearchform.paneltoolbar.buttonadd"));
        authorSearchForm.getButtonDelete().setText(setLanguage("authorsearchform.paneltoolbar.buttondelete"));
        authorSearchForm.getButtonUpdate().setText(setLanguage("authorsearchform.paneltoolbar.buttonupdate"));
        authorSearchForm.getButtonWriteFile().setText(setLanguage("authorsearchform.paneltoolbar.buttonwritefile"));
    }

    private void writeExel() {
        new TableToExcelImpl(authorSearchForm.getAuthorTable(), setLanguage("authorsearchform.title")).writeToTable();
    }
}
