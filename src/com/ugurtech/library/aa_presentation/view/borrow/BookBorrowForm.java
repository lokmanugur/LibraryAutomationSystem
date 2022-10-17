package com.ugurtech.library.aa_presentation.view.borrow;

import com.toedter.calendar.JDateChooser;
import com.ugurtech.library.aa_presentation.controller.borrow.BookBorrowController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
/**
 *
 * @author lokman uğur
 * 
 */
public final class BookBorrowForm extends JInternalFrame {

    public static BookBorrowForm INSTANCE = new BookBorrowForm();
    private final BookBorrowController bookBorrowController;
    
    private BookBorrowForm() {
        initComponents();
        bookBorrowController = new BookBorrowController(this);
        setLocation(getWidth()/10,getHeight()/10);
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
        tableBooks = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        dateChooserFirst = new com.toedter.calendar.JDateChooser();
        dateChooserLast = new com.toedter.calendar.JDateChooser();
        comboBoxDate = new javax.swing.JComboBox<>();
        labelColumn = new javax.swing.JLabel();
        labelStart = new javax.swing.JLabel();
        labelEnd = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelSearch = new javax.swing.JLabel();
        textFieldSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        buttonReturn = new javax.swing.JButton();
        comboBoxOptions = new javax.swing.JComboBox<>();
        buttonWrite = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Books Detail Table");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tableBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableBooks);

        labelColumn.setText("Column");

        labelStart.setText("Start Date");

        labelEnd.setText("End Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelColumn)
                .addGap(5, 5, 5)
                .addComponent(comboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(labelStart)
                .addGap(3, 3, 3)
                .addComponent(dateChooserFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(labelEnd)
                .addGap(0, 0, 0)
                .addComponent(dateChooserLast, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelStart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooserLast, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelSearch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSearch.setText("Search");
        labelSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        buttonSearch.setText("Search");

        buttonReturn.setText("Return Book");

        comboBoxOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ödünç Alınmış Bütün Kitaplar", "İade Edilen Kitaplar", "Okuyucuda Bulunan Kitaplar", "İade Zamanı Aşan Kitaplar" }));

        buttonWrite.setText("Write Excel");
        buttonWrite.setMaximumSize(new java.awt.Dimension(240, 105));
        buttonWrite.setPreferredSize(new java.awt.Dimension(100, 35));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSearch)
                .addGap(30, 30, 30)
                .addComponent(comboBoxOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonWrite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonWrite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Menu Hareket");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonReturn;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonWrite;
    private javax.swing.JComboBox<String> comboBoxDate;
    private javax.swing.JComboBox<String> comboBoxOptions;
    private com.toedter.calendar.JDateChooser dateChooserFirst;
    private com.toedter.calendar.JDateChooser dateChooserLast;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelColumn;
    private javax.swing.JLabel labelEnd;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JLabel labelStart;
    private javax.swing.JTable tableBooks;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables

    public JButton getButtonSearch() {
        return buttonSearch;
    }

    public void setButtonSearch(JButton buttonSearch) {
        this.buttonSearch = buttonSearch;
    }

    public JButton getButtonWrite() {
        return buttonWrite;
    }

    public void setButtonWrite(JButton buttonWrite) {
        this.buttonWrite = buttonWrite;
    }

    public JComboBox<String> getComboBoxDate() {
        return comboBoxDate;
    }

    public void setComboBoxDate(JComboBox<String> comboBoxDate) {
        this.comboBoxDate = comboBoxDate;
    }

    public JDateChooser getDateChooserFirst() {
        return dateChooserFirst;
    }

    public void setDateChooserFirst(JDateChooser dateChooserFirst) {
        this.dateChooserFirst = dateChooserFirst;
    }

    public JDateChooser getDateChooserLast() {
        return dateChooserLast;
    }

    public void setDateChooserLast(JDateChooser dateChooserLast) {
        this.dateChooserLast = dateChooserLast;
    }

    public JLabel getLabelColumn() {
        return labelColumn;
    }

    public void setLabelColumn(JLabel labelColumn) {
        this.labelColumn = labelColumn;
    }

    public JLabel getLabelEnd() {
        return labelEnd;
    }

    public void setLabelEnd(JLabel labelEnd) {
        this.labelEnd = labelEnd;
    }

    public JLabel getLabelSearch() {
        return labelSearch;
    }

    public void setLabelSearch(JLabel labelSearch) {
        this.labelSearch = labelSearch;
    }

    public JLabel getLabelStart() {
        return labelStart;
    }

    public void setLabelStart(JLabel labelStart) {
        this.labelStart = labelStart;
    }

    public JTable getTableBooks() {
        return tableBooks;
    }

    public void setTableBooks(JTable tableBooks) {
        this.tableBooks = tableBooks;
    }

    public JTextField getTextFieldSearch() {
        return textFieldSearch;
    }

    public void setTextFieldSearch(JTextField textFieldSearch) {
        this.textFieldSearch = textFieldSearch;
    }

    public BookBorrowController getBookBorrowController() {
        return bookBorrowController;
    }

    public JButton getButtonReturn() {
        return buttonReturn;
    }

    public void setButtonReturn(JButton buttonReturn) {
        this.buttonReturn = buttonReturn;
    }

    public JComboBox<String> getComboBoxOptions() {
        return comboBoxOptions;
    }

    public void setComboBoxOptions(JComboBox<String> comboBoxOptions) {
        this.comboBoxOptions = comboBoxOptions;
    }
    
}
