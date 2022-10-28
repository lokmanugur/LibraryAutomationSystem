/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.book;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.model.BookTypeModel;
import com.ugurtech.library.model.CurrentUserModel;
import com.ugurtech.library.model.PublisherModel;
import com.ugurtech.library.dataaccesslayer.author.AuthorDaoImpl;
import com.ugurtech.library.dataaccesslayer.booktype.BookTypeDaoImpl;
import com.ugurtech.library.dataaccesslayer.publisher.PublisherDaoImpl;
import com.ugurtech.library.application.service.author.AuthorService;
import com.ugurtech.library.application.service.author.AuthorServiceImpl;
import com.ugurtech.library.application.service.booktype.BookTypeService;
import com.ugurtech.library.application.service.booktype.BookTypeServiceImpl;
import com.ugurtech.library.application.service.publisher.PublisherService;
import com.ugurtech.library.application.service.publisher.PublisherServiceImpl;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.author.AuthorForm;
import com.ugurtech.library.presentation.view.book.BookForm;
import com.ugurtech.library.presentation.view.booktype.BookTypeForm;
import com.ugurtech.library.presentation.view.publisher.PublisherForm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ugur
 */
public final class BookFormController extends BookController implements Initialize{

    private final BookForm bookForm;
    private final PublisherService publisherService = new PublisherServiceImpl(new PublisherDaoImpl());
    private final BookTypeService bookTypeService = new BookTypeServiceImpl(new BookTypeDaoImpl());
    private final AuthorService authorService = new AuthorServiceImpl(new AuthorDaoImpl());
    private int layerPaneCount = 1;

    public BookFormController(BookForm bookForm) {
        this.bookForm = bookForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        AutoCompleteDecorator.decorate(bookForm.getBooksTypeComboBox());
        AutoCompleteDecorator.decorate(bookForm.getAuthorComboBox());
        AutoCompleteDecorator.decorate(bookForm.getPublisherComboBox());
        setLanguage();
        layerPane(layerPaneCount);
    }

    @Override
    public void initController() {

        bookForm.getAuthorComboBox().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                getAllAuthor();
            }
        });

        bookForm.getAuthorButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.INSTANCE.addDesktopPane(AuthorForm.getInstance());
        });

        bookForm.getAuthorRemoveButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            removeItemFromAuthorList();
        });

        bookForm.getAuthorAddButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            addItemToAuthorList();
        });

        bookForm.getBooksTypeComboBox().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                getAllBookType();
            }
        });

        bookForm.getBooksTypeComboBox().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {
                    addItmeToBookTypeList();
                }
            }
        });
        bookForm.getAuthorComboBox().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {
                    addItemToAuthorList();
                }
            }
        });

        bookForm.getTypeButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.INSTANCE.addDesktopPane(BookTypeForm.INSTANCE);
        });

        bookForm.getBookTypeList().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    evt.consume();
                    removeItemFromBookTypeList();
                }
            }

        });
        bookForm.getAuthorList().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    evt.consume();
                    removeItemFromAuthorList();
                }
            }

        });

        bookForm.getBooksTypeAddButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            addItmeToBookTypeList();
        });

        bookForm.getBooksTypeRemoveButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            removeItemFromBookTypeList();
        });

        bookForm.getPublisherComboBox().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                
            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                getAllPublisher();
            }
        });

        bookForm.getPublisherButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.INSTANCE.addDesktopPane(PublisherForm.INSTANCE);
        });

        bookForm.getButtonCancel().addActionListener((java.awt.event.ActionEvent evt) -> {
            if (bookForm.getButtonCancel().getText().equals(setLanguage("form.button.cancel"))) {
                layerPaneCount = 1;
                layerPane(layerPaneCount);
                bookForm.setBookModel(null);
                clearAllFields();
                bookForm.dispose();
            } else {
                layerPane(--layerPaneCount);
            }
        });

        bookForm.getButtonSave().addActionListener((java.awt.event.ActionEvent evt) -> {
            if (bookForm.getButtonSave().getText().equals(setLanguage("form.button.save"))) {
                if(bookForm.getBookModel()==null){
                    add();
                }else{
                    update();
                    bookForm.setBookModel(null);
                }
                layerPaneCount = 1;
                layerPane(layerPaneCount);
                clearAllFields();
            } else {
                layerPane(++layerPaneCount);
            }

        });
    }

    public void getAllPublisher() {
        bookForm.getPublisherComboBox().removeAllItems();
        publisherService.getAll().forEach(publisherModel -> bookForm.getPublisherComboBox().addItem(publisherModel));
    }

    public void getAllAuthor() {
        bookForm.getAuthorComboBox().removeAllItems();
        authorService.getAll().forEach(authorModel -> bookForm.getAuthorComboBox().addItem(authorModel));
    }

    public void getAllBookType() {
        bookForm.getBooksTypeComboBox().removeAllItems();
        bookTypeService.getAll().forEach(bookTypeModel -> bookForm.getBooksTypeComboBox().addItem(bookTypeModel));
    }
    
    protected void update(){
        update(formToModel());
    }

    protected void add() {
        add(formToModel());
        clearAllFields();
    }

    public void clearAllFields() {
        bookForm.getAuthorDefaultListModel().removeAllElements();
        bookForm.getBookTypeDefaultListModel().removeAllElements();
        bookForm.getAuthorList().removeAll();
        bookForm.getBookTypeList().removeAll();
        bookForm.getAuthorComboBox().removeAllItems();
        bookForm.getPublisherComboBox().removeAllItems();
        bookForm.getBooksTypeComboBox().removeAllItems();
        bookForm.getBookNameTextField().setText(null);
        bookForm.getTextFieldIsbn().setText(null);
        bookForm.getPressDateChooser().setDate(null);
        bookForm.getTextFieldBookShelf().setText("");
        bookForm.getTextFieldBookCount().setText("");
        bookForm.getTextFieldPageNumber().setText("");
    }
    
    public void clearAll(){
        bookForm.getAuthorList().removeAll();
        bookForm.getBookTypeList().removeAll();
    }

    private void setLanguage() {
        bookForm.setTitle(setLanguage("bookform.title"));
        bookForm.getButtonSave().setText(setLanguage("form.button.save"));
        bookForm.getButtonCancel().setText(setLanguage("form.button.cancel"));
        bookForm.getLabelIsbn().setText(setLanguage("bookform.layeredpanebook.panelbook.labelisbn"));
        bookForm.getLabelBookName().setText(setLanguage("bookform.layeredpanebook.panelbook.labelbookname"));
        bookForm.getLabelPublisher().setText(setLanguage("bookform.layeredpanebook.panelbook.labelpublisher"));
        bookForm.getLabelPressDate().setText(setLanguage("bookform.layeredpanebook.panelbook.labelpressdate"));
        bookForm.getLabelBookQuantity().setText(setLanguage("bookform.layeredpanebook.panelbook.labelbookquantity"));
        bookForm.getLabelBookShelf().setText(setLanguage("bookform.layeredpanebook.panelbook.labelbookshelf"));
        bookForm.getLabelBookPageNumber().setText(setLanguage("bookform.layeredpanebook.panelbook.labelpages"));
        bookForm.getLabelAuthorList().setText(setLanguage("bookform.layeredpanebook.panelauthor.labelauthorlist"));
        bookForm.getLabelSelectAuthor().setText(setLanguage("bookform.layeredpanebook.panelauthor.labelselectauthor"));
        bookForm.getLabelSelectBookType().setText(setLanguage("bookform.layeredpanebook.panelbooktype.labelselectbooktype"));
        bookForm.getLabelBookTypeList().setText(setLanguage("bookform.layeredpanebook.panelbooktype.labelbooktypelist"));
        
        bookForm.getPanelBook().setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Book Details"));
        bookForm.getPanelBookType().setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Book Types"));
        bookForm.getPanelAuthor().setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Book Authors"));
    }

    private void layerPane(int count) {
        switch (countPane(count)) {
            case 1:
                bookForm.getPanelBook().setVisible(true);
                bookForm.getPanelAuthor().setVisible(false);
                bookForm.getPanelBookType().setVisible(false);
                bookForm.getButtonSave().setText(setLanguage("bookform.mainpanel.panelbuttons.next"));
                bookForm.getButtonCancel().setText(setLanguage("form.button.cancel"));
                break;
            case 2:
                bookForm.getPanelBook().setVisible(false);
                bookForm.getPanelAuthor().setVisible(true);
                bookForm.getPanelBookType().setVisible(false);
                bookForm.getButtonSave().setText(setLanguage("bookform.mainpanel.panelbuttons.next"));
                bookForm.getButtonCancel().setText(setLanguage("bookform.mainpanel.panelbuttons.back"));
                break;
            case 3:
                bookForm.getPanelBook().setVisible(false);
                bookForm.getPanelAuthor().setVisible(false);
                bookForm.getPanelBookType().setVisible(true);
                bookForm.getButtonSave().setText(setLanguage("form.button.save"));
                bookForm.getButtonCancel().setText(setLanguage("bookform.mainpanel.panelbuttons.back"));
                break;
            default:
                bookForm.getPanelBook().setVisible(true);
                bookForm.getPanelAuthor().setVisible(false);
                bookForm.getPanelBookType().setVisible(false);
                bookForm.getButtonSave().setText(setLanguage("bookform.mainpanel.panelbuttons.next"));
                bookForm.getButtonCancel().setText(setLanguage("form.button.cancel"));
        }
    }

    private int countPane(int count) {
        if (count > 3 || count < 1) {
            count = 1;
        }
        return count;
    }

    private void addItmeToBookTypeList() {
        bookForm.getBookTypeDefaultListModel().addElement(bookForm.getBooksTypeComboBox().getSelectedItem());
    }

    private void addItemToAuthorList() {
        bookForm.getAuthorDefaultListModel().addElement(bookForm.getAuthorComboBox().getSelectedItem());
    }

    private void removeItemFromAuthorList() {
        if (bookForm.getAuthorList().isSelectionEmpty()) {

        } else {
            bookForm.getAuthorDefaultListModel().remove(bookForm.getAuthorList().getSelectedIndex());
        }
    }
    private void removeItemFromBookTypeList() {
        if (bookForm.getBookTypeList().isSelectionEmpty()) {
            
        } else {
            bookForm.getBookTypeDefaultListModel().remove(bookForm.getBookTypeList().getSelectedIndex());
        }
    }

    void modelToForm() {
        bookForm.getTextFieldIsbn().setText(String.valueOf(bookForm.getBookModel().getIsbn()));
        bookForm.getBookNameTextField().setText(bookForm.getBookModel().getBookName());
        bookForm.getPressDateChooser().setDate(new Date(bookForm.getBookModel().getPressDate()));
        bookForm.getPublisherComboBox().addItem(bookForm.getBookModel().getPublisherModel());
        bookForm.getTextFieldPageNumber().setText(String.valueOf(bookForm.getBookModel().getPageNumbber()));
        bookForm.getTextFieldBookCount().setText(String.valueOf(bookForm.getBookModel().getQuantity()));
        bookForm.getTextFieldBookShelf().setText(bookForm.getBookModel().getShelf());
        bookForm.getBookModel().getBookType().forEach(btm ->bookForm.getBookTypeDefaultListModel().addElement(btm));
        bookForm.getBookModel().getAuthor().forEach(am->bookForm.getAuthorDefaultListModel().addElement(am));
    }
    
    public BookModel formToModel(){
        this.bookModel = new BookModel();
        List<AuthorModel> authorList = new ArrayList<>();
        List<BookTypeModel> bookTypeList = new ArrayList<>();
        bookModel.setBookId(bookForm.getBookModel()==null?0:bookForm.getBookModel().getBookId());
        bookModel.setIsbn(Long.parseLong(bookForm.getTextFieldIsbn().getText()));
        bookModel.setSysuserId(CurrentUserModel.INSTANCE.getSysUserId());
        bookModel.setBookName(bookForm.getBookNameTextField().getText());
        bookModel.setPressDate(bookForm.getPressDateChooser().getDate() == null ? 0 : bookForm.getPressDateChooser().getDate().getTime());
        bookModel.setPageNumbber(Integer.parseInt(bookForm.getTextFieldPageNumber().getText()));
        bookModel.setQuantity(Integer.parseInt(bookForm.getTextFieldBookCount().getText()));
        bookModel.setStock(Integer.parseInt(bookForm.getTextFieldBookCount().getText()));
        bookModel.setShelf(bookForm.getTextFieldBookShelf().getText());

        for (int i = 0; i < bookForm.getBookTypeDefaultListModel().getSize(); i++) {
            bookTypeList.add((BookTypeModel) bookForm.getBookTypeDefaultListModel().getElementAt(i));
        }

        for (int i = 0; i < bookForm.getAuthorDefaultListModel().getSize(); i++) {
            authorList.add((AuthorModel) bookForm.getAuthorDefaultListModel().getElementAt(i));
        }

        bookModel.setBooksType(bookTypeList);
        bookModel.setAuthor(authorList);
        bookModel.setPublisherModel((PublisherModel) bookForm.getPublisherComboBox().getSelectedItem());
        return bookModel;
    }
   
}
