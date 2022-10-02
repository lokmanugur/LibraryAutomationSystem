/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.view.book;

import com.toedter.calendar.JDateChooser;
import com.ugurtech.library.aa_presentation.controller.book.BookFormController;
import com.ugurtech.library.ad_model.AuthorModel;
import com.ugurtech.library.ad_model.BookModel;
import com.ugurtech.library.ad_model.BookTypeModel;
import com.ugurtech.library.ad_model.PublisherModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author ugur
 *
 */
public final class BookForm extends JInternalFrame {

    private static BookForm bookForm;
    private final BookFormController bookFormController;
    private DefaultListModel bookTypeDefaultListModel;
    private DefaultListModel authorDefaultListModel;
    private BookModel bookModel;

    private BookForm() {
        initComponents();
        bookFormController = new BookFormController(this);
        bookTypeDefaultListModel = new DefaultListModel();
        authorDefaultListModel = new DefaultListModel();
        bookTypeList.setModel(bookTypeDefaultListModel);
        authorList.setModel(authorDefaultListModel);
        setLocation(getWidth() / 2, getHeight() / 100);
    }

    public static BookForm getInstance() {
        if (bookForm == null) {
            return bookForm = new BookForm();
        } else {
            return bookForm;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        panelButtons = new javax.swing.JPanel();
        buttonSave = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        layeredPaneBook = new javax.swing.JLayeredPane();
        panelAuthor = new javax.swing.JPanel();
        scrollPaneAuthor = new javax.swing.JScrollPane();
        authorList = new javax.swing.JList<>();
        labelAuthorList = new javax.swing.JLabel();
        labelSelectAuthor = new javax.swing.JLabel();
        authorComboBox = new javax.swing.JComboBox<>();
        authorButton = new javax.swing.JButton();
        authorRemoveButton = new javax.swing.JButton();
        authorAddButton = new javax.swing.JButton();
        panelBookType = new javax.swing.JPanel();
        booksTypeComboBox = new javax.swing.JComboBox<>();
        labelSelectBookType = new javax.swing.JLabel();
        typeButton = new javax.swing.JButton();
        scrollPaneBookType = new javax.swing.JScrollPane();
        bookTypeList = new javax.swing.JList<>();
        labelBookTypeList = new javax.swing.JLabel();
        booksTypeAddButton = new javax.swing.JButton();
        booksTypeRemoveButton = new javax.swing.JButton();
        panelBook = new javax.swing.JPanel();
        labelIsbn = new javax.swing.JLabel();
        labelBookName = new javax.swing.JLabel();
        bookNameTextField = new javax.swing.JTextField();
        publisherComboBox = new javax.swing.JComboBox<>();
        labelPublisher = new javax.swing.JLabel();
        labelPressDate = new javax.swing.JLabel();
        publisherButton = new javax.swing.JButton();
        labelBookQuantity = new javax.swing.JLabel();
        pressDateChooser = new JDateChooser();
        textFieldBookShelf = new javax.swing.JTextField();
        labelBookShelf = new javax.swing.JLabel();
        textFieldIsbn = new javax.swing.JFormattedTextField();
        textFieldBookCount = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Kitap Kayıt Formu");
        setMinimumSize(new java.awt.Dimension(100, 100));

        mainPanel.setMinimumSize(new java.awt.Dimension(100, 100));

        panelButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelButtons.setPreferredSize(new java.awt.Dimension(470, 42));

        buttonSave.setText("Kaydet");

        buttonCancel.setText("İptal Et");

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonsLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layeredPaneBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        layeredPaneBook.setPreferredSize(new java.awt.Dimension(480, 270));

        panelAuthor.setBorder(null);

        scrollPaneAuthor.setViewportView(authorList);

        labelAuthorList.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAuthorList.setText("Yazarlar:");

        labelSelectAuthor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSelectAuthor.setText("Yazar Ekle:");

        authorComboBox.setEditable(true);

        authorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/poem.png"))); // NOI18N

        authorRemoveButton.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        authorRemoveButton.setText("-");
        authorRemoveButton.setPreferredSize(new java.awt.Dimension(40, 40));

        authorAddButton.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        authorAddButton.setText("+");

        javax.swing.GroupLayout panelAuthorLayout = new javax.swing.GroupLayout(panelAuthor);
        panelAuthor.setLayout(panelAuthorLayout);
        panelAuthorLayout.setHorizontalGroup(
            panelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAuthorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAuthorList, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSelectAuthor, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorRemoveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorAddButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelAuthorLayout.setVerticalGroup(
            panelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAuthorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelAuthorLayout.createSequentialGroup()
                        .addComponent(authorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(authorRemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPaneAuthor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAuthorList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelSelectAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(authorAddButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBookType.setBorder(null);

        booksTypeComboBox.setEditable(true);

        labelSelectBookType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSelectBookType.setText("Kitap Türü Ekle:");

        typeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/separation.png"))); // NOI18N

        scrollPaneBookType.setViewportView(bookTypeList);

        labelBookTypeList.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelBookTypeList.setText("Kitap Türü:");

        booksTypeAddButton.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        booksTypeAddButton.setText("+");

        booksTypeRemoveButton.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        booksTypeRemoveButton.setText("-");

        javax.swing.GroupLayout panelBookTypeLayout = new javax.swing.GroupLayout(panelBookType);
        panelBookType.setLayout(panelBookTypeLayout);
        panelBookTypeLayout.setHorizontalGroup(
            panelBookTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookTypeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBookTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelSelectBookType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelBookTypeList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBookTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneBookType, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(booksTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBookTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(booksTypeAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(booksTypeRemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelBookTypeLayout.setVerticalGroup(
            panelBookTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBookTypeLayout.createSequentialGroup()
                        .addComponent(typeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(booksTypeRemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPaneBookType, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBookTypeList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBookTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(booksTypeAddButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(booksTypeComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSelectBookType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBook.setBorder(null);
        panelBook.setVerifyInputWhenFocusTarget(false);

        labelIsbn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelIsbn.setText("ISBN:");

        labelBookName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelBookName.setText("Kitap Adı:");

        publisherComboBox.setEditable(true);

        labelPublisher.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPublisher.setText("Yayın Evi:");

        labelPressDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPressDate.setText("Basım Tarihi:");

        publisherButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/advertisement.png"))); // NOI18N

        labelBookQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelBookQuantity.setText("Sayı:");

        labelBookShelf.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelBookShelf.setText("Book Shelf:");

        textFieldIsbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));

        textFieldBookCount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout panelBookLayout = new javax.swing.GroupLayout(panelBook);
        panelBook.setLayout(panelBookLayout);
        panelBookLayout.setHorizontalGroup(
            panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelBookName)
                    .addComponent(labelIsbn)
                    .addComponent(labelPublisher)
                    .addComponent(labelPressDate)
                    .addComponent(labelBookQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBookLayout.createSequentialGroup()
                        .addComponent(textFieldBookCount, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelBookShelf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldBookShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pressDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBookLayout.createSequentialGroup()
                        .addComponent(publisherComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(publisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bookNameTextField)
                    .addComponent(textFieldIsbn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBookLayout.setVerticalGroup(
            panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publisherComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pressDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPressDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelBookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldBookCount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldBookShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelBookShelf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        layeredPaneBook.setLayer(panelAuthor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPaneBook.setLayer(panelBookType, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPaneBook.setLayer(panelBook, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredPaneBookLayout = new javax.swing.GroupLayout(layeredPaneBook);
        layeredPaneBook.setLayout(layeredPaneBookLayout);
        layeredPaneBookLayout.setHorizontalGroup(
            layeredPaneBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layeredPaneBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredPaneBookLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layeredPaneBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredPaneBookLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelBookType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layeredPaneBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredPaneBookLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layeredPaneBookLayout.setVerticalGroup(
            layeredPaneBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
            .addGroup(layeredPaneBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredPaneBookLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layeredPaneBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredPaneBookLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelBookType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layeredPaneBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layeredPaneBookLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(layeredPaneBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(layeredPaneBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        getAccessibleContext().setAccessibleName("Book Save Form");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authorAddButton;
    private javax.swing.JButton authorButton;
    private javax.swing.JComboBox<AuthorModel> authorComboBox;
    private javax.swing.JList<AuthorModel> authorList;
    private javax.swing.JButton authorRemoveButton;
    private javax.swing.JTextField bookNameTextField;
    private javax.swing.JList<BookTypeModel> bookTypeList;
    private javax.swing.JButton booksTypeAddButton;
    private javax.swing.JComboBox<BookTypeModel> booksTypeComboBox;
    private javax.swing.JButton booksTypeRemoveButton;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel labelAuthorList;
    private javax.swing.JLabel labelBookName;
    private javax.swing.JLabel labelBookQuantity;
    private javax.swing.JLabel labelBookShelf;
    private javax.swing.JLabel labelBookTypeList;
    private javax.swing.JLabel labelIsbn;
    private javax.swing.JLabel labelPressDate;
    private javax.swing.JLabel labelPublisher;
    private javax.swing.JLabel labelSelectAuthor;
    private javax.swing.JLabel labelSelectBookType;
    private javax.swing.JLayeredPane layeredPaneBook;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelAuthor;
    private javax.swing.JPanel panelBook;
    private javax.swing.JPanel panelBookType;
    private javax.swing.JPanel panelButtons;
    private com.toedter.calendar.JDateChooser pressDateChooser;
    private javax.swing.JButton publisherButton;
    private javax.swing.JComboBox<PublisherModel> publisherComboBox;
    private javax.swing.JScrollPane scrollPaneAuthor;
    private javax.swing.JScrollPane scrollPaneBookType;
    private javax.swing.JFormattedTextField textFieldBookCount;
    private javax.swing.JTextField textFieldBookShelf;
    private javax.swing.JFormattedTextField textFieldIsbn;
    private javax.swing.JButton typeButton;
    // End of variables declaration//GEN-END:variables

    public static BookForm getBookForm() {
        return bookForm;
    }

    public static void setBookForm(BookForm bookForm) {
        BookForm.bookForm = bookForm;
    }

    public BookFormController getBookFormController() {
        return bookFormController;
    }

    public BookModel getBookModel() {
        return bookModel;
    }

    public void setBookModel(BookModel bookModel) {
        this.bookModel = bookModel;
    }

    public JButton getAuthorAddButton() {
        return authorAddButton;
    }

    public void setAuthorAddButton(JButton authorAddButton) {
        this.authorAddButton = authorAddButton;
    }

    public JButton getAuthorButton() {
        return authorButton;
    }

    public void setAuthorButton(JButton authorButton) {
        this.authorButton = authorButton;
    }

    public JComboBox<AuthorModel> getAuthorComboBox() {
        return authorComboBox;
    }

    public void setAuthorComboBox(JComboBox<AuthorModel> authorComboBox) {
        this.authorComboBox = authorComboBox;
    }

    public JList<AuthorModel> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(JList<AuthorModel> authorList) {
        this.authorList = authorList;
    }

    public JButton getAuthorRemoveButton() {
        return authorRemoveButton;
    }

    public void setAuthorRemoveButton(JButton authorRemoveButton) {
        this.authorRemoveButton = authorRemoveButton;
    }

    public JFormattedTextField getTextFieldBookCount() {
        return textFieldBookCount;
    }

    public void setTextFieldBookCount(JFormattedTextField textFieldBookCount) {
        this.textFieldBookCount = textFieldBookCount;
    }

    public JTextField getBookNameTextField() {
        return bookNameTextField;
    }

    public void setBookNameTextField(JTextField bookNameTextField) {
        this.bookNameTextField = bookNameTextField;
    }

    public JList<BookTypeModel> getBookTypeList() {
        return bookTypeList;
    }

    public void setBookTypeList(JList<BookTypeModel> bookTypeList) {
        this.bookTypeList = bookTypeList;
    }

    public JButton getBooksTypeAddButton() {
        return booksTypeAddButton;
    }

    public void setBooksTypeAddButton(JButton booksTypeAddButton) {
        this.booksTypeAddButton = booksTypeAddButton;
    }

    public JComboBox<BookTypeModel> getBooksTypeComboBox() {
        return booksTypeComboBox;
    }

    public void setBooksTypeComboBox(JComboBox<BookTypeModel> booksTypeComboBox) {
        this.booksTypeComboBox = booksTypeComboBox;
    }

    public JButton getBooksTypeRemoveButton() {
        return booksTypeRemoveButton;
    }

    public void setBooksTypeRemoveButton(JButton booksTypeRemoveButton) {
        this.booksTypeRemoveButton = booksTypeRemoveButton;
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

    public JFormattedTextField getTextFieldIsbn() {
        return textFieldIsbn;
    }

    public void setTextFieldIsbn(JFormattedTextField textFieldIsbn) {
        this.textFieldIsbn = textFieldIsbn;
    }

    public JLabel getLabelAuthorList() {
        return labelAuthorList;
    }

    public void setLabelAuthorList(JLabel labelAuthorList) {
        this.labelAuthorList = labelAuthorList;
    }

    public JLabel getLabelBookName() {
        return labelBookName;
    }

    public void setLabelBookName(JLabel labelBookName) {
        this.labelBookName = labelBookName;
    }

    public JLabel getLabelBookQuantity() {
        return labelBookQuantity;
    }

    public void setLabelBookQuantity(JLabel labelBookQuantity) {
        this.labelBookQuantity = labelBookQuantity;
    }

    public JLabel getLabelBookTypeList() {
        return labelBookTypeList;
    }

    public void setLabelBookTypeList(JLabel labelBookTypeList) {
        this.labelBookTypeList = labelBookTypeList;
    }

    public JLabel getLabelIsbn() {
        return labelIsbn;
    }

    public void setLabelIsbn(JLabel labelIsbn) {
        this.labelIsbn = labelIsbn;
    }

    public JLabel getLabelPressDate() {
        return labelPressDate;
    }

    public void setLabelPressDate(JLabel labelPressDate) {
        this.labelPressDate = labelPressDate;
    }

    public JLabel getLabelPublisher() {
        return labelPublisher;
    }

    public void setLabelPublisher(JLabel labelPublisher) {
        this.labelPublisher = labelPublisher;
    }

    public JLabel getLabelSelectAuthor() {
        return labelSelectAuthor;
    }

    public void setLabelSelectAuthor(JLabel labelSelectAuthor) {
        this.labelSelectAuthor = labelSelectAuthor;
    }

    public JLabel getLabelSelectBookType() {
        return labelSelectBookType;
    }

    public void setLabelSelectBookType(JLabel labelSelectBookType) {
        this.labelSelectBookType = labelSelectBookType;
    }

    public JPanel getPanelAuthor() {
        return panelAuthor;
    }

    public void setPanelAuthor(JPanel panelAuthor) {
        this.panelAuthor = panelAuthor;
    }

    public JPanel getPanelBook() {
        return panelBook;
    }

    public void setPanelBook(JPanel panelBook) {
        this.panelBook = panelBook;
    }

    public JPanel getPanelBookType() {
        return panelBookType;
    }

    public void setPanelBookType(JPanel panelBookType) {
        this.panelBookType = panelBookType;
    }

    public JPanel getPanelButtons() {
        return panelButtons;
    }

    public void setPanelButtons(JPanel panelButtons) {
        this.panelButtons = panelButtons;
    }

    public JDateChooser getPressDateChooser() {
        return pressDateChooser;
    }

    public void setPressDateChooser(JDateChooser pressDateChooser) {
        this.pressDateChooser = pressDateChooser;
    }

    public JComboBox<PublisherModel> getPublisherComboBox() {
        return publisherComboBox;
    }

    public void setPublisherComboBox(JComboBox<PublisherModel> publisherComboBox) {
        this.publisherComboBox = publisherComboBox;
    }

    public JButton getPublisherButton() {
        return publisherButton;
    }

    public void setPublisherButton(JButton publisherButton) {
        this.publisherButton = publisherButton;
    }

    public JScrollPane getScrollPaneAuthor() {
        return scrollPaneAuthor;
    }

    public void setScrollPaneAuthor(JScrollPane scrollPaneAuthor) {
        this.scrollPaneAuthor = scrollPaneAuthor;
    }

    public JScrollPane getScrollPaneBookType() {
        return scrollPaneBookType;
    }

    public void setScrollPaneBookType(JScrollPane scrollPaneBookType) {
        this.scrollPaneBookType = scrollPaneBookType;
    }

    public JButton getTypeButton() {
        return typeButton;
    }

    public void setTypeButton(JButton typeButton) {
        this.typeButton = typeButton;
    }

    public DefaultListModel getBookTypeDefaultListModel() {
        return bookTypeDefaultListModel;
    }

    public void setBookTypeDefaultListModel(DefaultListModel bookTypeDefaultListModel) {
        this.bookTypeDefaultListModel = bookTypeDefaultListModel;
    }

    public DefaultListModel getAuthorDefaultListModel() {
        return authorDefaultListModel;
    }

    public void setAuthorDefaultListModel(DefaultListModel authorDefaultListModel) {
        this.authorDefaultListModel = authorDefaultListModel;
    }

    public JLabel getLabelBookShelf() {
        return labelBookShelf;
    }

    public void setLabelBookShelf(JLabel labelBookShelf) {
        this.labelBookShelf = labelBookShelf;
    }

    public JLayeredPane getLayeredPaneBook() {
        return layeredPaneBook;
    }

    public void setLayeredPaneBook(JLayeredPane layeredPaneBook) {
        this.layeredPaneBook = layeredPaneBook;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getTextFieldBookShelf() {
        return textFieldBookShelf;
    }

    public void setTextFieldBookShelf(JTextField textFieldBookShelf) {
        this.textFieldBookShelf = textFieldBookShelf;
    }

}
