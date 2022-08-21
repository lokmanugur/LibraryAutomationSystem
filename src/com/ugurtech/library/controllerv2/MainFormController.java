/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.modelv2.MainModel;
import com.ugurtech.library.service.date.SimpleDate;
import com.ugurtech.library.view.LoginForm;
import com.ugurtech.library.view.MainForm;
import com.ugurtech.library.view.author.AuthorForm;
import com.ugurtech.library.view.author.AuthorSearchForm;
import com.ugurtech.library.view.book.BookForm;
import com.ugurtech.library.view.book.BookSearch;
import com.ugurtech.library.view.booktype.BookTypeForm;
import com.ugurtech.library.view.publisher.PublisherForm;
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
public class MainFormController extends AbstractController {

    private final MainForm mainForm;
    private MainModel mainModel;

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
                SimpleDate.getInstance().setTimeStart();
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
                SimpleDate.getInstance().setTimeStart();
            }
        });

        mainForm.getDesktopPane().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SimpleDate.getInstance().setTimeStart();
            }
        });
        mainForm.getPublisherButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(PublisherForm.getInstance());
        });
        mainForm.getAuthorTableButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(AuthorSearchForm.getInstance());
        });
        mainForm.getAuthorButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(AuthorForm.getInstance());
        });
        mainForm.getBookTypeButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(BookTypeForm.getInstance());
        });
        mainForm.getBookTable().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(BookSearch.getInstance());
        });
        mainForm.getAddBook().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(BookForm.getInstance());
        });
        mainForm.getTakenBooksTableButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(BorrowedBooksTable.getInstance());
        });
        mainForm.getStudentTable().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(StudentSearchForm.getInstance());
        });
        mainForm.getStudentForm().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(StudentForm.getInstance());
        });
        mainForm.getSchoolForm().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(SchoolSearchForm.getInstance());
        });
        mainForm.getUserForm().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(UserForm.getInstance());
        });
        mainForm.getPersonTableButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(PersonSearchForm.getInstance());
        });
        mainForm.getUserDetails().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(UserDetailsForm.getInstance());
        });
        mainForm.getUserTable().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(UserTableForm.getInstance());
        });
        mainForm.getPersonFormButton().addActionListener((java.awt.event.ActionEvent evt) -> {
            mainForm.addDesktopPane(PersonForm.getInstance());
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
        mainForm.getAuthorButton().setText(setLanguage("userpanel.tabbpane.bookbar.bookpanel.authorbutton"));
        mainForm.getBookTypeButton().setText(setLanguage("userpanel.tabbpane.bookbar.bookpanel.booktypebutton"));
        mainForm.getBookTable().setText(setLanguage("userpanel.tabbpane.bookbar.bookpanel.booktable"));
        mainForm.getAddBook().setText(setLanguage("userpanel.tabbpane.bookbar.bookpanel.addbook"));
        mainForm.getTakenBooksTableButton().setText(setLanguage("userpanel.tabbpane.bookbar.bookpanel.takenbooktablebutton"));

        mainForm.getTabbPane().setTitleAt(1, setLanguage("userpanel.tabbpane.studentbar"));
        mainForm.getStudentTable().setText(setLanguage("userpanel.tabbpane.studentbar.studentpanel.studenttable"));
        mainForm.getStudentForm().setText(setLanguage("userpanel.tabbpane.studentbar.studentpanel.studentform"));

        mainForm.getTabbPane().setTitleAt(2, setLanguage("userpanel.tabbpane.schoolbar"));
        mainForm.getSchoolForm().setText(setLanguage("userpanel.tabbpane.schoolbar.schoolpanel.schoolform"));

        mainForm.getTabbPane().setTitleAt(3, setLanguage("userpanel.tabbpane.userbar"));
        mainForm.getUserForm().setText(setLanguage("userpanel.tabbpane.userbar.userpanel2.userform"));
        mainForm.getPersonTableButton().setText(setLanguage("userpanel.tabbpane.userbar.userpanel2.persontablebutton"));
        mainForm.getUserDetails().setText(setLanguage("userpanel.tabbpane.userbar.userpanel2.userdetail"));
        mainForm.getUserTable().setText(setLanguage("userpanel.tabbpane.userbar.userpanel2.usertable"));
        mainForm.getPersonFormButton().setText(setLanguage("userpanel.tabbpane.userbar.userpanel2.personformbutton"));

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
