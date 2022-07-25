/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.modelv2.MainModel;
import com.ugurtech.library.service.date.SimpleDate;
import com.ugurtech.library.view.LoginForm;
import com.ugurtech.library.view.MainForm;
import com.ugurtech.library.view.book.AuthorForm;
import com.ugurtech.library.view.book.AuthorSearchForm;
import com.ugurtech.library.view.book.BookForm;
import com.ugurtech.library.view.book.BookSearch;
import com.ugurtech.library.view.book.BookTypeForm;
import com.ugurtech.library.view.book.PublisherForm;
import com.ugurtech.library.view.bookborrowing.BorrowedBooksTable;
import com.ugurtech.library.view.database.DatabaseUI;
import com.ugurtech.library.view.person.PersonForm;
import com.ugurtech.library.view.person.PersonSearchForm;
import com.ugurtech.library.view.school.SchoolSearchForm;
import com.ugurtech.library.view.student.StudentForm;
import com.ugurtech.library.view.student.StudentSearchForm;
import com.ugurtech.library.view.user.UserDetailsForm;
import com.ugurtech.library.view.user.UserForm;
import com.ugurtech.library.view.user.UserTableForm;

/**
 *
 * @author Teacher
 */
public class MainFormController {

    private static MainFormController mainFormController;
    private final MainForm mainForm = MainForm.getInstance();
    private final MainModel mainModel=null;

    public static MainFormController getInstance(){
        if(mainFormController == null)
            return mainFormController = new MainFormController();
        else
            return mainFormController;
    }
    
    private MainFormController(){
        initView();
        initController();
    }

    public MainForm getMainForm() {
        return mainForm;
    }

    private void initView() {
        mainForm.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        mainForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        mainForm.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        mainForm.getDesktopPane().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                desktopPaneMouseEntered(evt);
            }
        });
        mainForm.getPublisherButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            publisherButtonActionPerformed(evt);
        });
        mainForm.getAuthorTableButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            authorTableButtonActionPerformed(evt);
        });
        mainForm.getAuthorButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            authorButtonActionPerformed(evt);
        });
        mainForm.getBookTypeButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            bookTypeButtonActionPerformed(evt);
        });
        mainForm.getBookTable().addActionListener((java.awt.event.ActionEvent evt) -> {
            bookTableActionPerformed(evt);
        });
        mainForm.getAddBook().addActionListener((java.awt.event.ActionEvent evt) -> {
            addBookActionPerformed(evt);
        });
        mainForm.getTakenBooksTableButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            takenBooksTableButtonActionPerformed(evt);
        });
        mainForm.getStudentTable().addActionListener((java.awt.event.ActionEvent evt) -> {
            studentTableActionPerformed(evt);
        });
        mainForm.getStudentForm().addActionListener((java.awt.event.ActionEvent evt) -> {
            studentFormActionPerformed(evt);
        });
        mainForm.getSchoolForm().addActionListener((java.awt.event.ActionEvent evt) -> {
            schoolFormActionPerformed(evt);
        });
        mainForm.getUserForm().addActionListener((java.awt.event.ActionEvent evt) -> {
            userFormActionPerformed(evt);
        });
        mainForm.getPersonTableButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            personTableButtonActionPerformed(evt);
        });
        mainForm.getUserDetails().addActionListener((java.awt.event.ActionEvent evt) -> {
            userDetailsActionPerformed(evt);
        });
        mainForm.getUserTable().addActionListener((java.awt.event.ActionEvent evt) -> {
            userTableActionPerformed(evt);
        });
        mainForm.getPersonFormButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            personFormButtonActionPerformed(evt);
        });
        mainForm.getTopReadBooks().addActionListener((java.awt.event.ActionEvent evt) -> {
            topReadBooksActionPerformed(evt);
        });
        mainForm.getTopReadStudents().addActionListener((java.awt.event.ActionEvent evt) -> {
            topReadStudentsActionPerformed(evt);
        });
        mainForm.getUserLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLabelMouseClicked(evt);
            }
        });
        mainForm.getCloseOperation().addActionListener((java.awt.event.ActionEvent evt) -> {
            closeOperationActionPerformed(evt);
        });
        mainForm.getDatabaseMenuItem().addActionListener((java.awt.event.ActionEvent evt) -> {
            databaseMenuItemActionPerformed(evt);
        });
    }

    private void initController() {

    }

    private void bookTableActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(BookSearch.getInstance());
    }

    private void addBookActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(BookForm.getInstance());
    }

    private void studentFormActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(StudentForm.getInstance());
    }

    private void studentTableActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(StudentSearchForm.getInstance());
    }

    private void schoolFormActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(SchoolSearchForm.getInstance());
    }

    private void userFormActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(UserForm.getInstance());
    }

    private void userTableActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(UserTableForm.getInstance());
    }

    private void databaseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(DatabaseUI.getInstance());
    }

    private void topReadBooksActionPerformed(java.awt.event.ActionEvent evt) {
        //addDesktopPane(UserForm.getInstance());
    }

    private void topReadStudentsActionPerformed(java.awt.event.ActionEvent evt) {
        //addDesktopPane(new FirstStepFormController(new FirstStepForm(), new FirstStepModel()).getFirstStepForm());
    }

    private void closeOperationActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.dispose();
        LoginForm.INSTANCE.dispose();
        mainForm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            mainForm.returnLoginForm();
            evt.consume();
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        System.out.println("window closing method work at MainForm");
    }

    private void authorButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(AuthorForm.getInstance());
    }

    private void publisherButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(PublisherForm.getInstance());
    }

    private void authorTableButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(AuthorSearchForm.getInstance());
    }

    private void userDetailsActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(UserDetailsForm.getInstance());
    }

    private void personFormButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(PersonForm.getInstance());
    }

    private void personTableButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(PersonSearchForm.getInstance());
    }

    private void takenBooksTableButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(BorrowedBooksTable.getInstance());
    }

    private void bookTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        mainForm.addDesktopPane(BookTypeForm.getInstance());
    }

    private void formMouseEntered(java.awt.event.MouseEvent evt) {
        SimpleDate.getInstance().setTimeStart();
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        SimpleDate.getInstance().setTimeStart();
    }

    private void desktopPaneMouseEntered(java.awt.event.MouseEvent evt) {
        SimpleDate.getInstance().setTimeStart();
    }
}
