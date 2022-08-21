/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.modelv2.BookModel;
import com.ugurtech.library.modelv2.BookTypeModel;
import com.ugurtech.library.modelv2.CurrentUserModel;
import com.ugurtech.library.modelv2.PublisherModel;
import com.ugurtech.library.persistancev2.author.AuthorDaoImpl;
import com.ugurtech.library.persistancev2.book.BookDaoImpl;
import com.ugurtech.library.persistancev2.booktype.BookTypeDaoImpl;
import com.ugurtech.library.persistancev2.publisher.PublisherDaoImpl;
import com.ugurtech.library.service.author.AuthorService;
import com.ugurtech.library.service.author.AuthorServiceImpl;
import com.ugurtech.library.service.book.BookService;
import com.ugurtech.library.service.book.BookServiceImpl;
import com.ugurtech.library.service.booktype.BookTypeService;
import com.ugurtech.library.service.booktype.BookTypeServiceImpl;
import com.ugurtech.library.service.publisher.PublisherService;
import com.ugurtech.library.service.publisher.PublisherServiceImpl;
import com.ugurtech.library.view.MainForm;
import com.ugurtech.library.view.author.AuthorForm;
import com.ugurtech.library.view.book.BookForm;
import com.ugurtech.library.view.booktype.BookTypeForm;
import com.ugurtech.library.view.publisher.PublisherForm;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ugur
 */
public final class BookController extends AbstractController {

    private final BookForm bookForm;
    private BookModel bookModel;
    private final PublisherService publisherService = new PublisherServiceImpl(new PublisherDaoImpl());
    private final BookTypeService bookTypeService = new BookTypeServiceImpl(new BookTypeDaoImpl());
    private final AuthorService authorService = new AuthorServiceImpl(new AuthorDaoImpl());
    private final BookService bookService = new BookServiceImpl(new BookDaoImpl());
    private int layerPaneCount = 1;

    public BookController(BookForm bookForm) {
        this.bookForm = bookForm;
        initView();
        initController();
    }

    @Override
    void initView() {
        AutoCompleteDecorator.decorate(bookForm.getBooksTypeComboBox());
        AutoCompleteDecorator.decorate(bookForm.getAuthorComboBox());
        AutoCompleteDecorator.decorate(bookForm.getPublisherComboBox());
        setLanguage();
        layerPane(layerPaneCount);
    }

    @Override
    void initController() {

        bookForm.getAuthorComboBox().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                getAllAuthor();
            }
        });

        bookForm.getAuthorButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.getInstance().addDesktopPane(AuthorForm.getInstance());
        });

        bookForm.getAuthorRemoveButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            removeItemFromAuthorList();
        });

        bookForm.getAuthorAddButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            addItemToAuthorList();
        });

        bookForm.getBooksTypeComboBox().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                getAllBookType();
            }
        });

        bookForm.getBooksTypeComboBox().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {
                    addItmeToBookTypeList();
                }
            }
        });
        bookForm.getAuthorComboBox().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {
                    addItemToAuthorList();
                }
            }
        });

        bookForm.getTypeButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.getInstance().addDesktopPane(BookTypeForm.getInstance());
        });

        bookForm.getBookTypeList().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    evt.consume();
                    removeItemFromBookTypeList();
                }
            }

        });
        bookForm.getAuthorList().addMouseListener(new java.awt.event.MouseAdapter() {
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
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                //booksController.allPublisher(); method removed
                getAllPublisher();
            }
        });

        bookForm.getPublisherButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            MainForm.getInstance().addDesktopPane(PublisherForm.getInstance());
        });

        bookForm.getButtonCancel().addActionListener((java.awt.event.ActionEvent evt) -> {
            if (bookForm.getButtonCancel().getText().equals("İptal Et")) {
                clearAllFields();
                bookForm.dispose();
                layerPaneCount = 1;
            } else {
                layerPane(--layerPaneCount);
            }
        });

        bookForm.getButtonSave().addActionListener((java.awt.event.ActionEvent evt) -> {
            if (bookForm.getButtonSave().getText().equals("Kaydet")) {
                add();
                clearAllFields();
                layerPaneCount = 1;
            } else {
                layerPane(++layerPaneCount);
            }

        });
    }


    @Override
    void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getAllPublisher() {
        bookForm.getPublisherComboBox().removeAllItems();
        publisherService.getAll().forEach(publisherModel -> bookForm.getPublisherComboBox().addItem(publisherModel));
    }

    void getAllAuthor() {
        bookForm.getAuthorComboBox().removeAllItems();
        authorService.getAll().forEach(authorModel -> bookForm.getAuthorComboBox().addItem(authorModel));
    }

    void getAllBookType() {
        bookForm.getBooksTypeComboBox().removeAllItems();
        bookTypeService.getAll().forEach(bookTypeModel -> bookForm.getBooksTypeComboBox().addItem(bookTypeModel));
    }

    @Override
    void add() {
        this.bookModel = new BookModel();
        List<AuthorModel> authorList = new ArrayList<>();
        List<BookTypeModel> bookTypeList = new ArrayList<>();
        bookModel.setIsbn(Long.parseLong(bookForm.getIsbnTextField().getText()));
        bookModel.setSysuserId(CurrentUserModel.INSTANCE.getSysUserId());
        bookModel.setBookName(bookForm.getBookNameTextField().getText());
        bookModel.setPressDate(bookForm.getPressDateChooser().getDate() == null ? null : bookForm.getPressDateChooser().getDate().getTime());
        bookModel.setQuantity(Integer.valueOf(bookForm.getBookCountTextField().getText()));
        bookModel.setShelf(bookForm.getTextFieldBookShelf().getText());

        for (int i = 0; i < bookForm.getBookTypeDefaultListModel().getSize(); i++) {
            bookTypeList.add((BookTypeModel) bookForm.getBookTypeDefaultListModel().getElementAt(i));
        }

        for (int i = 0; i < bookForm.getAuthorDefaultListModel().getSize(); i++) {
            authorList.add((AuthorModel) bookForm.getAuthorDefaultListModel().getElementAt(i));
        }

        bookModel.setBooksType(bookTypeList);
        bookModel.setAuthor(authorList);
        bookModel.setBublisherModel((PublisherModel) bookForm.getPublisherComboBox().getSelectedItem());
        this.bookService.add(bookModel);
        clearAllFields();
    }

    @Override
    void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

    @Override
    void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

    public void clearAllFields() {
        bookForm.getAuthorComboBox().removeAllItems();
        bookForm.getBookTypeList().removeAll();
        bookForm.getBookNameTextField().setText(null);
        bookForm.getAuthorList().removeAll();
        bookForm.getBooksTypeComboBox().removeAllItems();
        bookForm.getIsbnTextField().setText(null);
        bookForm.getPressDateChooser().setDate(null);
        bookForm.getPublisherComboBox().removeAllItems();
    }

    private void setLanguage() {

        bookForm.getPanelBook().setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Book Details"));
        bookForm.getPanelBookType().setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Kitap Türleri"));
        bookForm.getPanelAuthor().setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Kitap Yazarları"));
    }

    private void layerPane(int count) {
        switch (countPane(count)) {
            case 1:
                bookForm.getPanelBook().setVisible(true);
                bookForm.getPanelAuthor().setVisible(false);
                bookForm.getPanelBookType().setVisible(false);
                bookForm.getButtonSave().setText("Next");
                bookForm.getButtonCancel().setText("İptal Et");
                break;
            case 2:
                bookForm.getPanelBook().setVisible(false);
                bookForm.getPanelAuthor().setVisible(true);
                bookForm.getPanelBookType().setVisible(false);
                bookForm.getButtonSave().setText("Next");
                bookForm.getButtonCancel().setText("Back");
                break;
            case 3:
                bookForm.getPanelBook().setVisible(false);
                bookForm.getPanelAuthor().setVisible(false);
                bookForm.getPanelBookType().setVisible(true);
                bookForm.getButtonSave().setText("Kaydet");
                bookForm.getButtonCancel().setText("Back");
                break;
            default:
                bookForm.getPanelBook().setVisible(true);
                bookForm.getPanelAuthor().setVisible(false);
                bookForm.getPanelBookType().setVisible(false);
                bookForm.getButtonSave().setText("Next");
                bookForm.getButtonCancel().setText("İptal Et");
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
}
