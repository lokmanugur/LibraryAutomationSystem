/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.persistancev2.author.AuthorDaoImpl;
import com.ugurtech.library.service.author.AuthorService;
import com.ugurtech.library.service.author.AuthorServiceImpl;
import com.ugurtech.library.service.io.TableToExcelImpl;
import com.ugurtech.library.view.MainForm;
import com.ugurtech.library.view.author.AuthorForm;
import com.ugurtech.library.view.author.AuthorSearchForm;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 */
public final class AuthorSearchController extends AbstractController {

    private final AuthorSearchForm authorSearchForm;
    private AuthorModel authorModel;
    private final AuthorService authorService = new AuthorServiceImpl(new AuthorDaoImpl());

    public AuthorSearchController(AuthorSearchForm authorSearchForm) {
        this.authorSearchForm = authorSearchForm;
        initView();
        initController();
    }

    void search() {
        authorSearchForm.getAuthorTable().setModel(DbUtils.resultSetToTableModel(authorService.search(authorSearchForm.getTextFieldSearch().getText())));
    }

    void delete() {
        if (authorSearchForm.getAuthorTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
        } else if (UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"))) {
            authorService.delete(authorService.get((int) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 0)));
        }
    }

    void update() {
        this.authorModel = new AuthorModel();
        if (authorSearchForm.getAuthorTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.update.unselectedrow"));
        } else {
            authorModel.setAuthorId((int) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 0));
            authorModel.setFirstName((String) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 1));
            authorModel.setLastName((String) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 2));
            // authorModel.setBirthDate(DateUtil.parseYYYYMMDDDate(authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(),3).toString()));
            authorModel.setPhone((String) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 4));
            authorModel.setAddress((String) authorSearchForm.getAuthorTable().getModel().getValueAt(authorSearchForm.getAuthorTable().getSelectedRow(), 5));
            authorService.update(authorModel);
        }

    }

    @Override
    void initView() {
        setLanguage();
        search();
    }

    @Override
    void initController() {
        authorSearchForm.getButtonUpdate().addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
            search();
        });

        authorSearchForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
            search();
        });

        authorSearchForm.getButtonAdd().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.getInstance().addDesktopPane(AuthorForm.getInstance());
        });

        authorSearchForm.getButtonWriteFile().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeExel();
            }

            private void writeExel() {
                new TableToExcelImpl(authorSearchForm.getAuthorTable(), setLanguage("authorsearchform.title")).writeToTable();
            }
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
}
