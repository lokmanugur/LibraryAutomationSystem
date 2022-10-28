package com.ugurtech.library.presentation.view.main;

import com.ugurtech.library.presentation.controller.main.MainFormController;
import com.ugurtech.library.presentation.view.login.LoginForm;
import com.ugurtech.library.application.lib.date.SessionTimeCounter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

public final class MainForm extends MainFrame {
    // private String dPaneimage="/img/MEBLogo.png"; 
    public static final MainForm INSTANCE = new MainForm();
    private MainForm() {
        initComponents();
        setDesktopPane(desktopPane);
        new MainFormController(this).getClass();
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
        bookTypeButton = new javax.swing.JButton();
        bookTable = new javax.swing.JButton();
        buttonBookBorrow = new javax.swing.JButton();
        buttonBasket = new javax.swing.JButton();
        studentBar = new javax.swing.JToolBar();
        studentPanel = new javax.swing.JPanel();
        studentTable = new javax.swing.JButton();
        schoolBar = new javax.swing.JToolBar();
        schoolPanel = new javax.swing.JPanel();
        schoolForm = new javax.swing.JButton();
        gradeButton = new javax.swing.JButton();
        userBar = new javax.swing.JToolBar();
        userPanel2 = new javax.swing.JPanel();
        personTableButton = new javax.swing.JButton();
        userTable = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Library Automation System");

        userPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabbPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabbPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabbPane.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tabbPane.setPreferredSize(new java.awt.Dimension(1044, 148));

        bookBar.setRollover(true);

        publisherButton.setText("<html><center>Publisher<br>Table</center></html>");
        publisherButton.setFocusable(false);
        publisherButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        publisherButton.setMaximumSize(new java.awt.Dimension(110, 70));
        publisherButton.setMinimumSize(new java.awt.Dimension(110, 70));
        publisherButton.setPreferredSize(new java.awt.Dimension(110, 70));
        publisherButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        authorTableButton.setText("<html><center>Author<br>Table</center></html>");
        authorTableButton.setFocusable(false);
        authorTableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        authorTableButton.setMaximumSize(new java.awt.Dimension(110, 70));
        authorTableButton.setMinimumSize(new java.awt.Dimension(110, 70));
        authorTableButton.setPreferredSize(new java.awt.Dimension(110, 70));
        authorTableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        bookTypeButton.setText("<html><center>Books Type<br>Table</center></html>");
        bookTypeButton.setFocusable(false);
        bookTypeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bookTypeButton.setMaximumSize(new java.awt.Dimension(110, 70));
        bookTypeButton.setMinimumSize(new java.awt.Dimension(110, 70));
        bookTypeButton.setPreferredSize(new java.awt.Dimension(110, 70));
        bookTypeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        bookTable.setText("<html><center>Books<br>Table</center></html>");
        bookTable.setFocusable(false);
        bookTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bookTable.setMaximumSize(new java.awt.Dimension(110, 70));
        bookTable.setMinimumSize(new java.awt.Dimension(110, 70));
        bookTable.setPreferredSize(new java.awt.Dimension(110, 70));
        bookTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonBookBorrow.setText("<html><center>Borrow<br>Book Table</center></html>");
        buttonBookBorrow.setFocusable(false);
        buttonBookBorrow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonBookBorrow.setMaximumSize(new java.awt.Dimension(110, 70));
        buttonBookBorrow.setMinimumSize(new java.awt.Dimension(110, 70));
        buttonBookBorrow.setPreferredSize(new java.awt.Dimension(110, 70));
        buttonBookBorrow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        buttonBasket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/basketempty32.png"))); // NOI18N
        buttonBasket.setText("<html><center>Book Basket</center></html>");
        buttonBasket.setToolTipText("");
        buttonBasket.setFocusable(false);
        buttonBasket.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonBasket.setMaximumSize(new java.awt.Dimension(110, 70));
        buttonBasket.setMinimumSize(new java.awt.Dimension(110, 70));
        buttonBasket.setPreferredSize(new java.awt.Dimension(110, 70));
        buttonBasket.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout bookPanelLayout = new javax.swing.GroupLayout(bookPanel);
        bookPanel.setLayout(bookPanelLayout);
        bookPanelLayout.setHorizontalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonBookBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(buttonBasket, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bookTable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bookTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(authorTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(publisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bookPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {authorTableButton, bookTable, bookTypeButton, publisherButton});

        bookPanelLayout.setVerticalGroup(
            bookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookTable, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bookTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(authorTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(publisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(buttonBookBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(buttonBasket, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bookPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {authorTableButton, bookTable, bookTypeButton, publisherButton});

        bookBar.add(bookPanel);

        tabbPane.addTab("Books", new javax.swing.ImageIcon(getClass().getResource("/resources/img/bookshelf64.png")), bookBar); // NOI18N

        studentBar.setRollover(true);

        studentTable.setText("<html><center>Students<br>Table</center></html>");
        studentTable.setFocusable(false);
        studentTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        studentTable.setMaximumSize(new java.awt.Dimension(110, 70));
        studentTable.setMinimumSize(new java.awt.Dimension(110, 70));
        studentTable.setPreferredSize(new java.awt.Dimension(110, 70));
        studentTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(studentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 812, Short.MAX_VALUE))
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addComponent(studentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        studentBar.add(studentPanel);

        tabbPane.addTab("Students", new javax.swing.ImageIcon(getClass().getResource("/resources/img/graduated64.png")), studentBar); // NOI18N

        schoolBar.setRollover(true);

        schoolForm.setText("<html><center>School<br>Table</center></html>");
        schoolForm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        schoolForm.setMaximumSize(new java.awt.Dimension(110, 70));
        schoolForm.setMinimumSize(new java.awt.Dimension(110, 70));
        schoolForm.setPreferredSize(new java.awt.Dimension(110, 70));
        schoolForm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        gradeButton.setText("<html><center>Grade<br>Table</center></html>");
        gradeButton.setFocusable(false);
        gradeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gradeButton.setMaximumSize(new java.awt.Dimension(110, 70));
        gradeButton.setMinimumSize(new java.awt.Dimension(110, 70));
        gradeButton.setPreferredSize(new java.awt.Dimension(110, 70));
        gradeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout schoolPanelLayout = new javax.swing.GroupLayout(schoolPanel);
        schoolPanel.setLayout(schoolPanelLayout);
        schoolPanelLayout.setHorizontalGroup(
            schoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schoolPanelLayout.createSequentialGroup()
                .addComponent(schoolForm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(gradeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 818, Short.MAX_VALUE))
        );
        schoolPanelLayout.setVerticalGroup(
            schoolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(schoolForm, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(gradeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        schoolBar.add(schoolPanel);

        tabbPane.addTab("Schools", new javax.swing.ImageIcon(getClass().getResource("/resources/img/school64.png")), schoolBar); // NOI18N

        userBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        personTableButton.setText("<html><center>Person<br>Table<center><html>");
        personTableButton.setFocusable(false);
        personTableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        personTableButton.setMaximumSize(new java.awt.Dimension(110, 70));
        personTableButton.setMinimumSize(new java.awt.Dimension(110, 70));
        personTableButton.setPreferredSize(new java.awt.Dimension(110, 70));
        personTableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        userTable.setText("<html><center>User<br>Table</center></html>");
        userTable.setFocusable(false);
        userTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userTable.setMaximumSize(new java.awt.Dimension(110, 70));
        userTable.setMinimumSize(new java.awt.Dimension(110, 70));
        userTable.setPreferredSize(new java.awt.Dimension(110, 70));
        userTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout userPanel2Layout = new javax.swing.GroupLayout(userPanel2);
        userPanel2.setLayout(userPanel2Layout);
        userPanel2Layout.setHorizontalGroup(
            userPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(personTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(userTable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(598, Short.MAX_VALUE))
        );

        userPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {personTableButton, userTable});

        userPanel2Layout.setVerticalGroup(
            userPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(personTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(userTable, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        userPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {personTableButton, userTable});

        userBar.add(userPanel2);

        tabbPane.addTab("Users", new javax.swing.ImageIcon(getClass().getResource("/resources/img/profile64.png")), userBar); // NOI18N

        statisticsBar.setRollover(true);

        topReadBooks.setText("<html><center>Top Read<br>Books</center></html>");
        topReadBooks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topReadBooks.setMaximumSize(new java.awt.Dimension(110, 70));
        topReadBooks.setMinimumSize(new java.awt.Dimension(110, 70));

        topReadStudents.setText("<html><center>Top Reader<br>Students</center></html>");
        topReadStudents.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topReadStudents.setMaximumSize(new java.awt.Dimension(110, 70));
        topReadStudents.setMinimumSize(new java.awt.Dimension(110, 70));

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

        tabbPane.addTab("Statistics", new javax.swing.ImageIcon(getClass().getResource("/resources/img/statistics64.png")), statisticsBar); // NOI18N

        settingsBar.setRollover(true);
        tabbPane.addTab("Settings", new javax.swing.ImageIcon(getClass().getResource("/resources/img/settings64.png")), settingsBar); // NOI18N

        currentUserPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        userLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/enter.png"))); // NOI18N
        userLabel.setToolTipText("Sistemde Aktif Olan Kullnici");
        userLabel.setAlignmentX(0.5F);
        userLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

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

        fileMenu.setText("File");

        closeOperation.setText("Close");
        fileMenu.add(closeOperation);

        topMenuBar.add(fileMenu);

        settingsMenu.setText("Settings");
        settingsMenu.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        databaseMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        databaseMenuItem.setText("Database");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authorTableButton;
    private javax.swing.JToolBar bookBar;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JButton bookTable;
    private javax.swing.JButton bookTypeButton;
    private javax.swing.JButton buttonBasket;
    private javax.swing.JButton buttonBookBorrow;
    private javax.swing.JMenuItem closeOperation;
    private javax.swing.JPanel currentUserPanel;
    private javax.swing.JMenuItem databaseMenuItem;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton gradeButton;
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
    private javax.swing.JPanel studentPanel;
    private javax.swing.JButton studentTable;
    private javax.swing.JTabbedPane tabbPane;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JMenuBar topMenuBar;
    private javax.swing.JButton topReadBooks;
    private javax.swing.JButton topReadStudents;
    private javax.swing.JToolBar userBar;
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

    public void returnLoginForm() {
        SessionTimeCounter.getInstance().setLoginWin(true);
        this.setVisible(false);
        LoginForm.INSTANCE.setVisible(true);
    }

    public JButton getAuthorTableButton() {
        return authorTableButton;
    }

    public void setAuthorTableButton(JButton authorTableButton) {
        this.authorTableButton = authorTableButton;
    }

    public JToolBar getBookBar() {
        return bookBar;
    }

    public void setBookBar(JToolBar bookBar) {
        this.bookBar = bookBar;
    }

    public JPanel getBookPanel() {
        return bookPanel;
    }

    public void setBookPanel(JPanel bookPanel) {
        this.bookPanel = bookPanel;
    }

    public JButton getBookTable() {
        return bookTable;
    }

    public void setBookTable(JButton bookTable) {
        this.bookTable = bookTable;
    }

    public JButton getBookTypeButton() {
        return bookTypeButton;
    }

    public void setBookTypeButton(JButton bookTypeButton) {
        this.bookTypeButton = bookTypeButton;
    }

    public JMenuItem getCloseOperation() {
        return closeOperation;
    }

    public void setCloseOperation(JMenuItem closeOperation) {
        this.closeOperation = closeOperation;
    }

    public JPanel getCurrentUserPanel() {
        return currentUserPanel;
    }

    public void setCurrentUserPanel(JPanel currentUserPanel) {
        this.currentUserPanel = currentUserPanel;
    }

    public JMenuItem getDatabaseMenuItem() {
        return databaseMenuItem;
    }

    public void setDatabaseMenuItem(JMenuItem databaseMenuItem) {
        this.databaseMenuItem = databaseMenuItem;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public JButton getPersonTableButton() {
        return personTableButton;
    }

    public void setPersonTableButton(JButton personTableButton) {
        this.personTableButton = personTableButton;
    }

    public JButton getPublisherButton() {
        return publisherButton;
    }

    public void setPublisherButton(JButton publisherButton) {
        this.publisherButton = publisherButton;
    }

    public JToolBar getSchoolBar() {
        return schoolBar;
    }

    public void setSchoolBar(JToolBar schoolBar) {
        this.schoolBar = schoolBar;
    }

    public JButton getSchoolForm() {
        return schoolForm;
    }

    public void setSchoolForm(JButton schoolForm) {
        this.schoolForm = schoolForm;
    }

    public JPanel getSchoolPanel() {
        return schoolPanel;
    }

    public void setSchoolPanel(JPanel schoolPanel) {
        this.schoolPanel = schoolPanel;
    }

    public JToolBar getSettingsBar() {
        return settingsBar;
    }

    public void setSettingsBar(JToolBar settingsBar) {
        this.settingsBar = settingsBar;
    }

    public JMenu getSettingsMenu() {
        return settingsMenu;
    }

    public void setSettingsMenu(JMenu settingsMenu) {
        this.settingsMenu = settingsMenu;
    }

    public JToolBar getStatisticsBar() {
        return statisticsBar;
    }

    public void setStatisticsBar(JToolBar statisticsBar) {
        this.statisticsBar = statisticsBar;
    }

    public JPanel getStatisticsPanel() {
        return statisticsPanel;
    }

    public void setStatisticsPanel(JPanel statisticsPanel) {
        this.statisticsPanel = statisticsPanel;
    }

    public JToolBar getStudentBar() {
        return studentBar;
    }

    public void setStudentBar(JToolBar studentBar) {
        this.studentBar = studentBar;
    }

    public JPanel getStudentPanel() {
        return studentPanel;
    }

    public void setStudentPanel(JPanel studentPanel) {
        this.studentPanel = studentPanel;
    }

    public JButton getStudentTable() {
        return studentTable;
    }

    public void setStudentTable(JButton studentTable) {
        this.studentTable = studentTable;
    }

    public JTabbedPane getTabbPane() {
        return tabbPane;
    }

    public void setTabbPane(JTabbedPane tabbPane) {
        this.tabbPane = tabbPane;
    }

    public JMenuBar getTopMenuBar() {
        return topMenuBar;
    }

    public void setTopMenuBar(JMenuBar topMenuBar) {
        this.topMenuBar = topMenuBar;
    }

    public JButton getTopReadBooks() {
        return topReadBooks;
    }

    public void setTopReadBooks(JButton topReadBooks) {
        this.topReadBooks = topReadBooks;
    }

    public JButton getTopReadStudents() {
        return topReadStudents;
    }

    public void setTopReadStudents(JButton topReadStudents) {
        this.topReadStudents = topReadStudents;
    }

    public JToolBar getUserBar() {
        return userBar;
    }

    public void setUserBar(JToolBar userBar) {
        this.userBar = userBar;
    }

    public JPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(JPanel userPanel) {
        this.userPanel = userPanel;
    }

    public JPanel getUserPanel2() {
        return userPanel2;
    }

    public void setUserPanel2(JPanel userPanel2) {
        this.userPanel2 = userPanel2;
    }

    public JButton getUserTable() {
        return userTable;
    }

    public void setUserTable(JButton userTable) {
        this.userTable = userTable;
    }

    public JButton getGradeButton() {
        return gradeButton;
    }

    public void setGradeButton(JButton gradeButton) {
        this.gradeButton = gradeButton;
    }

    public JButton getButtonBookBorrow() {
        return buttonBookBorrow;
    }

    public void setButtonBookBorrow(JButton buttonBookBorrow) {
        this.buttonBookBorrow = buttonBookBorrow;
    }

    public JButton getButtonBasket() {
        return buttonBasket;
    }

    public void setButtonBasket(JButton buttonBasket) {
        this.buttonBasket = buttonBasket;
    }   
}