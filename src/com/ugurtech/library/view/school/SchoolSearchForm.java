package com.ugurtech.library.view.school;

import com.ugurtech.library.controller.SchoolSearchFormController;
import com.ugurtech.library.service.io.TableToExcelImpl;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class SchoolSearchForm extends JInternalFrame {

    private static SchoolSearchForm schoolSearchForm;
    private final SchoolSearchFormController schoolSearchFromController;
    
    private SchoolSearchForm(){
        initComponents();
        schoolSearchFromController = new SchoolSearchFormController(this);
        setLocation(getWidth()/5,getHeight()/10);
        schoolSearchFromController.fillAllSchool();
    }
    
    public static SchoolSearchForm getInstance(){
        if(schoolSearchForm==null)
            return schoolSearchForm = new SchoolSearchForm();
        else
            return schoolSearchForm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneTable = new javax.swing.JScrollPane();
        schoolsTable = new javax.swing.JTable();
        panelProperties = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        schoolNameTextField = new javax.swing.JTextField();
        schoolNameLabel = new javax.swing.JLabel();
        academicYearLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        phoneTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        searchTextFeild = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        academicYearLabel1 = new javax.swing.JLabel();
        academicYearLabel2 = new javax.swing.JLabel();
        printPanel = new javax.swing.JPanel();
        writeToExell = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Okul Bilgileri Tablosu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        schoolsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }

        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    scrollPaneTable.setViewportView(schoolsTable);

    searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ara", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

    schoolNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    schoolNameLabel.setText("Okul Adı:");

    academicYearLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    academicYearLabel.setText("Telefon:");

    addressTextArea.setColumns(15);
    addressTextArea.setRows(3);
    jScrollPane1.setViewportView(addressTextArea);

    saveButton.setText("Kaydet");
    saveButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            saveButtonActionPerformed(evt);
        }
    });

    searchTextFeild.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            searchTextFeildKeyReleased(evt);
        }
    });

    deleteButton.setText("Sil");
    deleteButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteButtonActionPerformed(evt);
        }
    });

    academicYearLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    academicYearLabel1.setText("Ara:");

    academicYearLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    academicYearLabel2.setText("Adres:");

    javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
    searchPanel.setLayout(searchPanelLayout);
    searchPanelLayout.setHorizontalGroup(
        searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(searchPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(academicYearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(schoolNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(academicYearLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(searchTextFeild)
                .addComponent(schoolNameTextField)
                .addComponent(phoneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(academicYearLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(searchPanelLayout.createSequentialGroup()
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );
    searchPanelLayout.setVerticalGroup(
        searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(searchPanelLayout.createSequentialGroup()
            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(searchPanelLayout.createSequentialGroup()
                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(schoolNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(schoolNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(academicYearLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(academicYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(academicYearLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    printPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Çıktı", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

    writeToExell.setText("Exelle Yaz");
    writeToExell.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            writeToExellActionPerformed(evt);
        }
    });

    updateButton.setText("Güncelle");
    updateButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            updateButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout printPanelLayout = new javax.swing.GroupLayout(printPanel);
    printPanel.setLayout(printPanelLayout);
    printPanelLayout.setHorizontalGroup(
        printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(printPanelLayout.createSequentialGroup()
            .addContainerGap(22, Short.MAX_VALUE)
            .addGroup(printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(writeToExell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(24, Short.MAX_VALUE))
    );
    printPanelLayout.setVerticalGroup(
        printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(printPanelLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(writeToExell, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(31, 31, 31))
    );

    javax.swing.GroupLayout panelPropertiesLayout = new javax.swing.GroupLayout(panelProperties);
    panelProperties.setLayout(panelPropertiesLayout);
    panelPropertiesLayout.setHorizontalGroup(
        panelPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelPropertiesLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(printPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    panelPropertiesLayout.setVerticalGroup(
        panelPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelPropertiesLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(6, 6, 6))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(scrollPaneTable)
        .addComponent(panelProperties, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(panelProperties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
    );

    getAccessibleContext().setAccessibleName("Okul Bilgileri");

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        schoolSearchFromController.deleteSchool();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        schoolSearchFromController.updateSchool();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void writeToExellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeToExellActionPerformed
        new TableToExcelImpl(schoolsTable, "Okul Bilgileri").writeToTable();
    }//GEN-LAST:event_writeToExellActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        schoolSearchFromController.addSchool();
        schoolSearchFromController.fillAllSchool();
        clearAllField();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void searchTextFeildKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFeildKeyReleased
        schoolSearchFromController.fillAllSchool();
    }//GEN-LAST:event_searchTextFeildKeyReleased
   
    public void clearAllField(){
        addressTextArea.setText(null);
        phoneTextField.setText(null);
        schoolNameTextField.setText(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel academicYearLabel;
    private javax.swing.JLabel academicYearLabel1;
    private javax.swing.JLabel academicYearLabel2;
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelProperties;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JPanel printPanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel schoolNameLabel;
    private javax.swing.JTextField schoolNameTextField;
    private javax.swing.JTable schoolsTable;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextFeild;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton writeToExell;
    // End of variables declaration//GEN-END:variables

    public JTextArea getAddressTextArea() {
        return addressTextArea;
    }

    public void setAddressTextArea(JTextArea addressTextArea) {
        this.addressTextArea = addressTextArea;
    }

    public JTextField getPhoneTextField() {
        return phoneTextField;
    }

    public void setPhoneTextField(JTextField phoneTextField) {
        this.phoneTextField = phoneTextField;
    }

    public JTextField getSchoolNameTextField() {
        return schoolNameTextField;
    }

    public void setSchoolNameTextField(JTextField schoolNameTextField) {
        this.schoolNameTextField = schoolNameTextField;
    }

    public JTextField getSearchTextFeild() {
        return searchTextFeild;
    }

    public void setSearchTextFeild(JTextField searchTextFeild) {
        this.searchTextFeild = searchTextFeild;
    }

    public JTable getSchoolsTable() {
        return schoolsTable;
    }

    public void setSchoolsTable(JTable schoolsTable) {
        this.schoolsTable = schoolsTable;
    }

}