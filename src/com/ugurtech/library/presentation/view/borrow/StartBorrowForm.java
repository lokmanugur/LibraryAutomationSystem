/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.view.borrow;
import com.toedter.calendar.JDateChooser;
import resources.lib.localization.Internationalization;
import resources.lib.localization.LanguageImpl;
import com.ugurtech.library.presentation.view.logFrame.LogInternalFrame;
import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.model.PersonBookModel;
import com.ugurtech.library.model.StudentModel;
import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.controller.borrow.ControllerImpl;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.student.StudentForm;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ugur
 * 
 */
public final class StartBorrowForm extends ControllerImpl implements Initialize {

    public static StartBorrowForm INSTANCE = new StartBorrowForm();
    private final Map<Long, Vector<Object>> dataMap;
    DefaultTableModel defaultTableModel;
    private StartBorrowForm() {
        initComponents();
        initView();
        initController();
        dataMap = new HashMap<>();
        setLocation(getWidth()/2, getHeight()/10);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelStudent = new javax.swing.JPanel();
        labelFirstLast = new javax.swing.JLabel();
        labelNumber = new javax.swing.JLabel();
        labelGrade = new javax.swing.JLabel();
        labelSchool = new javax.swing.JLabel();
        labelPhone = new javax.swing.JLabel();
        labelAddress = new javax.swing.JLabel();
        buttonAddPerson = new javax.swing.JButton();
        fieldNumber = new javax.swing.JLabel();
        fieldGrade = new javax.swing.JLabel();
        fieldSchool = new javax.swing.JLabel();
        fieldPhone = new javax.swing.JLabel();
        fieldAddress = new javax.swing.JLabel();
        photoIcon = new javax.swing.JLabel();
        comboBoxPerson = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableBasket = new javax.swing.JTable();
        panelBottom = new javax.swing.JPanel();
        buttonSave = new javax.swing.JButton();
        dateChooserDeadline = new JDateChooser();
        labelDeadline = new javax.swing.JLabel();
        buttonRemove = new javax.swing.JButton();
        buttonRemoveAll = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Book Basket");
        setNextFocusableComponent(fieldNumber);

        panelStudent.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)),LanguageImpl.setLanguage(Internationalization::setLanguage, "startborrowform.bordertitle")));

        labelFirstLast.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelFirstLast.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelFirstLast.setText("Name Surname:");

        labelNumber.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNumber.setText("Number:");

        labelGrade.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelGrade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelGrade.setText("Grade:");

        labelSchool.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelSchool.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSchool.setText("School:");

        labelPhone.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPhone.setText("Phone:");

        labelAddress.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        labelAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAddress.setText("Address:");

        buttonAddPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/graduated32.png"))); // NOI18N

        comboBoxPerson.setEditable(true);
        comboBoxPerson.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelStudentLayout = new javax.swing.GroupLayout(panelStudent);
        panelStudent.setLayout(panelStudentLayout);
        panelStudentLayout.setHorizontalGroup(
            panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSchool, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFirstLast, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStudentLayout.createSequentialGroup()
                        .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fieldSchool, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(fieldGrade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxPerson, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addComponent(buttonAddPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(photoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelStudentLayout.setVerticalGroup(
            panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStudentLayout.createSequentialGroup()
                        .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAddPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelFirstLast, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(photoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );

        defaultTableModel = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                LanguageImpl.setLanguage(Internationalization::setLanguage,"bookbasket.table.header.bookid"),
                LanguageImpl.setLanguage(Internationalization::setLanguage, "bookbasket.table.header.isbn"),
                LanguageImpl.setLanguage(Internationalization::setLanguage, "bookbasket.table.header.booktitle"),
                LanguageImpl.setLanguage(Internationalization::setLanguage, "bookbasket.table.header.amount")
            }
        ){
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        tableBasket.setModel(defaultTableModel);
        jScrollPane3.setViewportView(tableBasket);

        buttonSave.setText("Save");

        labelDeadline.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDeadline.setText("Deadline:");

        buttonRemove.setText("Remove");

        buttonRemoveAll.setText("Remove All");

        javax.swing.GroupLayout panelBottomLayout = new javax.swing.GroupLayout(panelBottom);
        panelBottom.setLayout(panelBottomLayout);
        panelBottomLayout.setHorizontalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBottomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(dateChooserDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(buttonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRemoveAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBottomLayout.setVerticalGroup(
            panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBottomLayout.createSequentialGroup()
                .addGroup(panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBottomLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRemoveAll, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBottomLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateChooserDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelBottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddPerson;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JButton buttonRemoveAll;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<StudentModel> comboBoxPerson;
    private com.toedter.calendar.JDateChooser dateChooserDeadline;
    private javax.swing.JLabel fieldAddress;
    private javax.swing.JLabel fieldGrade;
    private javax.swing.JLabel fieldNumber;
    private javax.swing.JLabel fieldPhone;
    private javax.swing.JLabel fieldSchool;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelDeadline;
    private javax.swing.JLabel labelFirstLast;
    private javax.swing.JLabel labelGrade;
    private javax.swing.JLabel labelNumber;
    private javax.swing.JLabel labelPhone;
    private javax.swing.JLabel labelSchool;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelStudent;
    private javax.swing.JLabel photoIcon;
    private javax.swing.JTable tableBasket;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void initView() {
        AutoCompleteDecorator.decorate(comboBoxPerson);
        fillAllPersonToComboBox();
        setLanguage();
    }

    @Override
    public void initController() {
        comboBoxPerson.getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {
                    fillPersonToLabels();
                }
            }
        });
        buttonAddPerson.addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.INSTANCE.addDesktopPane(StudentForm.INSTANCE);
        });
        buttonRemove.addActionListener((java.awt.event.ActionEvent evt) -> {
            removeFromHashMap();
        });
        buttonRemoveAll.addActionListener((java.awt.event.ActionEvent evt) -> {
            removeAllFromHashMap();
        });
        buttonSave.addActionListener((java.awt.event.ActionEvent evt) -> {
            save();
        });
        comboBoxPerson.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {

            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                fillPersonToLabels();
            }

            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                fillAllPersonToComboBox();
            }
        });
    }

    private void fillAllPersonToComboBox() {
        comboBoxPerson.removeAllItems();
        studentService.getAll().forEach(studentModel -> comboBoxPerson.addItem(studentModel));
    }

    private void fillPersonToLabels() {
        try {
            if (!comboBoxPerson.getSelectedItem().equals("")
                    && comboBoxPerson.getSelectedItem() != null) {
                StudentModel studentModel = (StudentModel) comboBoxPerson.getSelectedItem();
                fieldGrade.setText(studentModel.getClssModel().getClssName());
                fieldNumber.setText(studentModel.getStudentNumber());
                fieldSchool.setText(studentModel.getSchoolModel().getSchoolName());
                fieldAddress.setText(studentModel.getAddress());
                fieldPhone.setText(studentModel.getPhone());
            }

        } catch (Exception e) {
            LogInternalFrame.INSTANCE.exceptionInfoMessages(this.getName(), e, "Error Message");
        }

    }

    private void removeFromHashMap() {
        int selectedRow = tableBasket.getSelectedRow();
        if (selectedRow != -1) {
            dataMap.remove((long) tableBasket.getValueAt(selectedRow, 1));
            DefaultTableModel dm = (DefaultTableModel) tableBasket.getModel();
            dm.removeRow(selectedRow);
            setIconToBackround();
        }
    }

    private void removeAllFromHashMap() {
        dataMap.clear();
        removeAllElementsFromTable();
        setIconToBackround();
    }

    public void addHashMap(long key, Vector<Object> value, int stock) {
        if (dataMap.containsKey(key) && stock > (int) dataMap.get(key).get(3)) {
            dataMap.get(key).setElementAt((int) dataMap.get(key).get(3) + 1, 3);
        } else if (stock > 0) {
            dataMap.put(key, value);
        }
        hashMapToTable();
    }

    private void hashMapToTable() {
        removeAllElementsFromTable();
        dataMap.entrySet().forEach(entry -> {
            defaultTableModel.addRow(entry.getValue());
        });
        setIconToBackround();
    }

    private void removeAllElementsFromTable() {
        DefaultTableModel dm = (DefaultTableModel) tableBasket.getModel();
        int rowCount = tableBasket.getModel().getRowCount();
        if (rowCount > 0) {
            for (int row = rowCount - 1; row >= 0; row--) {
                dm.removeRow(row);
            }
        }
    }

    private void save() {
        if ((!fieldAddress.getText().equals("")
                || !fieldPhone.getText().equals("")
                || !fieldNumber.getText().equals("")
                || !fieldSchool.getText().equals("")
                || !fieldGrade.getText().equals(""))
                && !(dateChooserDeadline.getDate()==null)) {
            StudentModel studentModel = (StudentModel) comboBoxPerson.getSelectedItem();
            BookModel bookModel;
            PersonBookModel personBookModel = new PersonBookModel();
            List<BookModel> bookList = new ArrayList<>();
            int rowCount = tableBasket.getRowCount();
            for (int i = rowCount - 1; 0 <= i; i--) {
                    bookModel = new BookModel();
                    bookModel.setBookId((int) tableBasket.getValueAt(i, 0));
                    bookModel.setStock((int) tableBasket.getValueAt(i, 3));
                    bookList.add(bookModel);
            }
            personBookModel.setDeadLine(dateChooserDeadline.getDate().getTime());
            personBookModel.setStartDate(new Date().getTime());
            personBookModel.setBookModel(bookList);
            personBookModel.setStudentModel(studentModel);
            add(personBookModel);
            removeAllFromHashMap();
            removeAllPersonItemFromBasket();
        }
    }

    private void removeAllPersonItemFromBasket() {
        comboBoxPerson.setSelectedItem(null);
        fieldNumber.setText("");
        fieldGrade.setText("");
        fieldSchool.setText("");
        fieldPhone.setText("");
        fieldAddress.setText("");
    }
    
    private void setIconToBackround(){
        if(tableBasket.getRowCount()>0){
            MainForm.INSTANCE.getButtonBasket().setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/basketfull32.png")));
        }else{
            MainForm.INSTANCE.getButtonBasket().setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/basketempty32.png")));
        }
    }

    private void setLanguage() {
        setTitle(setLanguage("startborrowform.title"));
        labelFirstLast.setText(setLanguage("startborrowform.label.namesurname"));
        labelAddress.setText(setLanguage("startborrowform.label.address"));
        labelDeadline.setText(setLanguage("startborrowform.label.deadline"));
        labelGrade.setText(setLanguage("startborrowform.label.grade"));
        labelNumber.setText(setLanguage("startborrowform.label.number"));
        labelPhone.setText(setLanguage("startborrowform.label.phone"));
        labelSchool.setText(setLanguage("startborrowform.label.school"));
        buttonRemove.setText(setLanguage("startborrowform.button.remove"));
        buttonRemoveAll.setText(setLanguage("startborrowform.button.removeall"));
        buttonSave.setText(setLanguage("startborrowform.button.save"));
    }

}
