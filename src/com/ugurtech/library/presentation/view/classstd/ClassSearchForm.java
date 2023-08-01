/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.view.classstd;
import resources.lib.validation.UserInfoMessages;
import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.controller.classstd.ClassController;
import com.ugurtech.library.presentation.view.main.MainForm;

/**
 *
 * @author ugur
 * 
 */
public final class ClassSearchForm extends ClassController implements Initialize {

    public static final ClassSearchForm INSTANCE = new ClassSearchForm();
    private ClassSearchForm() {
        initComponents();
        initView();
        initController();
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

        panel = new javax.swing.JPanel();
        buttonSave = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        textFieldSearch = new javax.swing.JTextField();
        labelSearch = new javax.swing.JLabel();
        buttonWrite = new javax.swing.JButton();
        scrollPaneTable = new javax.swing.JScrollPane();
        tableSearch = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Kitap Türü Ekleme Formu");

        buttonSave.setText("Add");
        buttonSave.setPreferredSize(new java.awt.Dimension(80, 35));

        buttonUpdate.setText("Update");
        buttonUpdate.setPreferredSize(new java.awt.Dimension(80, 35));

        buttonDelete.setText("Delete");
        buttonDelete.setPreferredSize(new java.awt.Dimension(80, 35));

        textFieldSearch.setPreferredSize(new java.awt.Dimension(200, 35));

        labelSearch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSearch.setText("Search");

        buttonWrite.setText("Write Excel");
        buttonWrite.setPreferredSize(new java.awt.Dimension(90, 35));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonWrite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollPaneTable.setViewportView(tableSearch);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneTable)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton buttonWrite;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JTable tableSearch;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables

  @Override
    public void initView() {
        setLanguage();
        search();
    }

    @Override
    public void initController() {
        buttonSave.addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
            clearAllFields();
        });
        buttonWrite.addActionListener((java.awt.event.ActionEvent evt) -> {

        });
        buttonUpdate.addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
        });

        buttonDelete.addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
            clearAllFields();
        });
        textFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });
    }

    public void search() {
        tableSearch.setModel(search(textFieldSearch.getText()));
    }

    protected void add() {
        MainForm.INSTANCE.addDesktopPane(ClassForm.INSTANCE);
    }

    protected void update() {
        if (tableSearch.getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.update.unselectedrow"));
        } else {
            ClassForm classForm = ClassForm.INSTANCE;
            MainForm.INSTANCE.addDesktopPane(classForm);
            classForm.modelToForm(get((int) tableSearch.getModel().getValueAt(tableSearch.getSelectedRow(), 0)));
        }
    }

    protected void delete() {
        if (tableSearch.getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
        } else if (UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"))) {
            delete((Integer) (tableSearch.getModel().getValueAt(tableSearch.getSelectedRow(), 0)));
        }
        search();
    }

    public void clearAllFields() {
        textFieldSearch.setText("");
    }

    private void setLanguage() {
        setTitle(setLanguage("classform.title"));
        labelSearch.setText(setLanguage("table.search"));
        buttonSave.setText(setLanguage("table.button.add"));
        buttonWrite.setText(setLanguage("table.button.write.excel"));
        buttonUpdate.setText(setLanguage("table.button.update"));
        buttonDelete.setText(setLanguage("table.button.delete"));
    }
}
