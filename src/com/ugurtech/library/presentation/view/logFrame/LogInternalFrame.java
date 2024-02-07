/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.view.logFrame;

import resources.lib.validation.UserInfoMessages;
import com.ugurtech.library.presentation.view.main.MainForm;
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
     * 
     */
    public static final LogInternalFrame INSTANCE = new LogInternalFrame();

    private static final Logger logger = Logger.getLogger("LibraryAutomationSystemLog");
    private FileHandler fileHandler = null;
    SimpleFormatter formatter;

    private LogInternalFrame() {
        initComponents();

        try {
            fileHandler = new FileHandler(Paths.get("").toAbsolutePath().toString() + "/LogDirectory/LibraryLogFile.log", true);
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
        jPanel1 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jScrollPane1.setViewportView(textPaneException);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane textPaneException;
    // End of variables declaration//GEN-END:variables

    public void addLoggerFile(String headerMessage, String message) {
        // This block configure the logger with handler and formatter  
        logger.addHandler(fileHandler);

        fileHandler.setFormatter(formatter);

        // the following statement is used to log any messages  
        logger.log(Level.SEVERE, "{0} {1}", new Object[]{headerMessage, message});
    }

    public void exceptionInfoMessages(String className, Exception exception, String title) {
        String exceptionMessage = className;
        String headerMessage = title+" "+className;
        
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            exceptionMessage += "\n" + stackTraceElement;
        }
        addLoggerFile(headerMessage, exceptionMessage);
        textPaneException.setText(exceptionMessage);
        setTitle(title);
        MainForm.INSTANCE.addDesktopPane(this);
    }
}