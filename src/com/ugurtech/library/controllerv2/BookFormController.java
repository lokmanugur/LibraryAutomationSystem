/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.persistancev2.author.AuthorDaoImpl;
import com.ugurtech.library.persistancev2.booktype.BookTypeDaoImpl;
import com.ugurtech.library.persistancev2.publisher.PublisherDaoImpl;
import com.ugurtech.library.service.author.AuthorService;
import com.ugurtech.library.service.author.AuthorServiceImpl;
import com.ugurtech.library.service.booktype.BookTypeService;
import com.ugurtech.library.service.booktype.BookTypeServiceImpl;
import com.ugurtech.library.service.publisher.PublisherService;
import com.ugurtech.library.service.publisher.PublisherServiceImpl;
import com.ugurtech.library.view.MainForm;
import com.ugurtech.library.view.book.AuthorForm;
import com.ugurtech.library.view.book.BookForm;
import com.ugurtech.library.view.book.BookTypeForm;
import com.ugurtech.library.view.book.PublisherForm;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ugur
 */
public final class BookFormController extends AbstractController {

    private final BookForm bookForm;
    private final PublisherService publisherService = new PublisherServiceImpl(new PublisherDaoImpl());
    private final BookTypeService bookTypeService = new BookTypeServiceImpl(new BookTypeDaoImpl());
    private final AuthorService authorService = new AuthorServiceImpl(new AuthorDaoImpl());

    public BookFormController(BookForm bookForm) {
        this.bookForm = bookForm;
        initView();
        initController();
    }

    @Override
    void initView() {
        AutoCompleteDecorator.decorate(bookForm.getBooksTypeComboBox());
        AutoCompleteDecorator.decorate(bookForm.getAuthorComboBox());
        AutoCompleteDecorator.decorate(bookForm.getPublisherComboBox());
        getAll();
    }

    @Override
    void initController() {

        bookForm.getAuthorComboBox().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                //allAuthors(); method removed
            }
        });

        bookForm.getAuthorButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainForm.getInstance().addDesktopPane(AuthorForm.getInstance());
            }
        });

        bookForm.getAuthorRemoveButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (bookForm.getAuthorList().isSelectionEmpty()) {

                } else {
                    bookForm.getAuthorDefaultModel().remove(bookForm.getAuthorList().getSelectedIndex());
                }
            }
        });

        bookForm.getAuthorAddButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookForm.getAuthorDefaultModel().addElement(bookForm.getAuthorComboBox().getSelectedItem());
            }
        });

        bookForm.getBooksTypeComboBox().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                //booksController.allBooksType(); method removed
            }
        });

        bookForm.getBooksTypeComboBox().getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == 10) {
                    // booksController.addFromBooksTypeComboBoxToBooksTypeList(); method removed
                }
            }
        });

        bookForm.getTypeButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainForm.getInstance().addDesktopPane(BookTypeForm.getInstance());
            }
        });

        bookForm.getBookTypeList().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    evt.consume();
                    // booksController.removeBooksTypeFromBooksTypeList(); method removed
                }
            }
        });

        bookForm.getBooksTypeAddButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookForm.getBookTypeDefaultListModel().addElement(bookForm.getBooksTypeComboBox().getSelectedItem());
            }
        });

        bookForm.getBooksTypeRemoveButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (bookForm.getBookTypeList().isSelectionEmpty()) {

                } else {
                    bookForm.getBookTypeDefaultListModel().remove(bookForm.getBookTypeList().getSelectedIndex());
                }
            }
        });

        bookForm.getPublisherComboBox().addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }

            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                //booksController.allPublisher(); method removed
                getAll();
            }
        });

        bookForm.getPublisherButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainForm.getInstance().addDesktopPane(PublisherForm.getInstance());
            }
        });

        bookForm.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllFields();
                bookForm.dispose();
            }
        });

        bookForm.getButtonSave().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // booksController.addBooks(); method removed
                clearAllFields();
            }
        });
    }

    @Override
    void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void getAll() {
        bookForm.getPublisherComboBox().removeAllItems();
        bookForm.getAuthorComboBox().removeAllItems();
        bookForm.getBooksTypeComboBox().removeAllItems();
        publisherService.getAll().forEach(publisherModel -> bookForm.getPublisherComboBox().addItem(publisherModel));
        authorService.getAll().forEach(authorModel -> bookForm.getAuthorComboBox().addItem(authorModel));
        bookTypeService.getAll().forEach(bookTypeModel -> bookForm.getBooksTypeComboBox().addItem(bookTypeModel));
    }

    @Override
    void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
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
}
