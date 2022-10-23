/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.publisher;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.publisher.PublisherForm;
import com.ugurtech.library.presentation.view.publisher.PublisherSearchForm;
import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import com.ugurtech.library.model.PublisherModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public final class PublisherFormController extends PublisherController implements Initialize {

    private final PublisherForm publisherForm;

    public PublisherFormController(PublisherForm publisherForm) {
        this.publisherForm = publisherForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        setLanguage();
    }

    @Override
    public void initController() {
        publisherForm.getButtonSave().addActionListener(((java.awt.event.ActionEvent evt) -> {
            if (publisherForm.getPublisherModel() != null) {
                update();
            } else {
                add();
            }
        }));
        publisherForm.getButtonCancel().addActionListener((java.awt.event.ActionEvent evt) -> {
            clearAllField();
            publisherForm.setPublisherModel(null);
            publisherForm.dispose();
        });
    }

    private void add() {
        add(formToModel());
        clearAllField();
        PublisherSearchForm.INSTANCE.getPublisherController().initView();
    }

    private void update() {
        update(formToModel());
        publisherForm.setPublisherModel(null);
        clearAllField();
        PublisherSearchForm.INSTANCE.getPublisherController().initView();
    }

    public void modelToForm() {
        publisherForm.getTextFieldPublisher().setText(publisherForm.getPublisherModel().getPublisherName());
        publisherForm.getTextFieldPhone().setText(publisherForm.getPublisherModel().getPhone());
        publisherForm.getTextAreaAddress().setText(publisherForm.getPublisherModel().getAddress());
    }

    public void clearAllField() {
        publisherForm.getTextAreaAddress().setText(null);
        publisherForm.getTextFieldPublisher().setText(null);
        publisherForm.getTextFieldPhone().setText("");
    }

    private void setLanguage() {
        publisherForm.setTitle(setLanguage("publisherform.title"));
        publisherForm.getLabelPublisher().setText(setLanguage("publisherform.panelpublisher.labelpublisher"));
        publisherForm.getLabelPhone().setText(setLanguage("publisherform.panelpublisher.labelphone"));
        publisherForm.getLabelAddress().setText(setLanguage("publisherform.panelpublisher.labeladdress"));
        publisherForm.getButtonCancel().setText(setLanguage("form.button.cancel"));
        publisherForm.getButtonSave().setText(setLanguage("form.button.save"));
    }

    private PublisherModel formToModel() {
        PublisherModel pm = null;
        if (publisherForm.getTextFieldPublisher().getText().equals("")) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("publisherform.fill.publishername"));
        } else {
            pm = new PublisherModel();
            pm.setPublisherId(publisherForm.getPublisherModel()==null?0:publisherForm.getPublisherModel().getPublisherId());
            pm.setPublisherName(publisherForm.getTextFieldPublisher().getText());
            pm.setPhone(publisherForm.getTextFieldPhone().getText());
            pm.setAddress(publisherForm.getTextAreaAddress().getText());
        }
        return pm;
    }
}
