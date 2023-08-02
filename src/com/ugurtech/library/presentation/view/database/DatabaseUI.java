/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.view.database;

import com.ugurtech.library.model.DatabaseModel;
import com.ugurtech.library.presentation.controller.database.DatabaseController;
/**
 *
 * @author Administrator
 */
public class DatabaseUI extends DatabaseController {

    public static final DatabaseUI INSTANCE = new DatabaseUI(); ;
    private DatabaseModel databaseModel;
    private DatabaseUI() {
       initComponents();
       setLocation(getWidth()/2,getHeight()/10);
       initController();
       getReadXml();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDB = new javax.swing.JPanel();
        labelUrl = new javax.swing.JLabel();
        textFieldServerAddress = new javax.swing.JTextField();
        labelPort = new javax.swing.JLabel();
        textFieldPortNumber = new javax.swing.JTextField();
        textFieldDBName = new javax.swing.JTextField();
        labelDBName = new javax.swing.JLabel();
        textFieldUserName = new javax.swing.JTextField();
        labelUserName = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        textFieldPassword = new javax.swing.JPasswordField();
        buttonSave = new javax.swing.JButton();
        buttonFillDefault = new javax.swing.JButton();
        buttonDefault = new javax.swing.JButton();
        textFieldFilePath = new javax.swing.JTextField();
        labelUserName1 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Database");

        panelDB.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Database Connection Settings"));

        labelUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUrl.setText("Ip Address:");

        labelPort.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPort.setText("Port Number:");

        labelDBName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDBName.setText("Database Name:");

        labelUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUserName.setText("User Name:");

        labelPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPassword.setText("Password:");

        buttonSave.setText("Save Current Setting");

        buttonFillDefault.setText("Get Last Setting");

        buttonDefault.setText("Fill Default");

        labelUserName1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUserName1.setText("File Path:");

        javax.swing.GroupLayout panelDBLayout = new javax.swing.GroupLayout(panelDB);
        panelDB.setLayout(panelDBLayout);
        panelDBLayout.setHorizontalGroup(
            panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDBLayout.createSequentialGroup()
                        .addComponent(buttonDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFillDefault)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave))
                    .addGroup(panelDBLayout.createSequentialGroup()
                        .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelUserName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDBName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPort, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelUrl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDBLayout.createSequentialGroup()
                                .addComponent(textFieldPortNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textFieldDBName)
                            .addComponent(textFieldServerAddress)
                            .addComponent(textFieldUserName)
                            .addComponent(textFieldPassword)
                            .addComponent(textFieldFilePath))))
                .addContainerGap())
        );
        panelDBLayout.setVerticalGroup(
            panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDBLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldServerAddress)
                    .addComponent(labelUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPort, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPortNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDBName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldDBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonFillDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(panelDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDefault;
    private javax.swing.JButton buttonFillDefault;
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel labelDBName;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPort;
    private javax.swing.JLabel labelUrl;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JLabel labelUserName1;
    private javax.swing.JPanel panelDB;
    private javax.swing.JTextField textFieldDBName;
    private javax.swing.JTextField textFieldFilePath;
    private javax.swing.JPasswordField textFieldPassword;
    private javax.swing.JTextField textFieldPortNumber;
    private javax.swing.JTextField textFieldServerAddress;
    private javax.swing.JTextField textFieldUserName;
    // End of variables declaration//GEN-END:variables
   
    
    
    private void setDefaultSettingToTextFields(){
        textFieldServerAddress.setText("localhost");
        textFieldPortNumber.setText("3306");
        textFieldDBName.setText("library");
        textFieldUserName.setText("root");
        textFieldPassword.setText("123");
        textFieldFilePath.setText("/SQLite/library.sqlite");
    }
    
    private void getReadXml(){
        databaseModel = get();
        textFieldServerAddress.setText(databaseModel.getIpAdress());
        textFieldPortNumber.setText(databaseModel.getPortNumber());
        textFieldDBName.setText(databaseModel.getDatabaseName());
        textFieldUserName.setText(databaseModel.getUserName());
        textFieldPassword.setText(databaseModel.getPassword());
        textFieldFilePath.setText(databaseModel.getFilePath());
    }
    
    private void save(){
        databaseModel = new DatabaseModel();
        databaseModel.setIpAdress(textFieldServerAddress.getText());
        databaseModel.setPortNumber(textFieldPortNumber.getText());
        databaseModel.setDatabaseName(textFieldDBName.getText());
        databaseModel.setUserName(textFieldUserName.getText());
        databaseModel.setPassword(String.valueOf(textFieldPassword.getPassword()));
        databaseModel.setFilePath(textFieldFilePath.getText());
        add(databaseModel);
    }

    private void initController() {
        buttonFillDefault.addActionListener((e)->{
            getReadXml();
        });
        buttonSave.addActionListener((e)->{
            save();
        });
        buttonDefault.addActionListener((e)->{
            setDefaultSettingToTextFields();
        });
    }
    
}