/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.application.lib.log;

import com.ugurtech.library.application.lib.validation.UserInfoMessages;
import java.awt.Component;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class LogInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form LogInternalFrame
     */
    public static LogInternalFrame INSTANCE = new LogInternalFrame();

    private static final Logger logger = Logger.getLogger("LibraryAutomationSystemLog");
    private FileHandler fh = null;
    SimpleFormatter formatter;

    private LogInternalFrame() {
        initComponents();

        try {
            fh = new FileHandler(Paths.get("").toAbsolutePath().toString() + "/LogDirectory/LibraryLogFile.log", true);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(UserInfoMessages.class.getName()).log(Level.SEVERE, null, ex);
        }
        formatter = new SimpleFormatter();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneException = new javax.swing.JTextPane();

        jScrollPane1.setViewportView(textPaneException);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane textPaneException;
    // End of variables declaration//GEN-END:variables

    public void addLoggerFile(Component parentComponent, String message) {
        // This block configure the logger with handler and formatter  
        logger.addHandler(fh);

        fh.setFormatter(formatter);

        // the following statement is used to log any messages  
        logger.log(Level.INFO, "{0} {1}", new Object[]{parentComponent.getClass().getName(), message});
    }

    public void addLoggerFile(String className, String message) {
        // This block configure the logger with handler and formatter  
        logger.addHandler(fh);

        fh.setFormatter(formatter);

        // the following statement is used to log any messages  
        logger.log(Level.SEVERE, "{0} {1}", new Object[]{className, message});
    }

    public void exceptionInfoMessages(Component parentComponent, String message, String title) {
        LogInternalFrame.INSTANCE.addLoggerFile(parentComponent, message);
    }

    public void exceptionInfoMessages(String className, String message, String title) {
        LogInternalFrame.INSTANCE.addLoggerFile(className, message);
    }
}
