package com.ugurtech.library.view.student;

import com.ugurtech.library.controller.StudentSearchFormController;
import com.ugurtech.library.service.io.TableToExcelImpl;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;

/**
 *
 * @author lokman uğur
 * 
 */
public final class StudentSearchForm extends JInternalFrame {

    private static StudentSearchForm studentSearchForm;
    private final StudentSearchFormController studentSearchFormController;
    
    private StudentSearchForm() {
        initComponents();
        studentSearchFormController = new StudentSearchFormController(this);
        setLocation(getWidth()/10,getHeight()/10);
    } 

    public static StudentSearchForm getInstance(){
        if(studentSearchForm == null)
            return studentSearchForm = new StudentSearchForm();
        else
            return studentSearchForm;
    }
 /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelToolBar = new javax.swing.JPanel();
        panelGuncelleme = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        panelSearch = new javax.swing.JPanel();
        studentNumberTextField = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        studentNameTextField = new javax.swing.JTextField();
        panelOut = new javax.swing.JPanel();
        writeFlileButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Öğrenci Bilgi Ayrıntı Tablosu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelGuncelleme.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        updateButton.setText("Güncelle");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Sil");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGuncellemeLayout = new javax.swing.GroupLayout(panelGuncelleme);
        panelGuncelleme.setLayout(panelGuncellemeLayout);
        panelGuncellemeLayout.setHorizontalGroup(
            panelGuncellemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuncellemeLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(panelGuncellemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGuncellemeLayout.setVerticalGroup(
            panelGuncellemeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuncellemeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ara", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        studentNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studentNumberTextFieldKeyReleased(evt);
            }
        });

        labelID.setText("Öğrenci No:");

        searchButton.setText("Ara");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Adı Soyadı:");

        studentNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studentNameTextFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(labelID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(studentNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelOut.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Çıktı", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        writeFlileButton.setText("Excelle Yaz");
        writeFlileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeFlileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOutLayout = new javax.swing.GroupLayout(panelOut);
        panelOut.setLayout(panelOutLayout);
        panelOutLayout.setHorizontalGroup(
            panelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(writeFlileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelOutLayout.setVerticalGroup(
            panelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(writeFlileButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelToolBarLayout = new javax.swing.GroupLayout(panelToolBar);
        panelToolBar.setLayout(panelToolBarLayout);
        panelToolBarLayout.setHorizontalGroup(
            panelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelToolBarLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGuncelleme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelToolBarLayout.setVerticalGroup(
            panelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelToolBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGuncelleme, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jScrollPane1.setViewportView(studentTable);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(panelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(panelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
    );

    getAccessibleContext().setAccessibleName("Menu Hareket");

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       studentSearchFormController.fillAllStudents();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        studentSearchFormController.deleteStudent();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        studentSearchFormController.updateStudent();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void writeFlileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeFlileButtonActionPerformed
        new TableToExcelImpl(studentTable, "Öğrenci Bilgi Tablosu").writeToTable();
    }//GEN-LAST:event_writeFlileButtonActionPerformed

    private void studentNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentNumberTextFieldKeyReleased
        studentSearchFormController.fillAllStudents();
    }//GEN-LAST:event_studentNumberTextFieldKeyReleased

    private void studentNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentNameTextFieldKeyReleased
        studentSearchFormController.fillAllStudents();
    }//GEN-LAST:event_studentNameTextFieldKeyReleased
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelID;
    private javax.swing.JPanel panelGuncelleme;
    private javax.swing.JPanel panelOut;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelToolBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField studentNameTextField;
    private javax.swing.JTextField studentNumberTextField;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton writeFlileButton;
    // End of variables declaration//GEN-END:variables

    public JTextField getStudentNameTextField() {
        return studentNameTextField;
    }

    public void setStudentNameTextField(JTextField studentNameTextField) {
        this.studentNameTextField = studentNameTextField;
    }

    public JTextField getStudentNumberTextField() {
        return studentNumberTextField;
    }

    public void setStudentNumberTextField(JTextField studentNumberTextField) {
        this.studentNumberTextField = studentNumberTextField;
    }

    public JTable getStudentTable() {
        return studentTable;
    }

    public void setStudentTable(JTable studentTable) {
        this.studentTable = studentTable;
    }

}
