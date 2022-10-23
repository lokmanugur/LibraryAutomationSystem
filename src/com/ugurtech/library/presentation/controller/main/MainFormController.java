/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 */
package com.ugurtech.library.presentation.controller.main;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.application.lib.date.SessionTimeCounter;
import com.ugurtech.library.presentation.view.login.LoginForm;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.author.AuthorSearchForm;
import com.ugurtech.library.presentation.view.book.BookSearchForm;
import com.ugurtech.library.presentation.view.booktype.BookTypeSearchForm;
import com.ugurtech.library.presentation.view.publisher.PublisherSearchForm;
import com.ugurtech.library.presentation.view.borrow.BookBorrowFollowForm;
import com.ugurtech.library.presentation.view.borrow.BookBorrowForm;
import com.ugurtech.library.presentation.view.borrow.StartBorrowForm;
import com.ugurtech.library.presentation.view.classstd.ClassSearchForm;
import com.ugurtech.library.presentation.view.database.DatabaseUI;
import com.ugurtech.library.presentation.view.person.PersonSearchForm;
import com.ugurtech.library.presentation.view.school.SchoolSearchForm;
import com.ugurtech.library.presentation.view.student.StudentSearchForm;
import com.ugurtech.library.presentation.view.user.UserSearchForm;

/**
 *
 * @author Teacher
 *
 */
public class MainFormController extends AbstractController implements Initialize {

    private final MainForm mainForm;

    public MainFormController(MainForm mainForm) {
        this.mainForm = mainForm;
        initView();
        initController();
    }

    @Override
    public final void initView() {

        setLenguage();
    }

    @Override
    public final void initController() {
        mainForm.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SessionTimeCounter.getInstance().setStartTime();
            }
        });
        mainForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                System.out.println("window closing method work at MainForm");
            }
        });
        mainForm.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SessionTimeCounter.getInstance().setStartTime();
            }
        });

        mainForm.getDesktopPane().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SessionTimeCounter.getInstance().setStartTime();
            }
        });
        mainForm.getButtonBookBorrow().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(BookBorrowForm.INSTANCE);
        });
        mainForm.getButtonBasket().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(StartBorrowForm.INSTANCE);
        });
        mainForm.getPublisherButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(PublisherSearchForm.INSTANCE);
        });
        mainForm.getAuthorTableButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(AuthorSearchForm.getInstance());
        });
        mainForm.getBookTypeButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(BookTypeSearchForm.getInstance());
        });
        mainForm.getBookTable().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(BookSearchForm.getInstance());
        });
        mainForm.getStudentTable().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(StudentSearchForm.INSTANCE);
        });
        mainForm.getSchoolForm().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(SchoolSearchForm.INSTANCE);
        });
        mainForm.getPersonTableButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(PersonSearchForm.INSTANCE);
        });
        mainForm.getUserTable().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(UserSearchForm.INSTANCE);
        });
        mainForm.getGradeButton().addActionListener((e) -> {
            mainForm.addDesktopPane(ClassSearchForm.INSTANCE);
        });
        mainForm.getTopReadBooks().addActionListener((java.awt.event.ActionEvent evt) -> {
            //addDesktopPane(UserForm.getInstance());
        });
        mainForm.getTopReadStudents().addActionListener((java.awt.event.ActionEvent evt) -> {
            //addDesktopPane(new FirstStepFormController(new FirstStepForm(), new FirstStepModel()).getFirstStepForm());
        });
        mainForm.getUserLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                    mainForm.returnLoginForm();
                    evt.consume();
                }
            }
        });
        mainForm.getCloseOperation().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.dispose();
            LoginForm.INSTANCE.dispose();
            mainForm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        });
        mainForm.getDatabaseMenuItem().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(DatabaseUI.getInstance());
        });
    }

    private void setLenguage() {
        mainForm.getTabbPane().setTitleAt(0, setLanguage("userpanel.tabbpane.bookbar"));
        mainForm.getPublisherButton().setText(setLanguage("userpanel.tabbpane.bookbar.bookpanel.publisherbutton"));
        mainForm.getAuthorTableButton().setText(setLanguage("userpanel.tabbpane.bookbar.bookpanel.authortablebutton"));
        mainForm.getBookTypeButton().setText(setLanguage("userpanel.tabbpane.bookbar.bookpanel.booktypebutton"));
        mainForm.getBookTable().setText(setLanguage("userpanel.tabbpane.bookbar.bookpanel.booktable"));
        mainForm.getTabbPane().setTitleAt(1, setLanguage("userpanel.tabbpane.studentbar"));
        mainForm.getStudentTable().setText(setLanguage("userpanel.tabbpane.studentbar.studentpanel.studenttable"));
        mainForm.getTabbPane().setTitleAt(2, setLanguage("userpanel.tabbpane.schoolbar"));
        mainForm.getSchoolForm().setText(setLanguage("userpanel.tabbpane.schoolbar.schoolpanel.schoolform"));
        mainForm.getTabbPane().setTitleAt(3, setLanguage("userpanel.tabbpane.userbar"));
        mainForm.getPersonTableButton().setText(setLanguage("userpanel.tabbpane.userbar.userpanel2.persontablebutton"));
        mainForm.getUserTable().setText(setLanguage("userpanel.tabbpane.userbar.userpanel2.usertable"));
        mainForm.getTabbPane().setTitleAt(4, setLanguage("userpanel.tabbpane.statisticsbar"));
        mainForm.getTopReadBooks().setText(setLanguage("userpanel.tabbpane.statisticsbar.statisticspanel.topreadbooks"));
        mainForm.getTopReadStudents().setText(setLanguage("userpanel.tabbpane.statisticsbar.statisticspanel.topreadstudents"));
        mainForm.getTabbPane().setTitleAt(5, setLanguage("userpanel.tabbpane.settingsbar"));
        mainForm.setTitle(setLanguage("mainform.topmenubar.label"));
        mainForm.getFileMenu().setText(setLanguage("mainform.topmenubar.filemenu"));
        mainForm.getCloseOperation().setText(setLanguage("mainform.topmenubar.filemenu.closeoperation"));
        mainForm.getSettingsMenu().setText(setLanguage("mainform.topmenubar.settingsmenu"));
        mainForm.getDatabaseMenuItem().setText(setLanguage("mainform.topmenubar.settingsmenu.databasemenuitem"));

    }
}
