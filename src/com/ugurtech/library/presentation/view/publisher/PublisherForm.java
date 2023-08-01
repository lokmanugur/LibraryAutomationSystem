/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.view.publisher;

import resources.lib.validation.UserInfoMessages;
import com.ugurtech.library.model.PublisherModel;
import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.controller.publisher.PublisherController;
import java.util.Objects;

/**
 *
 * @author ugur
 */
public final class PublisherForm extends PublisherController implements Initialize {

    public static final PublisherForm INSTANCE = new PublisherForm();

    private PublisherForm() {
        initComponents();
        initView();
        initController();
        setLocation(getWidth() / 2, getHeight() / 10);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldPhone = new javax.swing.JFormattedTextField();
        labelPhone = new javax.swing.JLabel();
        labelPublisher = new javax.swing.JLabel();
        textFieldPublisher = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaAddress = new javax.swing.JTextArea();
        labelAddress = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Publisher Form");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName(""); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        try {
            textFieldPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+90 ### ### ## ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPhone.setText("Telefon:");

        labelPublisher.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPublisher.setText("Yayıncı Kuruluş:");

        textAreaAddress.setColumns(20);
        textAreaAddress.setRows(5);
        jScrollPane1.setViewportView(textAreaAddress);

        labelAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAddress.setText("Adres:");
        labelAddress.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        buttonSave.setText("Save");
        buttonSave.setPreferredSize(new java.awt.Dimension(80, 35));

        buttonCancel.setText("Cancel");
        buttonCancel.setPreferredSize(new java.awt.Dimension(80, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textFieldPublisher, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(textFieldPhone, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldPublisher)
                    .addComponent(labelPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelPublisher;
    private javax.swing.JTextArea textAreaAddress;
    private javax.swing.JFormattedTextField textFieldPhone;
    private javax.swing.JTextField textFieldPublisher;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initView() {
        setLanguage();
    }

    @Override
    public void initController() {
        buttonSave.addActionListener(((java.awt.event.ActionEvent evt) -> {
            if (Objects.isNull(publisherModel)) {
                add(formToModel(new PublisherModel()));
                clearAllField();
                PublisherSearchForm.INSTANCE.initView();
            } else {
                update(formToModel(publisherModel));
                publisherModel = null;
                clearAllField();
                PublisherSearchForm.INSTANCE.initView();
            }
        }));
        buttonCancel.addActionListener((java.awt.event.ActionEvent evt) -> {
            clearAllField();
            publisherModel = null;
            dispose();
        });
    }

    public void modelToForm(PublisherModel publisherModel) {
        textFieldPublisher.setText(publisherModel.getPublisherName());
        textFieldPhone.setText(publisherModel.getPhone());
        textAreaAddress.setText(publisherModel.getAddress());
        this.publisherModel = publisherModel;
    }

    private PublisherModel formToModel(PublisherModel publisherModel) {
        publisherModel.setPublisherName(textFieldPublisher.getText());
        publisherModel.setPhone(textFieldPhone.getText());
        publisherModel.setAddress(textAreaAddress.getText());
        return publisherModel;
    }

    public void clearAllField() {
        textAreaAddress.setText(null);
        textFieldPublisher.setText(null);
        textFieldPhone.setText("");
    }

    private void setLanguage() {
        setTitle(setLanguage("publisherform.title"));
        labelPublisher.setText(setLanguage("publisherform.panelpublisher.labelpublisher"));
        labelPhone.setText(setLanguage("publisherform.panelpublisher.labelphone"));
        labelAddress.setText(setLanguage("publisherform.panelpublisher.labeladdress"));
        buttonCancel.setText(setLanguage("form.button.cancel"));
        buttonSave.setText(setLanguage("form.button.save"));
    }
}
