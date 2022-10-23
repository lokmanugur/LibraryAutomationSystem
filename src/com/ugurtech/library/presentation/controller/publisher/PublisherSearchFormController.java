/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.publisher;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.publisher.PublisherForm;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.presentation.view.publisher.PublisherSearchForm;

/**
 *
 * @author ugur
 *
 */
public class PublisherSearchFormController extends PublisherController implements Initialize {

    private final PublisherSearchForm publisherSearchForm;

    public PublisherSearchFormController(PublisherSearchForm publisherSearchForm) {
        this.publisherSearchForm = publisherSearchForm;
        initView();
        initController();
    }

    public void search() {
        publisherSearchForm.getTablePublisher().setModel(search(publisherSearchForm.getTextFieldSearch().getText()));
    }

    @Override
    public final void initView() {
        setLanguage();
        search();
    }

    @Override
    public final void initController() {
        publisherSearchForm.getButtonAdd().addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
        });

        publisherSearchForm.getButtonUpdate().addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
        });

        publisherSearchForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
        });
        publisherSearchForm.getButtonWrite().addActionListener((java.awt.event.ActionEvent evt) -> {
            //write to excel
        });

        publisherSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

    }

    protected void add() {
       MainForm.getInstance().addDesktopPane(PublisherForm.INSTANCE); 
    }

    private void delete() {
        if (publisherSearchForm.getTablePublisher().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
        } else if (UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"))) {
            delete((Integer)(publisherSearchForm.getTablePublisher().getModel().getValueAt(publisherSearchForm.getTablePublisher().getSelectedRow(), 0)));

        }
        search();
    }

    private void update() {
        if (publisherSearchForm.getTablePublisher().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.update.unselectedrow"));
        } else {
            MainForm.getInstance().addDesktopPane(PublisherForm.INSTANCE);
            publisherModel = get((int) publisherSearchForm.getTablePublisher().getModel().getValueAt(publisherSearchForm.getTablePublisher().getSelectedRow(), 0));
            PublisherForm.INSTANCE.setPublisherModel(publisherModel);
            PublisherForm.INSTANCE.getPublisherFormController().modelToForm();
        }

    }

    public void clearAllField() {
        publisherSearchForm.getTextFieldSearch().setText(null);
        search();
    }

    private void setLanguage() {
        publisherSearchForm.setTitle(setLanguage("publisherform.title"));
        publisherSearchForm.getLabelSearch().setText(setLanguage("table.label.search"));
        publisherSearchForm.getButtonAdd().setText(setLanguage("table.button.add"));
        publisherSearchForm.getButtonUpdate().setText(setLanguage("table.button.update"));
        publisherSearchForm.getButtonDelete().setText(setLanguage("table.button.delete"));
         publisherSearchForm.getButtonWrite().setText(setLanguage("table.button.write.excel"));
    }
}
