/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.borrow;

import com.ugurtech.library.aa_presentation.controller.Initialize;
import com.ugurtech.library.aa_presentation.view.borrow.StartBorrowForm;
import com.ugurtech.library.aa_presentation.view.main.MainForm;
import com.ugurtech.library.aa_presentation.view.student.StudentForm;
import com.ugurtech.library.ab_application.service.student.StudentService;
import com.ugurtech.library.ab_application.service.student.StudentServiceImpl;
import com.ugurtech.library.ac_dataaccesslayer.student.StudentDaoImpl;
import com.ugurtech.library.ad_model.StudentModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ugur
 *
 */
public final class StartBorrowFormController extends ControllerImpl implements Initialize {

    private final StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());
    private final StartBorrowForm startBorrowForm;
    private final Map<Long, Vector<Object>> dataMap;

    public StartBorrowFormController(StartBorrowForm startBorrowBookForm) {
        this.startBorrowForm = startBorrowBookForm;
        dataMap = new HashMap<>();
        initView();
        initController();
    }

    @Override
    public void initView() {
        fillAllPersonToComboBox();
    }

    @Override
    public void initController() {
        startBorrowForm.getComboBoxPerson().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fillPersonToLabels();
            }
        });
        startBorrowForm.getComboBoxPerson().addActionListener((java.awt.event.ActionEvent evt) -> {
//            fillPersonToLabels();
        });
        startBorrowForm.getButtonAddPerson().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.getInstance().addDesktopPane(StudentForm.INSTANCE);
        });
        startBorrowForm.getButtonRemove().addActionListener((java.awt.event.ActionEvent evt) -> {
            removeFromHashMap();
        });
        startBorrowForm.getButtonRemoveAll().addActionListener((java.awt.event.ActionEvent evt) -> {
            removeAllFromHashMap();
        });
        startBorrowForm.getButtonSave().addActionListener((java.awt.event.ActionEvent evt) -> {
            save();
        });        
        startBorrowForm.getComboBoxPerson().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {

            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                fillPersonToLabels();
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                fillAllPersonToComboBox();
            }
        });
    }

    private void fillAllPersonToComboBox() {
        startBorrowForm.getComboBoxPerson().removeAllItems();
        studentService.getAll().forEach((studentModel) -> {
            startBorrowForm.getComboBoxPerson().addItem(studentModel);
        });
    }

    private void fillPersonToLabels() {
        StudentModel studentModel = (StudentModel) startBorrowForm.getComboBoxPerson().getSelectedItem();
        startBorrowForm.getFieldGrade().setText(studentModel.getClassModel().getClassName());
        startBorrowForm.getFieldNumber().setText(studentModel.getStudentNumber());
        startBorrowForm.getFieldSchool().setText(studentModel.getSchoolModel().getSchoolName());
        startBorrowForm.getFieldAddress().setText(studentModel.getAddress());
        startBorrowForm.getFieldPhone().setText(studentModel.getPhone());
    }

    private void removeFromHashMap() {
       int selectedRow = startBorrowForm.getTableBasket().getSelectedRow();
        if (selectedRow != -1) {
            dataMap.remove((long) startBorrowForm.getTableBasket().getValueAt(selectedRow, 1));
            DefaultTableModel dm = (DefaultTableModel) startBorrowForm.getTableBasket().getModel();
            dm.removeRow(selectedRow);
        }
    }

    private void removeAllFromHashMap() {
        dataMap.clear();
        removeAllElementsFromTable();
    }

    public void addHashMap(long key, Vector<Object> value,int stock) {
        if(dataMap.containsKey(key)&&stock>(int)dataMap.get(key).get(3)){
            dataMap.get(key).setElementAt((int)dataMap.get(key).get(3)+1, 3);
        }else if(stock>0){
            dataMap.put(key, value);
        }
        hashMapToTable();
    }

    private void hashMapToTable() {
        removeAllElementsFromTable();
        dataMap.entrySet().forEach(entry -> {
            startBorrowForm.getDefaultTableModel().addRow(entry.getValue());
        });
    }

    private void removeAllElementsFromTable() {
        DefaultTableModel dm = (DefaultTableModel) startBorrowForm.getTableBasket().getModel();
        int rowCount = startBorrowForm.getTableBasket().getModel().getRowCount();
        if (rowCount > 0) {
            for (int row = rowCount - 1; row >= 0; row--) {
                dm.removeRow(row);
            }
        }
    }

    private void save() {
        if(!startBorrowForm.getFieldAddress().getText().isEmpty()||!startBorrowForm.getFieldPhone().getText().isEmpty()
           ||!startBorrowForm.getFieldNumber().getText().isEmpty()||!startBorrowForm.getFieldSchool().getText().isEmpty()
           ||!startBorrowForm.getFieldGrade().getText().isEmpty()){
          StudentModel studentModel =(StudentModel)startBorrowForm.getComboBoxPerson().getSelectedItem();
        }
    }

}
