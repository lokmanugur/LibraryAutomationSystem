/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.modelv2.PublisherModel;
import com.ugurtech.library.persistancev2.publisher.PublisherDaoImpl;
import com.ugurtech.library.service.publisher.PublisherService;
import com.ugurtech.library.service.publisher.PublisherServiceImpl;
import com.ugurtech.library.view.book.PublisherForm;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 *
 */
public class PublisherController extends AbstractController {

    private final PublisherForm publisherForm;
    private PublisherModel publisherModel;
    private final PublisherService publisherService = new PublisherServiceImpl(new PublisherDaoImpl());

    public PublisherController(PublisherForm publisherForm) {
        this.publisherForm = publisherForm;
        initView();
        initController();
    }

    public void search() {
        publisherForm.getPublisherTable().setModel(DbUtils.resultSetToTableModel(publisherService.search(publisherForm.getPublisherSearchTextField().getText())));
    }

    @Override
    final void initView() {
        search();
    }

    @Override
    final void initController() {
        publisherForm.getSaveButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
        });
        publisherForm.getUpdateButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
        });
        publisherForm.getDeleteButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
        });
        publisherForm.getCancelButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            publisherForm.dispose();
            clearAllField();
        });
        publisherForm.getPublisherSearchTextField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

    }

    @Override
    void add() {
        publisherModel = new PublisherModel();
        if (publisherForm.getPublisherNameTextField().getText().equals("")) {
            UserInfoMessages.getInstance().showInfoMessages("Lütfen Yaıncı Kuruluş: alanını doldurunuz.");
        } else {
            publisherModel.setPublisherName(publisherForm.getPublisherNameTextField().getText());
            publisherModel.setPhone(publisherForm.getPhoneTextField().getText());
            publisherModel.setAddress(publisherForm.getAddressTextArea().getText());
            publisherService.add(publisherModel);
        }
        clearAllField();
        search();
    }

    @Override
    void delete() {
        if (publisherForm.getPublisherTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages("Lütfen silmek istediğiniz veriyi seçin");
        } else if (UserInfoMessages.getInstance().showApproveMessages("Seçilen satırı silmek istediğinize eminmisiniz?", "Silme İşlemi Onay Formu")) {
            publisherService.delete(publisherService.get((Integer)(publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(),0))));
            
        }
        search();
    }

    @Override
    void update() {
        this.publisherModel = new PublisherModel();
        if (publisherForm.getPublisherTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages("Lütfen Güncellemek istediğiniz satırı seçin.");
        } else {
            publisherModel.setPublisherId((int)publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(), 0));
            publisherModel.setPublisherName((String) publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(), 1));
            publisherModel.setPhone((String) publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(), 2));
            publisherModel.setAddress((String) publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(), 3));
            publisherService.update(publisherModel);
        }
        clearAllField();
        search();
    }
    
    public void clearAllField() {
        publisherForm.getAddressTextArea().setText(null);
        publisherForm.getPublisherNameTextField().setText(null);
        publisherForm.getPhoneTextField().setText(null);
        publisherForm.getPublisherSearchTextField().setText(null);
    }
    
    private void setLanguage(){
        publisherForm.getl
    }
}
