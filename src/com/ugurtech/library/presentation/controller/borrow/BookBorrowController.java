/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.borrow;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.borrow.BookBorrowForm;
import com.ugurtech.library.presentation.view.borrow.FinishBorrowedForm;
import com.ugurtech.library.presentation.view.main.MainForm;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 *
 */
public final class BookBorrowController extends ControllerImpl implements Initialize {

    private final BookBorrowForm bookBorrowForm;

    public BookBorrowController(BookBorrowForm bookBorrowForm) {
        this.bookBorrowForm = bookBorrowForm;

        initView();
        initController();
    }

    @Override
    public void initView() {
        setLanguage();
        search();
    }

    @Override
    public void initController() {
        bookBorrowForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

        bookBorrowForm.getButtonWrite().addActionListener((java.awt.event.ActionEvent evt) -> {
            write();
        });

        bookBorrowForm.getButtonDelete().addActionListener((java.awt.event.ActionEvent evt) -> {
            delete();
        });

        bookBorrowForm.getButtonSearch().addActionListener((java.awt.event.ActionEvent evt) -> {
            search();
        });

        bookBorrowForm.getButtonReturn().addActionListener((e) -> {
            FinishBorrowedForm finishBorrowedForm = FinishBorrowedForm.INSTANCE;
            MainForm.getInstance().addDesktopPane(finishBorrowedForm);
            finishBorrowedForm.getPersonBook((int) bookBorrowForm.getTableBooks().getValueAt(bookBorrowForm.getTableBooks().getSelectedRow(), 0));
        });

        bookBorrowForm.getComboBoxOptions().addItemListener((java.awt.event.ItemEvent evt) -> {
            search();
        });
    }

    public void search() {
        bookBorrowForm.getTableBooks().setModel(
                search(bookBorrowForm.getTextFieldSearch().getText(),
                        bookBorrowForm.getComboBoxOptions().getSelectedIndex(),
                        bookBorrowForm.getComboBoxDate().getSelectedIndex(),
                        bookBorrowForm.getDateChooserFirst().getDate() == null ? 0 : bookBorrowForm.getDateChooserFirst().getDate().getTime(),
                        bookBorrowForm.getDateChooserLast().getDate() == null ? 0 : bookBorrowForm.getDateChooserLast().getDate().getTime()));

    }

    private void write() {
        write(bookBorrowForm.getTableBooks(), bookBorrowForm.getTitle());
    }

    private void fillDateColumnToSelectionComboBox() {
        bookBorrowForm.getComboBoxDate().removeAll();
        bookBorrowForm.getComboBoxDate().addItem("");
        bookBorrowForm.getComboBoxDate().addItem(setLanguage("personbook.startdate"));
        bookBorrowForm.getComboBoxDate().addItem(setLanguage("personbook.deadline"));
        bookBorrowForm.getComboBoxDate().addItem(setLanguage("personbook.finishdate"));
    }

    private void finishDateOptionComboBox() {
        bookBorrowForm.getComboBoxOptions().removeAll();
        bookBorrowForm.getComboBoxOptions().addItem(setLanguage("bookborrowform.combobox.0option"));
        bookBorrowForm.getComboBoxOptions().addItem(setLanguage("bookborrowform.combobox.1option"));
        bookBorrowForm.getComboBoxOptions().addItem(setLanguage("bookborrowform.combobox.2option"));
        bookBorrowForm.getComboBoxOptions().addItem(setLanguage("bookborrowform.combobox.3option"));
        bookBorrowForm.getComboBoxOptions().addItem(setLanguage("bookborrowform.combobox.4option"));
    }

    private void setLanguage() {
        fillDateColumnToSelectionComboBox();
        finishDateOptionComboBox();
        bookBorrowForm.setTitle(setLanguage("bookborrowform.title"));
        bookBorrowForm.getLabelColumn().setText(setLanguage("table.label.column"));
        bookBorrowForm.getLabelStart().setText(setLanguage("table.begin.date"));
        bookBorrowForm.getLabelEnd().setText(setLanguage("table.end.date"));
        bookBorrowForm.getLabelSearch().setText(setLanguage("table.search"));
        bookBorrowForm.getButtonSearch().setText(setLanguage("table.search"));
        bookBorrowForm.getButtonReturn().setText(setLanguage("bookborrowform.return.button"));
        bookBorrowForm.getButtonDelete().setText(setLanguage("table.button.delete"));
        bookBorrowForm.getButtonWrite().setText(setLanguage("table.button.write.excel"));
    }

    private void delete() {
        int id = (int) bookBorrowForm.getTableBooks().getValueAt(bookBorrowForm.getTableBooks().getSelectedRow(), 0);
        if (deleteApproveMessage(id) && bookBorrowForm.getTableBooks().getValueAt(bookBorrowForm.getTableBooks().getSelectedRow(), 11) == null) {
            delete(id);
        }
        search();
    }
}
