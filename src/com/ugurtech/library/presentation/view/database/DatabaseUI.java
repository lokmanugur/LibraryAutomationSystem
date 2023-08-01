/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.view.database;

import resources.lib.ReadXML;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Administrator
 */
public class DatabaseUI extends JInternalFrame {

    public static final DatabaseUI INSTANCE = new DatabaseUI(); ;
    ReadXML readxml = new ReadXML();
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

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Database");

        panelDB.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Database Connection Settings"));

        labelUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUrl.setText("Server Address:");

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

        javax.swing.GroupLayout panelDBLayout = new javax.swing.GroupLayout(panelDB);
        panelDB.setLayout(panelDBLayout);
        panelDBLayout.setHorizontalGroup(
            panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDBLayout.createSequentialGroup()
                        .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelDBName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldPortNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldDBName)
                            .addComponent(textFieldServerAddress)
                            .addComponent(textFieldUserName)
                            .addComponent(textFieldPassword)))
                    .addGroup(panelDBLayout.createSequentialGroup()
                        .addComponent(buttonDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFillDefault)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave)))
                .addContainerGap())
        );
        panelDBLayout.setVerticalGroup(
            panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDBLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldServerAddress)
                    .addComponent(labelUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPort, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPortNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDBName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldDBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSave)
                    .addComponent(buttonFillDefault)
                    .addComponent(buttonDefault))
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
                .addContainerGap(22, Short.MAX_VALUE))
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
    private javax.swing.JPanel panelDB;
    private javax.swing.JTextField textFieldDBName;
    private javax.swing.JPasswordField textFieldPassword;
    private javax.swing.JTextField textFieldPortNumber;
    private javax.swing.JTextField textFieldServerAddress;
    private javax.swing.JTextField textFieldUserName;
    // End of variables declaration//GEN-END:variables
   
    
    
    private void getVarsayilan(){
        textFieldServerAddress.setText("localhost");
        textFieldPortNumber.setText("3306");
        textFieldDBName.setText("library");
        textFieldUserName.setText("root");
        textFieldPassword.setText("");
    }
    private void getReadXml(){
        readxml.readXML(Paths.get("").toAbsolutePath().toString() +"/SQLite/server.xml");
        if(!readxml.getRolev().isEmpty()){
            textFieldServerAddress.setText(readxml.getRolev().get(0));
        if(!readxml.getRolev().get(0).isEmpty())
            textFieldPortNumber.setText(readxml.getRolev().get(1));
        if(!readxml.getRolev().get(1).isEmpty())
            textFieldDBName.setText(readxml.getRolev().get(2));
        if(!readxml.getRolev().get(2).isEmpty())
            textFieldUserName.setText(readxml.getRolev().get(3));
        if(!readxml.getRolev().get(3).isEmpty())
            textFieldPassword.setText(readxml.getRolev().get(4));
        }
    }
    private void saveXml(){
        readxml.setServerAdress(textFieldServerAddress.getText());
        readxml.setPort(textFieldPortNumber.getText());
        readxml.setDatabaseName(textFieldDBName.getText());
        readxml.setUserName(textFieldUserName.getText());
        readxml.setPassword(String.valueOf(textFieldPassword.getPassword()));
        try{
            readxml.saveToXML(Paths.get("").toAbsolutePath().toString() +"/SQLite/server.xml");
        }catch (FileNotFoundException ex){
            Logger.getLogger(DatabaseUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initController() {
        buttonFillDefault.addActionListener((e)->{
            getReadXml();
        });
        buttonSave.addActionListener((e)->{
            saveXml();
        });
        buttonDefault.addActionListener((e)->{
            getVarsayilan();
        });
    }
    
}