package com.ugurtech.library.aa_presentation.view.borrowbook;

import com.ugurtech.library.ab_application.af_lib.writetofile.TableToExcelImpl;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import com.ugurtech.library.controller.BorrowedBookTableController;
import com.ugurtech.library.aa_presentation.view.MainForm;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author lokman uğur
 * 
 */
public final class BookBorrowedDetailForm extends JInternalFrame {

    private static BookBorrowedDetailForm borrowedBookTable;
    private final BorrowedBookTableController borrowedBookTableController;
    
    private BookBorrowedDetailForm() {
        initComponents();
        borrowedBookTableController = new BorrowedBookTableController(this);
        setLocation(getWidth()/10,getHeight()/10);
    }

    public static BookBorrowedDetailForm getInstance(){
        if(borrowedBookTable==null)
            return borrowedBookTable=new BookBorrowedDetailForm();
        else
            return borrowedBookTable;
    }

 /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();
        searchComboBox = new javax.swing.JComboBox<>();
        writeFilePanel = new javax.swing.JPanel();
        writeFileButton = new javax.swing.JButton();
        booksScrollPane = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        borrowButton = new javax.swing.JButton();
        retunButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ödünç Verilen Kitaplar Tablosu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ara", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        searchLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        searchLabel.setText("Ara:");
        searchLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ödünç Alınmış Bütün Kitaplar", "İade Edilen Kitaplar", "Okuyucuda Bulunan Kitaplar", "İade Zamanı Aşan Kitaplar" }));
        searchComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(searchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(searchComboBox, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        writeFilePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Çıktı", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        writeFileButton.setText("Exelle Yaz");
        writeFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout writeFilePanelLayout = new javax.swing.GroupLayout(writeFilePanel);
        writeFilePanel.setLayout(writeFilePanelLayout);
        writeFilePanelLayout.setHorizontalGroup(
            writeFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writeFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(writeFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );
        writeFilePanelLayout.setVerticalGroup(
            writeFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(writeFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(writeFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        booksScrollPane.setViewportView(booksTable);

        borrowButton.setText("Ödünç Ver");
        borrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowButtonActionPerformed(evt);
            }
        });

        retunButton.setText("Kitap İade");
        retunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retunButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(696, Short.MAX_VALUE)
                .addComponent(retunButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrowButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retunButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(borrowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filler3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(writeFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(booksScrollPane)
            .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(writeFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(booksScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleName("Menu Hareket");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void writeFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeFileButtonActionPerformed
      new TableToExcelImpl(booksTable, getSearchComboBox().getSelectedItem().toString()).writeToTable();
    }//GEN-LAST:event_writeFileButtonActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        getAllBorrowedBooks();
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void searchComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchComboBoxItemStateChanged
        getAllBorrowedBooks();
    }//GEN-LAST:event_searchComboBoxItemStateChanged

    private void retunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retunButtonActionPerformed
        
        MainForm.getInstance().addDesktopPane(FinishBorrowedBookForm.getInstance());
        
    }//GEN-LAST:event_retunButtonActionPerformed

    private void borrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowButtonActionPerformed
        MainForm.getInstance().addDesktopPane(StartBorrowBookForm.getInstance());
    }//GEN-LAST:event_borrowButtonActionPerformed

    public void getAllBorrowedBooks(){
        borrowedBookTableController.fillAllBorrowedBooks();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane booksScrollPane;
    private javax.swing.JTable booksTable;
    private javax.swing.JButton borrowButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton retunButton;
    private javax.swing.JComboBox<String> searchComboBox;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton writeFileButton;
    private javax.swing.JPanel writeFilePanel;
    // End of variables declaration//GEN-END:variables

    public static BookBorrowedDetailForm getBorrowedBookTable() {
        return borrowedBookTable;
    }

    public static void setBorrowedBookTable(BookBorrowedDetailForm borrowedBookTable) {
        BookBorrowedDetailForm.borrowedBookTable = borrowedBookTable;
    }

    public JTable getBooksTable() {
        return booksTable;
    }

    public void setBooksTable(JTable booksTable) {
        this.booksTable = booksTable;
    }

    public JButton getBorrowButton() {
        return borrowButton;
    }

    public void setBorrowButton(JButton borrowButton) {
        this.borrowButton = borrowButton;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(JPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }

    public JButton getRetunButton() {
        return retunButton;
    }

    public void setRetunButton(JButton retunButton) {
        this.retunButton = retunButton;
    }

    public JComboBox<String> getSearchComboBox() {
        return searchComboBox;
    }

    public void setSearchComboBox(JComboBox<String> searchComboBox) {
        this.searchComboBox = searchComboBox;
    }

    public JLabel getSearchLabel() {
        return searchLabel;
    }

    public void setSearchLabel(JLabel searchLabel) {
        this.searchLabel = searchLabel;
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public void setSearchPanel(JPanel searchPanel) {
        this.searchPanel = searchPanel;
    }

    public JTextField getSearchTextField() {
        return searchTextField;
    }

    public void setSearchTextField(JTextField searchTextField) {
        this.searchTextField = searchTextField;
    }

    public JButton getWriteFileButton() {
        return writeFileButton;
    }

    public void setWriteFileButton(JButton writeFileButton) {
        this.writeFileButton = writeFileButton;
    }

    public JPanel getWriteFilePanel() {
        return writeFilePanel;
    }

    public void setWriteFilePanel(JPanel writeFilePanel) {
        this.writeFilePanel = writeFilePanel;
    }

}