/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.view.student;
import com.toedter.calendar.JDateChooser;
import com.ugurtech.library.aa_presentation.controller.student.StudentFormController;
import com.ugurtech.library.ad_model.ClassModel;
import com.ugurtech.library.ad_model.SchoolModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ugur
 * 
 */
public class StudentForm extends JInternalFrame {

    public static StudentForm INSTANCE = new StudentForm();
    private final StudentFormController studentFormController;
    private StudentForm() {
        initComponents();
        studentFormController = new StudentFormController(this);
        AutoCompleteDecorator.decorate(comboBoxSchool);
        setLocation(getWidth()/3, getHeight()/10);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelFirstName = new javax.swing.JLabel();
        textFieldFirstName = new javax.swing.JTextField();
        labelLastName = new javax.swing.JLabel();
        textFieldLastName = new javax.swing.JTextField();
        labelBirthDate = new javax.swing.JLabel();
        labelAddress = new javax.swing.JLabel();
        labelPhone = new javax.swing.JLabel();
        buttonCancel = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        dateChooserBirth = new JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaAddress = new javax.swing.JTextArea();
        textFieldStudentNo = new javax.swing.JTextField();
        labelStudentNo = new javax.swing.JLabel();
        comboBoxSchool = new javax.swing.JComboBox<>();
        labelSchool = new javax.swing.JLabel();
        labelClass = new javax.swing.JLabel();
        comboBoxClass = new javax.swing.JComboBox<>();
        buttonAdd = new javax.swing.JButton();
        formattedTextFieldPhone = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Student Add Form");
        setMinimumSize(new java.awt.Dimension(527, 388));

        labelFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelFirstName.setText("Adı:");
        labelFirstName.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        textFieldFirstName.setPreferredSize(new java.awt.Dimension(300, 35));

        labelLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelLastName.setText("Soyad:");
        labelLastName.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        textFieldLastName.setPreferredSize(new java.awt.Dimension(300, 35));

        labelBirthDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelBirthDate.setText("Doğum yılı");
        labelBirthDate.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAddress.setText("Adres:");
        labelAddress.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelAddress.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelAddress.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        labelPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPhone.setText("Telefon:");
        labelPhone.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        buttonCancel.setText("İptal");
        buttonCancel.setPreferredSize(new java.awt.Dimension(80, 35));

        buttonSave.setText("Kaydet");
        buttonSave.setPreferredSize(new java.awt.Dimension(80, 28));

        textAreaAddress.setColumns(20);
        textAreaAddress.setRows(5);
        jScrollPane2.setViewportView(textAreaAddress);

        textFieldStudentNo.setPreferredSize(new java.awt.Dimension(300, 35));

        labelStudentNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStudentNo.setText("Öğrenci No:");
        labelStudentNo.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        comboBoxSchool.setEditable(true);

        labelSchool.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSchool.setText("Okulu:");

        labelClass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelClass.setText("Sınıfı:");

        comboBoxClass.setEditable(true);

        buttonAdd.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        buttonAdd.setText("+");
        buttonAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonAdd.setMaximumSize(new java.awt.Dimension(40, 35));
        buttonAdd.setMinimumSize(new java.awt.Dimension(40, 35));
        buttonAdd.setPreferredSize(new java.awt.Dimension(40, 35));

        try {
            formattedTextFieldPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+90 ### ### ## ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelBirthDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSchool, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelClass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelStudentNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(comboBoxClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                        .addComponent(comboBoxSchool, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateChooserBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(formattedTextFieldPhone)
                        .addComponent(textFieldStudentNo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(textFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(textFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldStudentNo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStudentNo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelClass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxClass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBoxSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateChooserBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<ClassModel> comboBoxClass;
    private javax.swing.JComboBox<SchoolModel> comboBoxSchool;
    private com.toedter.calendar.JDateChooser dateChooserBirth;
    private javax.swing.JFormattedTextField formattedTextFieldPhone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelBirthDate;
    private javax.swing.JLabel labelClass;
    private javax.swing.JLabel labelFirstName;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelSchool;
    private javax.swing.JLabel labelStudentNo;
    private javax.swing.JTextArea textAreaAddress;
    private javax.swing.JTextField textFieldFirstName;
    private javax.swing.JTextField textFieldLastName;
    private javax.swing.JTextField textFieldStudentNo;
    // End of variables declaration//GEN-END:variables

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public void setButtonAdd(JButton buttonAdd) {
        this.buttonAdd = buttonAdd;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public void setButtonSave(JButton buttonSave) {
        this.buttonSave = buttonSave;
    }

    public JComboBox<ClassModel> getComboBoxClass() {
        return comboBoxClass;
    }

    public void setComboBoxClass(JComboBox<ClassModel> comboBoxClass) {
        this.comboBoxClass = comboBoxClass;
    }

    public JComboBox<SchoolModel> getComboBoxSchool() {
        return comboBoxSchool;
    }

    public void setComboBoxSchool(JComboBox<SchoolModel> comboBoxSchool) {
        this.comboBoxSchool = comboBoxSchool;
    }

    public JDateChooser getDateChooserBirth() {
        return dateChooserBirth;
    }

    public void setDateChooserBirth(JDateChooser dateChooserBirth) {
        this.dateChooserBirth = dateChooserBirth;
    }

    public JFormattedTextField getFormattedTextFieldPhone() {
        return formattedTextFieldPhone;
    }

    public void setFormattedTextFieldPhone(JFormattedTextField formattedTextFieldPhone) {
        this.formattedTextFieldPhone = formattedTextFieldPhone;
    }

    public JLabel getLabelAddress() {
        return labelAddress;
    }

    public void setLabelAddress(JLabel labelAddress) {
        this.labelAddress = labelAddress;
    }

    public JLabel getLabelBirthDate() {
        return labelBirthDate;
    }

    public void setLabelBirthDate(JLabel labelBirthDate) {
        this.labelBirthDate = labelBirthDate;
    }

    public JLabel getLabelClass() {
        return labelClass;
    }

    public void setLabelClass(JLabel labelClass) {
        this.labelClass = labelClass;
    }

    public JLabel getLabelFirstName() {
        return labelFirstName;
    }

    public void setLabelFirstName(JLabel labelFirstName) {
        this.labelFirstName = labelFirstName;
    }

    public JLabel getLabelLastName() {
        return labelLastName;
    }

    public void setLabelLastName(JLabel labelLastName) {
        this.labelLastName = labelLastName;
    }

    public JLabel getLabelPhone() {
        return labelPhone;
    }

    public void setLabelPhone(JLabel labelPhone) {
        this.labelPhone = labelPhone;
    }

    public JLabel getLabelSchool() {
        return labelSchool;
    }

    public void setLabelSchool(JLabel labelSchool) {
        this.labelSchool = labelSchool;
    }

    public JLabel getLabelStudentNo() {
        return labelStudentNo;
    }

    public void setLabelStudentNo(JLabel labelStudentNo) {
        this.labelStudentNo = labelStudentNo;
    }

    public JTextArea getTextAreaAddress() {
        return textAreaAddress;
    }

    public void setTextAreaAddress(JTextArea textAreaAddress) {
        this.textAreaAddress = textAreaAddress;
    }

    public JTextField getTextFieldFirstName() {
        return textFieldFirstName;
    }

    public void setTextFieldFirstName(JTextField textFieldFirstName) {
        this.textFieldFirstName = textFieldFirstName;
    }

    public JTextField getTextFieldLastName() {
        return textFieldLastName;
    }

    public void setTextFieldLastName(JTextField textFieldLastName) {
        this.textFieldLastName = textFieldLastName;
    }

    public JTextField getTextFieldStudentNo() {
        return textFieldStudentNo;
    }

    public void setTextFieldStudentNo(JTextField textFieldStudentNo) {
        this.textFieldStudentNo = textFieldStudentNo;
    }

    @Override
    public void doDefaultCloseAction() {
        studentFormController.clearFormFields();
        this.dispose();
    }

    public StudentFormController getStudentFormController() {
        return studentFormController;
    }
   
}
