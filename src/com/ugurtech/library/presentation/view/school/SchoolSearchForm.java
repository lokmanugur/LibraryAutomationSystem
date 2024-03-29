package com.ugurtech.library.presentation.view.school;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.controller.school.SchoolController;
import com.ugurtech.library.presentation.view.main.MainForm;

public final class SchoolSearchForm extends SchoolController implements Initialize {

    public static SchoolSearchForm INSTANCE = new SchoolSearchForm();
    
    private SchoolSearchForm(){
        initComponents();
        initView();
        initController();
        setLocation(getWidth()/5,getHeight()/10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneTable = new javax.swing.JScrollPane();
        tableSchool = new javax.swing.JTable();
        panelProperties = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        buttonAdd = new javax.swing.JButton();
        textFieldSearch = new javax.swing.JTextField();
        buttonDelete = new javax.swing.JButton();
        labelSearch = new javax.swing.JLabel();
        buttonWrite = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Okul Bilgileri Tablosu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tableSchool.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }

        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    scrollPaneTable.setViewportView(tableSchool);

    searchPanel.setBorder(null);

    buttonAdd.setText("Add");
    buttonAdd.setPreferredSize(new java.awt.Dimension(80, 35));

    textFieldSearch.setPreferredSize(new java.awt.Dimension(250, 35));

    buttonDelete.setText("Delete");
    buttonDelete.setPreferredSize(new java.awt.Dimension(80, 35));

    labelSearch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    labelSearch.setText("Search");
    labelSearch.setPreferredSize(new java.awt.Dimension(80, 18));

    buttonWrite.setText("WriteExcel");

    buttonUpdate.setText("Update");
    buttonUpdate.setPreferredSize(new java.awt.Dimension(80, 35));

    javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
    searchPanel.setLayout(searchPanelLayout);
    searchPanelLayout.setHorizontalGroup(
        searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(searchPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(textFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(43, 43, 43)
            .addComponent(buttonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonWrite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    searchPanelLayout.setVerticalGroup(
        searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(searchPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout panelPropertiesLayout = new javax.swing.GroupLayout(panelProperties);
    panelProperties.setLayout(panelPropertiesLayout);
    panelPropertiesLayout.setHorizontalGroup(
        panelPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelPropertiesLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    panelPropertiesLayout.setVerticalGroup(
        panelPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelPropertiesLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
    );

    getAccessibleContext().setAccessibleName("Okul Bilgileri");

    pack();
    }// </editor-fold>//GEN-END:initComponents
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton buttonWrite;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JPanel panelProperties;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTable tableSchool;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initView() {
        setLanguage();
        search();
    }

    @Override
    public void initController() {

        textFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

        buttonAdd.addActionListener((java.awt.event.ActionEvent evt) -> {
            add();
        });

        buttonUpdate.addActionListener((java.awt.event.ActionEvent evt) -> {
            update();
        });

        buttonDelete.addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
        });

        buttonWrite.addActionListener((java.awt.event.ActionEvent evt) -> {
            writeExel();
        });

    }

    public void search() {
        tableSchool.setModel(search(textFieldSearch.getText()));
    }

    private void add() {
        MainForm.INSTANCE.addDesktopPane(SchoolForm.INSTANCE);
    }

    private void update() {
        if (updateUnSelectRowMessage(tableSchool.getSelectedRow())) {
            SchoolForm schoolForm = SchoolForm.INSTANCE;
            MainForm.INSTANCE.addDesktopPane(schoolForm);
            schoolForm.modelToForm(get((int) tableSchool.getModel().getValueAt(tableSchool.getSelectedRow(), 0)));
        }
    }

    private void delete() {
        if (deleteApproveMessage(tableSchool.getSelectedRow())) {
            delete((int) tableSchool.getModel().getValueAt(tableSchool.getSelectedRow(), 0));
        }
        search();
    }

    private void writeExel() {
        write(tableSchool, getTitle());
    }

    private void setLanguage() {
        setTitle(setLanguage("schoolsearchform.title"));
        labelSearch.setText(setLanguage("table.search"));
        buttonAdd.setText(setLanguage("table.button.add"));
        buttonUpdate.setText(setLanguage("table.button.update"));
        buttonDelete.setText(setLanguage("table.button.delete"));
        buttonWrite.setText(setLanguage("table.button.write.excel"));
    }

}