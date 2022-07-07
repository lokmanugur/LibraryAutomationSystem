package com.ugurtech.library.view;
import com.ugurtech.library.persistance.user.UserDaoImpl;
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

public final class MainForm extends MainFrame{
   // private String dPaneimage="/img/MEBLogo.png"; 
    
    private static MainForm mainForm;
    private UserDaoImpl userDao;
   
    private MainForm(){
        initComponents();
        setDesktopPane(desktopPane);
    }
    
    public static MainForm getInstance(){
        if(mainForm == null)
            return mainForm = new MainForm();
        else
            return mainForm;
    }
    public void setUserDao(UserDaoImpl userDao){
        this.userDao = userDao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        userPanel = new javax.swing.JPanel();
        JTabbPane = new javax.swing.JTabbedPane();
        bookBar = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        publisherButton = new javax.swing.JButton();
        authorTableButton = new javax.swing.JButton();
        authorButton = new javax.swing.JButton();
        bookTypeButton = new javax.swing.JButton();
        booksTable = new javax.swing.JButton();
        addBooks = new javax.swing.JButton();
        takenBooksTableButton = new javax.swing.JButton();
        studentBar = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        studentTable = new javax.swing.JButton();
        studentForm = new javax.swing.JButton();
        schoolBar = new javax.swing.JToolBar();
        jPanel3 = new javax.swing.JPanel();
        schoolForm = new javax.swing.JButton();
        kullaniciBar = new javax.swing.JToolBar();
        jPanel5 = new javax.swing.JPanel();
        userForm = new javax.swing.JButton();
        personTableButton = new javax.swing.JButton();
        userDetails = new javax.swing.JButton();
        userTable = new javax.swing.JButton();
        personFormButton = new javax.swing.JButton();
        istatisticBar = new javax.swing.JToolBar();
        jPanel6 = new javax.swing.JPanel();
        topReadingBooks = new javax.swing.JButton();
        istatistic = new javax.swing.JButton();
        araclarBar = new javax.swing.JToolBar();
        jPanel7 = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        closeOperation = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        guiProperties = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenu();
        databaseProperties = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ugur Software and Hardware Technologies");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        userPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JTabbPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JTabbPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTabbPane.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        JTabbPane.setPreferredSize(new java.awt.Dimension(1044, 148));

        bookBar.setRollover(true);

        publisherButton.setText("<html><center>Yayın Evi<br>Tablosu<center><html>");
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

        authorTableButton.setText("<html><center>Yazarlar<br>Tablosu<center><html>");
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

        authorButton.setText("<html><center>Yazar Kayıt<br>Formu<center><html>");
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

        bookTypeButton.setText("<html><center>Kitap Türü<br>Tablosu<center><html>");
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

        booksTable.setText("<html><center>Kitaplar<br>Tablosu<center><html>");
        booksTable.setFocusable(false);
        booksTable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        booksTable.setMaximumSize(new java.awt.Dimension(110, 70));
        booksTable.setMinimumSize(new java.awt.Dimension(110, 70));
        booksTable.setPreferredSize(new java.awt.Dimension(110, 70));
        booksTable.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        booksTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksTableActionPerformed(evt);
            }
        });

        addBooks.setText("<html><center>Kitap Kayıt<br> Formu</center></html>");
        addBooks.setFocusable(false);
        addBooks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBooks.setMaximumSize(new java.awt.Dimension(110, 70));
        addBooks.setMinimumSize(new java.awt.Dimension(110, 70));
        addBooks.setPreferredSize(new java.awt.Dimension(110, 70));
        addBooks.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBooksActionPerformed(evt);
            }
        });

        takenBooksTableButton.setText("<html><center>Ödünç Kitaplar<br>Tablosu<center><html>");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(takenBooksTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(addBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(booksTable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addBooks, authorButton, authorTableButton, bookTypeButton, booksTable, publisherButton, takenBooksTableButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(takenBooksTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(addBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(booksTable, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bookTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(authorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(authorTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(publisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addBooks, authorButton, authorTableButton, bookTypeButton, booksTable, publisherButton, takenBooksTableButton});

        bookBar.add(jPanel1);

        JTabbPane.addTab("Kitaplar", new javax.swing.ImageIcon(getClass().getResource("/resources/img/bookshelf64.png")), bookBar); // NOI18N

        studentBar.setRollover(true);

        studentTable.setText("<html><center>Öğrenciler<br>Tablosu</center></html>");
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

        studentForm.setText("<html><center>Öğrenci Kayıt<br>Formu</center></html>");
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(studentForm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(studentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 818, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {studentForm, studentTable});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentForm, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {studentForm, studentTable});

        studentBar.add(jPanel4);

        JTabbPane.addTab("Öğrenciler", new javax.swing.ImageIcon(getClass().getResource("/resources/img/graduated64.png")), studentBar); // NOI18N

        schoolBar.setRollover(true);

        schoolForm.setText("<html><center>Okul Kayıt<br>Formu</center></html>");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(schoolForm, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 928, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(schoolForm, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        schoolBar.add(jPanel3);

        JTabbPane.addTab("Okul", new javax.swing.ImageIcon(getClass().getResource("/resources/img/school64.png")), schoolBar); // NOI18N

        kullaniciBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        userForm.setText("<html><center>Kullanıcı Kayıt<br>Formu</center></html>");
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

        personTableButton.setText("<html><center>Kişiler<br>Tablosu<center><html>");
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

        userDetails.setText("<html><center>Kullanıcı Ayrıntı<br>Bilgileri</center></html>");
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

        userTable.setText("<html><center>Kullanıcılar<br>Tablosu</center></html>");
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

        personFormButton.setText("<html><center>Kişi Ekle<br>Formu<center><html>");
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
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

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {personFormButton, personTableButton, userDetails, userForm, userTable});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(personFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(personTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(userForm, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(userTable, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(userDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {personFormButton, personTableButton, userDetails, userForm, userTable});

        kullaniciBar.add(jPanel5);

        JTabbPane.addTab("Kullanici", new javax.swing.ImageIcon(getClass().getResource("/resources/img/profile64.png")), kullaniciBar); // NOI18N

        istatisticBar.setRollover(true);

        topReadingBooks.setText("<html><center>En Çok<br>Okunan Kitaplar</center></html>");
        topReadingBooks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        topReadingBooks.setMaximumSize(new java.awt.Dimension(110, 70));
        topReadingBooks.setMinimumSize(new java.awt.Dimension(110, 70));
        topReadingBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topReadingBooksActionPerformed(evt);
            }
        });

        istatistic.setText("<html><center>Türe Göre<br>Kitap Sayısı</center></html>");
        istatistic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        istatistic.setMaximumSize(new java.awt.Dimension(110, 70));
        istatistic.setMinimumSize(new java.awt.Dimension(110, 70));
        istatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                istatisticActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(topReadingBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(istatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(818, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {istatistic, topReadingBooks});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(istatistic, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topReadingBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {istatistic, topReadingBooks});

        istatisticBar.add(jPanel6);

        JTabbPane.addTab("İstatistik", new javax.swing.ImageIcon(getClass().getResource("/resources/img/statistics64.png")), istatisticBar); // NOI18N

        araclarBar.setRollover(true);
        JTabbPane.addTab(" Ayarlar ", new javax.swing.ImageIcon(getClass().getResource("/resources/img/settings64.png")), araclarBar); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Date");

        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Time");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel)
                .addGap(18, 18, 18)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addComponent(JTabbPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addComponent(JTabbPane, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JTabbPane.getAccessibleContext().setAccessibleName("Kitaplar");

        fileMenu.setText("Dosya");

        closeOperation.setText("Kapat");
        closeOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeOperationActionPerformed(evt);
            }
        });
        fileMenu.add(closeOperation);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");

        guiProperties.setText("Database");
        guiProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guiPropertiesActionPerformed(evt);
            }
        });
        editMenu.add(guiProperties);

        jMenuBar1.add(editMenu);

        settingsMenu.setText("Araçlar");
        settingsMenu.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        databaseProperties.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        databaseProperties.setText("Database");
        databaseProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databasePropertiesActionPerformed(evt);
            }
        });
        settingsMenu.add(databaseProperties);

        jMenuBar1.add(settingsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
            .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void booksTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksTableActionPerformed
        addDesktopPane(BookSearch.getInstance());
    }//GEN-LAST:event_booksTableActionPerformed
    private void addBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBooksActionPerformed
        addDesktopPane(BookForm.getInstance());
    }//GEN-LAST:event_addBooksActionPerformed
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
    private void databasePropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databasePropertiesActionPerformed
        addDesktopPane(DatabaseUI.getInstance());
    }//GEN-LAST:event_databasePropertiesActionPerformed

    private void topReadingBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topReadingBooksActionPerformed
        //addDesktopPane(UserForm.getInstance());
    }//GEN-LAST:event_topReadingBooksActionPerformed

    private void istatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_istatisticActionPerformed
        //addDesktopPane(UserTableForm.getInstance());
    }//GEN-LAST:event_istatisticActionPerformed

    private void closeOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeOperationActionPerformed
        if(!userDao.isClosed()){
            userDao.closeConnection();
        }
        this.dispose();
        LoginForm.getInstance().dispose();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }//GEN-LAST:event_closeOperationActionPerformed

    private void guiPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guiPropertiesActionPerformed
        
    }//GEN-LAST:event_guiPropertiesActionPerformed

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()){
            this.setVisible(false);
            LoginForm.getInstance().setVisible(true);
            evt.consume();
        }
    }//GEN-LAST:event_userLabelMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.println("sdfasdf");
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
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbPane;
    private javax.swing.JButton addBooks;
    private javax.swing.JToolBar araclarBar;
    private javax.swing.JButton authorButton;
    private javax.swing.JButton authorTableButton;
    private javax.swing.JToolBar bookBar;
    private javax.swing.JButton bookTypeButton;
    private javax.swing.JButton booksTable;
    private javax.swing.JMenuItem closeOperation;
    private javax.swing.JMenuItem databaseProperties;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem guiProperties;
    private javax.swing.JButton istatistic;
    private javax.swing.JToolBar istatisticBar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToolBar kullaniciBar;
    private javax.swing.JButton personFormButton;
    private javax.swing.JButton personTableButton;
    private javax.swing.JButton publisherButton;
    private javax.swing.JToolBar schoolBar;
    private javax.swing.JButton schoolForm;
    private javax.swing.JMenu settingsMenu;
    private javax.swing.JToolBar studentBar;
    private javax.swing.JButton studentForm;
    private javax.swing.JButton studentTable;
    private javax.swing.JButton takenBooksTableButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JButton topReadingBooks;
    private javax.swing.JButton userDetails;
    private javax.swing.JButton userForm;
    private javax.swing.JLabel userLabel;
    private javax.swing.JPanel userPanel;
    private javax.swing.JButton userTable;
    // End of variables declaration//GEN-END:variables

    public JLabel getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(JLabel userLabel) {
        this.userLabel = userLabel;
    }
     
}