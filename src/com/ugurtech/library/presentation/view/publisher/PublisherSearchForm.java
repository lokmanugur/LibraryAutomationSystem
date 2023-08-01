/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.view.publisher;

import resources.lib.validation.UserInfoMessages;
import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.controller.publisher.PublisherController;
import com.ugurtech.library.presentation.view.main.MainForm;
/**
 *
 * @author Administrator
 * 
 */
public final class PublisherSearchForm extends PublisherController implements Initialize {

    public static PublisherSearchForm INSTANCE = new PublisherSearchForm();

    private PublisherSearchForm() {
      initComponents();
      initView();
      initController();
      setLocation(getWidth()/2,getHeight()/10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPublisher = new javax.swing.JPanel();
        buttonAdd = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonWrite = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        labelSearch = new javax.swing.JLabel();
        textFieldSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePublisher = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Publisher Details Table");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName(""); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        panelPublisher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelPublisher.setToolTipText(""); // NOI18N

        buttonAdd.setText("Add");
        buttonAdd.setPreferredSize(new java.awt.Dimension(80, 35));

        buttonUpdate.setText("Update");
        buttonUpdate.setPreferredSize(new java.awt.Dimension(80, 35));

        buttonWrite.setText("WriteExcel");
        buttonWrite.setPreferredSize(new java.awt.Dimension(80, 35));

        buttonDelete.setText("Delete");
        buttonDelete.setPreferredSize(new java.awt.Dimension(80, 35));

        labelSearch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSearch.setText("Search");

        javax.swing.GroupLayout panelPublisherLayout = new javax.swing.GroupLayout(panelPublisher);
        panelPublisher.setLayout(panelPublisherLayout);
        panelPublisherLayout.setHorizontalGroup(
            panelPublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPublisherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(buttonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonWrite, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPublisherLayout.setVerticalGroup(
            panelPublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPublisherLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonWrite, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablePublisher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablePublisher.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablePublisher);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton buttonWrite;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JPanel panelPublisher;
    private javax.swing.JTable tablePublisher;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables

       public void search() {
        tablePublisher.setModel(search(textFieldSearch.getText()));
    }

    @Override
    public final void initView() {
        setLanguage();
        search();
    }

    @Override
    public final void initController() {
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
            //write to excel
        });

        textFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

    }

    protected void add() {
       MainForm.INSTANCE.addDesktopPane(PublisherForm.INSTANCE); 
    }

    private void delete() {
        if (tablePublisher.getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.delete.unselectedrow"));
        } else if (UserInfoMessages.getInstance().showApproveMessages(setLanguage("table.option.approve"), setLanguage("table.option.approve.form.title"))) {
            delete((Integer)(tablePublisher.getModel().getValueAt(tablePublisher.getSelectedRow(), 0)));

        }
        search();
    }

    private void update() {
        if (tablePublisher.getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages(setLanguage("table.update.unselectedrow"));
        } else {
            PublisherForm publisherForm = PublisherForm.INSTANCE;
            MainForm.INSTANCE.addDesktopPane(publisherForm);
            publisherForm.modelToForm(get((int) tablePublisher.getModel().getValueAt(tablePublisher.getSelectedRow(), 0)));
        }

    }

    public void clearAllField() {
        textFieldSearch.setText(null);
        search();
    }

    private void setLanguage() {
        setTitle(setLanguage("publisherform.title"));
        labelSearch.setText(setLanguage("table.search"));
        buttonAdd.setText(setLanguage("table.button.add"));
        buttonUpdate.setText(setLanguage("table.button.update"));
        buttonDelete.setText(setLanguage("table.button.delete"));
        buttonWrite.setText(setLanguage("table.button.write.excel"));
    }
}
