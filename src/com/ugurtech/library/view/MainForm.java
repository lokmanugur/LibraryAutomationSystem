package com.ugurtech.library.view;

import com.ugurtech.library.persistance.user.UserDaoImpl;
import com.ugurtech.library.service.date.SimpleDate;
import com.ugurtech.library.view.book.AuthorForm;
import com.ugurtech.library.view.book.AuthorSearchForm;
import com.ugurtech.library.view.database.DatabaseUI;
import com.ugurtech.library.view.student.StudentSearchForm;
import com.ugurtech.library.view.student.StudentForm;
import com.ugurtech.library.view.school.SchoolSearchForm;
import com.ugurtech.library.view.user.UserTableForm;
import com.ugurtech.library.view.user.UserForm;
import com.ugurtech.library.view.book.BookForm;
import com.ugurtech.library.view.book.BookSearch;
import com.ugurtech.library.view.book.BookTypeForm;
import com.ugurtech.library.view.book.PublisherForm;
import com.ugurtech.library.view.bookborrowing.BorrowedBooksTable;
import com.ugurtech.library.view.person.PersonForm;
import com.ugurtech.library.view.person.PersonSearchForm;
import com.ugurtech.library.view.user.UserDetailsForm;
import javax.swing.JLabel;

public final class MainForm extends MainFrame {
    // private String dPaneimage="/img/MEBLogo.png"; 

    private static MainForm mainForm;
    private UserDaoImpl userDao;

    private MainForm() {
        initComponents();
        setDesktopPane(desktopPane);
    }

    public static MainForm getInstance() {
        if (mainForm == null) {
            return mainForm = new MainForm();
        } else {
            return mainForm;
        }
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        userPanel = new javax.swing.JPanel();
        tabbPane = new javax.swing.JTabbedPane();
        bookBar = new javax.swing.JToolBar();
        bookPanel = new javax.swing.JPanel();
        publisherButton = new javax.swing.JButton();
        authorTableButton = new javax.swing.JButton();
        authorButton = new javax.swing.JButton();
        bookTypeButton = new javax.swing.JButton();
        bookTable = new javax.swing.JButton();
        addBook = new javax.swing.JButton();
        takenBooksTableButton = new javax.swing.JButton();
        studentBar = new javax.swing.JToolBar();
        studentPanel = new javax.swing.JPanel();
        studentTable = new javax.swing.JButton();
        studentForm = new javax.swing.JButton();
        schoolBar = new javax.swing.JToolBar();
        schoolPanel = new javax.swing.JPanel();
        schoolForm = new javax.swing.JButton();
        userBar = new javax.swing.JToolBar();
        userPanel2 = new javax.swing.JPanel();
        userForm = new javax.swing.JButton();
        personTableButton = new javax.swing.JButton();
        userDetails = new javax.swing.JButton();
        userTable = new javax.swing.JButton();
        personFormButton = new javax.swing.JButton();
        statisticsBar = new javax.swing.JToolBar();
        statisticsPanel = new javax.swing.JPanel();
        topReadBooks = new javax.swing.JButton();
        topReadStudents = new javax.swing.JButton();
        settingsBar = new javax.swing.JToolBar();
        currentUserPanel = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        topMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        closeOperation = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenu();
        databaseMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("mainform.topmenubar.label")
        );
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        desktopPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                desktopPaneMouseEntered(evt);
            }
        });

        userPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabbPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabbPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabbPane.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tabbPane.setPreferredSize(new java.awt.Dimension(1044, 148));

        bookBar.setFloatable(false);
        bookBar.setRollover(true);

        publisherButton.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.bookbar.bookpanel.publisherbutton"));
        publisherButton.setFocusable(false);
        publisherButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        publisherButton.setMaximumSize(new java.awt.Dimension(110, 70));
        publisherButton.setMinimumSize(new java.awt.Dimension(110, 70));
        publisherButton.setPreferredSize(new java.awt.Dimension(110, 70));
        publisherButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        publisherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherButtonActionPerformed(evt);
            }
        });

        authorTableButton.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.bookbar.bookpanel.authortablebutton")
        );
        authorTableButton.setFocusable(false);
        authorTableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        authorTableButton.setMaximumSize(new java.awt.Dimension(110, 70));
        authorTableButton.setMinimumSize(new java.awt.Dimension(110, 70));
        authorTableButton.setPreferredSize(new java.awt.Dimension(110, 70));
        authorTableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        authorTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTableButtonActionPerformed(evt);
            }
        });

        authorButton.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.bookbar.bookpanel.authorbutton")
        );
        authorButton.setFocusable(false);
        authorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        authorButton.setMaximumSize(new java.awt.Dimension(110, 70));
        authorButton.setMinimumSize(new java.awt.Dimension(110, 70));
        authorButton.setPreferredSize(new java.awt.Dimension(110, 70));
        authorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        authorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorButtonActionPerformed(evt);
            }
        });

        bookTypeButton.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.bookbar.bookpanel.booktypebutton")
        );
        bookTypeButton.setFocusable(false);
        bookTypeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bookTypeButton.setMaximumSize(new java.awt.Dimension(110, 70));
        bookTypeButton.setMinimumSize(new java.awt.Dimension(110, 70));
        bookTypeButton.setPreferredSize(new java.awt.Dimension(110, 70));
        bookTypeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTypeButtonActionPerformed(evt);
            }
        });

        bookTable.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.bookbar.bookpanel.booktable")
        );
        bookTable.setFocusable(false);
        bookTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bookTable.setMaximumSize(new java.awt.Dimension(110, 70));
        bookTable.setMinimumSize(new java.awt.Dimension(110, 70));
        bookTable.setPreferredSize(new java.awt.Dimension(110, 70));
        bookTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bookTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTableActionPerformed(evt);
            }
        });

        addBook.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.bookbar.bookpanel.addbook")
        );
        addBook.setFocusable(false);
        addBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBook.setMaximumSize(new java.awt.Dimension(110, 70));
        addBook.setMinimumSize(new java.awt.Dimension(110, 70));
        addBook.setPreferredSize(new java.awt.Dimension(110, 70));
        addBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookActionPerformed(evt);
            }
        });

        takenBooksTableButton.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.bookbar.bookpanel.takenbooktablebutton")
        );
        takenBooksTableButton.setFocusable(false);
        takenBooksTableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        takenBooksTableButton.setMaximumSize(new java.awt.Dimension(110, 70));
        takenBooksTableButton.setMinimumSize(new java.awt.Dimension(110, 70));
        takenBooksTableButton.setPreferredSize(new java.awt.Dimension(110, 70));
        takenBooksTableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        takenBooksTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takenBooksTableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookPanelLayout = new javax.swing.GroupLayout(bookPanel);
        bookPanel.setLayout(bookPanelLayout);
        bookPanelLayout.setHorizontalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookPanelLayout.createSequentialGroup()
                .addComponent(takenBooksTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(addBook, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bookTable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bookTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(authorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(authorTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(publisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        bookPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addBook, authorButton, authorTableButton, bookTable, bookTypeButton, publisherButton, takenBooksTableButton});

        bookPanelLayout.setVerticalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(takenBooksTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(addBook, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bookTable, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bookTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(authorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(authorTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(publisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bookPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addBook, authorButton, authorTableButton, bookTable, bookTypeButton, publisherButton, takenBooksTableButton});

        bookBar.add(bookPanel);

        tabbPane.addTab(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.bookbar"), new javax.swing.ImageIcon(getClass().getResource("/resources/img/bookshelf64.png")), bookBar); // NOI18N

        studentBar.setFloatable(false);
        studentBar.setRollover(true);

        studentTable.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.studentbar.studentpanel.studenttable"));
        studentTable.setFocusable(false);
        studentTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        studentTable.setMaximumSize(new java.awt.Dimension(110, 70));
        studentTable.setMinimumSize(new java.awt.Dimension(110, 70));
        studentTable.setPreferredSize(new java.awt.Dimension(110, 70));
        studentTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        studentTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentTableActionPerformed(evt);
            }
        });

        studentForm.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.studentbar.studentpanel.studentform")
        );
        studentForm.setFocusable(false);
        studentForm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        studentForm.setMaximumSize(new java.awt.Dimension(110, 70));
        studentForm.setMinimumSize(new java.awt.Dimension(110, 70));
        studentForm.setPreferredSize(new java.awt.Dimension(110, 70));
        studentForm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        studentForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addComponent(studentForm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(studentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 818, Short.MAX_VALUE))
        );

        studentPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {studentForm, studentTable});

        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentForm, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        studentPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {studentForm, studentTable});

        studentBar.add(studentPanel);

        tabbPane.addTab(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.studentbar"), new javax.swing.ImageIcon(getClass().getResource("/resources/img/graduated64.png")), studentBar); // NOI18N

        schoolBar.setFloatable(false);
        schoolBar.setRollover(true);

        schoolForm.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.schoolbar.schoolpanel.schoolform"));
        schoolForm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        schoolForm.setMaximumSize(new java.awt.Dimension(110, 70));
        schoolForm.setMinimumSize(new java.awt.Dimension(110, 70));
        schoolForm.setPreferredSize(new java.awt.Dimension(110, 70));
        schoolForm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        schoolForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout schoolPanelLayout = new javax.swing.GroupLayout(schoolPanel);
        schoolPanel.setLayout(schoolPanelLayout);
        schoolPanelLayout.setHorizontalGroup(
            schoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schoolPanelLayout.createSequentialGroup()
                .addComponent(schoolForm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 928, Short.MAX_VALUE))
        );
        schoolPanelLayout.setVerticalGroup(
            schoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(schoolForm, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        schoolBar.add(schoolPanel);

        tabbPane.addTab(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.schoolbar")
            , new javax.swing.ImageIcon(getClass().getResource("/resources/img/school64.png")), schoolBar); // NOI18N

        userBar.setFloatable(false);
        userBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        userForm.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.userbar.userpanel2.userform")
        );
        userForm.setFocusable(false);
        userForm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userForm.setMaximumSize(new java.awt.Dimension(110, 70));
        userForm.setMinimumSize(new java.awt.Dimension(110, 70));
        userForm.setPreferredSize(new java.awt.Dimension(110, 70));
        userForm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        userForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFormActionPerformed(evt);
            }
        });

        personTableButton.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.userbar.userpanel2.persontablebutton"));
        personTableButton.setFocusable(false);
        personTableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        personTableButton.setMaximumSize(new java.awt.Dimension(110, 70));
        personTableButton.setMinimumSize(new java.awt.Dimension(110, 70));
        personTableButton.setPreferredSize(new java.awt.Dimension(110, 70));
        personTableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        personTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personTableButtonActionPerformed(evt);
            }
        });

        userDetails.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.userbar.userpanel2.userdetail"));
        userDetails.setFocusable(false);
        userDetails.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userDetails.setMaximumSize(new java.awt.Dimension(110, 70));
        userDetails.setMinimumSize(new java.awt.Dimension(110, 70));
        userDetails.setPreferredSize(new java.awt.Dimension(110, 70));
        userDetails.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        userDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDetailsActionPerformed(evt);
            }
        });

        userTable.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.userbar.userpanel2.usertable"));
        userTable.setFocusable(false);
        userTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userTable.setMaximumSize(new java.awt.Dimension(110, 70));
        userTable.setMinimumSize(new java.awt.Dimension(110, 70));
        userTable.setPreferredSize(new java.awt.Dimension(110, 70));
        userTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        userTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTableActionPerformed(evt);
            }
        });

        personFormButton.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.userbar.userpanel2.personformbutton"));
        personFormButton.setFocusable(false);
        personFormButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        personFormButton.setMaximumSize(new java.awt.Dimension(110, 70));
        personFormButton.setMinimumSize(new java.awt.Dimension(110, 70));
        personFormButton.setPreferredSize(new java.awt.Dimension(110, 70));
        personFormButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        personFormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personFormButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userPanel2Layout = new javax.swing.GroupLayout(userPanel2);
        userPanel2.setLayout(userPanel2Layout);
        userPanel2Layout.setHorizontalGroup(
            userPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanel2Layout.createSequentialGroup()
                .addComponent(personFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(personTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(userForm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(userTable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(userDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(488, Short.MAX_VALUE))
        );

        userPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {personFormButton, personTableButton, userDetails, userForm, userTable});

        userPanel2Layout.setVerticalGroup(
            userPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(personFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(personTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(userForm, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(userTable, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(userDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        userPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {personFormButton, personTableButton, userDetails, userForm, userTable});

        userBar.add(userPanel2);

        tabbPane.addTab(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.userbar"), new javax.swing.ImageIcon(getClass().getResource("/resources/img/profile64.png")), userBar); // NOI18N

        statisticsBar.setFloatable(false);
        statisticsBar.setRollover(true);

        topReadBooks.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.statisticsbar.statisticspanel.topreadbooks"));
        topReadBooks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topReadBooks.setMaximumSize(new java.awt.Dimension(110, 70));
        topReadBooks.setMinimumSize(new java.awt.Dimension(110, 70));
        topReadBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topReadBooksActionPerformed(evt);
            }
        });

        topReadStudents.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.statisticsbar.statisticspanel.topreadstudents"));
        topReadStudents.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topReadStudents.setMaximumSize(new java.awt.Dimension(110, 70));
        topReadStudents.setMinimumSize(new java.awt.Dimension(110, 70));
        topReadStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topReadStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statisticsPanelLayout = new javax.swing.GroupLayout(statisticsPanel);
        statisticsPanel.setLayout(statisticsPanelLayout);
        statisticsPanelLayout.setHorizontalGroup(
            statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticsPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(topReadBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(topReadStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(818, Short.MAX_VALUE))
        );

        statisticsPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {topReadBooks, topReadStudents});

        statisticsPanelLayout.setVerticalGroup(
            statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticsPanelLayout.createSequentialGroup()
                .addGroup(statisticsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topReadStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topReadBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        statisticsPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {topReadBooks, topReadStudents});

        statisticsBar.add(statisticsPanel);

        tabbPane.addTab(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.statisticsbar"), new javax.swing.ImageIcon(getClass().getResource("/resources/img/statistics64.png")), statisticsBar); // NOI18N

        settingsBar.setFloatable(false);
        settingsBar.setRollover(true);
        tabbPane.addTab(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("userpanel.tabbpane.settingsbar"), new javax.swing.ImageIcon(getClass().getResource("/resources/img/settings64.png")), settingsBar); // NOI18N

        currentUserPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        userLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/enter.png"))); // NOI18N
        userLabel.setToolTipText("Sistemde Aktif Olan Kullnici");
        userLabel.setAlignmentX(0.5F);
        userLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLabelMouseClicked(evt);
            }
        });

        dateLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Date");

        timeLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Time");

        javax.swing.GroupLayout currentUserPanelLayout = new javax.swing.GroupLayout(currentUserPanel);
        currentUserPanel.setLayout(currentUserPanelLayout);
        currentUserPanelLayout.setHorizontalGroup(
            currentUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        currentUserPanelLayout.setVerticalGroup(
            currentUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currentUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addComponent(tabbPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(currentUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addComponent(tabbPane, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(currentUserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbPane.getAccessibleContext().setAccessibleName("tabbpane");

        fileMenu.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("mainform.topmenubar.filemenu")
        );

        closeOperation.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("mainform.topmenubar.filemenu.closeoperation")
        );
        closeOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeOperationActionPerformed(evt);
            }
        });
        fileMenu.add(closeOperation);

        topMenuBar.add(fileMenu);

        settingsMenu.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("mainform.topmenubar.settingsmenu")
        );
        settingsMenu.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        databaseMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        databaseMenuItem.setText(com.ugurtech.library.service.localization.Internationalization.getInstance().getLable("mainform.topmenubar.settingsmenu.databasemenuitem"));
        databaseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseMenuItemActionPerformed(evt);
            }
        });
        settingsMenu.add(databaseMenuItem);

        topMenuBar.add(settingsMenu);

        setJMenuBar(topMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktopPane)
                    .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void bookTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTableActionPerformed
        addDesktopPane(BookSearch.getInstance());
    }//GEN-LAST:event_bookTableActionPerformed
    private void addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookActionPerformed
        addDesktopPane(BookForm.getInstance());
    }//GEN-LAST:event_addBookActionPerformed
    private void studentFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentFormActionPerformed
        addDesktopPane(StudentForm.getInstance());
    }//GEN-LAST:event_studentFormActionPerformed
    private void studentTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentTableActionPerformed
        addDesktopPane(StudentSearchForm.getInstance());
    }//GEN-LAST:event_studentTableActionPerformed
    private void schoolFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolFormActionPerformed
        addDesktopPane(SchoolSearchForm.getInstance());
    }//GEN-LAST:event_schoolFormActionPerformed
    private void userFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFormActionPerformed
        addDesktopPane(UserForm.getInstance());
    }//GEN-LAST:event_userFormActionPerformed
    private void userTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTableActionPerformed
        addDesktopPane(UserTableForm.getInstance());
    }//GEN-LAST:event_userTableActionPerformed
    private void databaseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseMenuItemActionPerformed
        addDesktopPane(DatabaseUI.getInstance());
    }//GEN-LAST:event_databaseMenuItemActionPerformed

    private void topReadBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topReadBooksActionPerformed
        //addDesktopPane(UserForm.getInstance());
    }//GEN-LAST:event_topReadBooksActionPerformed

    private void topReadStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topReadStudentsActionPerformed
        //addDesktopPane(UserTableForm.getInstance());
    }//GEN-LAST:event_topReadStudentsActionPerformed

    private void closeOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeOperationActionPerformed
        if (!userDao.isClosed()) {
            userDao.closeConnection();
        }
        this.dispose();
        LoginForm.getInstance().dispose();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }//GEN-LAST:event_closeOperationActionPerformed

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            exitMainForm();
            evt.consume();
        }
    }//GEN-LAST:event_userLabelMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.println("window closing method work at MainForm");
    }//GEN-LAST:event_formWindowClosing

    private void authorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorButtonActionPerformed
        addDesktopPane(AuthorForm.getInstance());
    }//GEN-LAST:event_authorButtonActionPerformed

    private void publisherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherButtonActionPerformed
        addDesktopPane(PublisherForm.getInstance());
    }//GEN-LAST:event_publisherButtonActionPerformed

    private void authorTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorTableButtonActionPerformed
        addDesktopPane(AuthorSearchForm.getInstance());
    }//GEN-LAST:event_authorTableButtonActionPerformed

    private void userDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDetailsActionPerformed
        addDesktopPane(UserDetailsForm.getInstance());
    }//GEN-LAST:event_userDetailsActionPerformed

    private void personFormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personFormButtonActionPerformed
        addDesktopPane(PersonForm.getInstance());
    }//GEN-LAST:event_personFormButtonActionPerformed

    private void personTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personTableButtonActionPerformed
        addDesktopPane(PersonSearchForm.getInstance());
    }//GEN-LAST:event_personTableButtonActionPerformed

    private void takenBooksTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takenBooksTableButtonActionPerformed
        addDesktopPane(BorrowedBooksTable.getInstance());
    }//GEN-LAST:event_takenBooksTableButtonActionPerformed

    private void bookTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTypeButtonActionPerformed
        addDesktopPane(BookTypeForm.getInstance());
    }//GEN-LAST:event_bookTypeButtonActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        System.out.println("mous entered");
        SimpleDate.getInstance().setTimeStart();
    }//GEN-LAST:event_formMouseEntered

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        SimpleDate.getInstance().setTimeStart();
        System.out.println("mous entered");
    }//GEN-LAST:event_formKeyPressed

    private void desktopPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desktopPaneMouseEntered
        SimpleDate.getInstance().setTimeStart();
        System.out.println("mous entered");
    }//GEN-LAST:event_desktopPaneMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBook;
    private javax.swing.JButton authorButton;
    private javax.swing.JButton authorTableButton;
    private javax.swing.JToolBar bookBar;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JButton bookTable;
    private javax.swing.JButton bookTypeButton;
    private javax.swing.JMenuItem closeOperation;
    private javax.swing.JPanel currentUserPanel;
    private javax.swing.JMenuItem databaseMenuItem;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton personFormButton;
    private javax.swing.JButton personTableButton;
    private javax.swing.JButton publisherButton;
    private javax.swing.JToolBar schoolBar;
    private javax.swing.JButton schoolForm;
    private javax.swing.JPanel schoolPanel;
    private javax.swing.JToolBar settingsBar;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JToolBar statisticsBar;
    private javax.swing.JPanel statisticsPanel;
    private javax.swing.JToolBar studentBar;
    private javax.swing.JButton studentForm;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JButton studentTable;
    private javax.swing.JTabbedPane tabbPane;
    private javax.swing.JButton takenBooksTableButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JMenuBar topMenuBar;
    private javax.swing.JButton topReadBooks;
    private javax.swing.JButton topReadStudents;
    private javax.swing.JToolBar userBar;
    private javax.swing.JButton userDetails;
    private javax.swing.JButton userForm;
    private javax.swing.JLabel userLabel;
    private javax.swing.JPanel userPanel;
    private javax.swing.JPanel userPanel2;
    private javax.swing.JButton userTable;
    // End of variables declaration//GEN-END:variables

    public JLabel getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(JLabel userLabel) {
        this.userLabel = userLabel;
    }

    public JLabel getDateLabel() {
        return dateLabel;
    }

    public void setDateLabel(JLabel dateLabel) {
        this.dateLabel = dateLabel;
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    public void exitMainForm() {
        this.setVisible(false);
        LoginForm.getInstance().setVisible(true);
    }

}
