/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.book;

import com.ugurtech.library.persistance.DaoAbstract;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.model.BookTypeModel;
import com.ugurtech.library.model.PublisherModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugur
 *
 */
public class BookDaoImpl extends DaoAbstract implements BookDao {

    private static final String BOOK_SERACH_QUERY = "SELECT b.bookid as Kitap_No, b.isbn as ISBN,"
            + "b.bookname as Kitap_Adı,"
            + "pub.publishername as Yayın_Evi,"
            + "b.pressdate as Yayınlama_Tarihi,"
            + "b.lastupdate as Son_Güncelleme_Tarihi,"
            + "group_concat(DISTINCT bt.typename) Kitap_Türü,group_concat(DISTINCT (p.firstname || ' ' || p.lastname)) Kitap_Yazarı,"
            + "CASE WHEN b.bookborrowed=0 THEN 'Hayır' ELSE 'Evet' END as Ödünç_Verildimi "
            + "FROM book b "
            + "left join booktypebook btb on b.bookid=btb.bookid "
            + "left join booktype bt on btb.booktypeid = bt.booktypeid "
            + "left join publisher pub on b.publisherid=pub.publisherid "
            + "left join bookauthor ba on b.bookid=ba.bookid "
            + "left join author a on ba.authorid=a.authorid "
            + "left join person p on a.personid=p.personid ";
    private static final String INSERT_BOOK_AUTHOR = "INSERT INTO bookauthor(isbn,authorid) VALUES(?,?)";
    private static final String INSERT_BOOKTYPE_BOOK = "INSERT INTO booktypebook(isbn,booktypeid) VALUES(?,?)";
    private static final String INSERT_BOOK = "INSERT INTO book (isbn,sysuserid,publisherid,bookname,pressdate) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_BOOK = "UPDATE book SET deleted=? WHERE isbn=?";
    private static final String BOOK_TYPE = "SELECT booktypeid,typename,lastupdate FROM booktype";
    private static final String AUTHOR = "SELECT a.authorid,p.firstname,p.lastname FROM author a,person p  WHERE a.personid=p.personid";
    private static final String PUBLISHER = "SELECT * FROM publisher";
    
    
    

    private List<BookTypeModel> bookTypeList;
    private List<AuthorModel> authorModelList;
    private List<PublisherModel> publisherModelList;

    private BookTypeModel booksTypeModel;
    private AuthorModel authorModel;
    private PublisherModel publisherModel;
    private BookModel booksModel;

    public BookDaoImpl() {
    }

    @Override
    public ResultSet findBooksByFilters(Map<String, String> map) {
        StringBuilder query = new StringBuilder(BOOK_SERACH_QUERY);
        query.append("WHERE ");
        query.append("b.deleted=0 ");
        fillFilters(query, map);
        query.append("GROUP BY b.bookid ");
        return createResultSet(query.toString());
    }

    @Override
    public BookModel getBook(int bookId) {
        booksModel = new BookModel();
        
        return booksModel;
    }

    @Override
    public void addBook(BookModel book) {
        PreparedStatement preparedStatement = createPrepareStatement(INSERT_BOOK);
        try {
            preparedStatement.setLong(1, book.getIsbn());
            preparedStatement.setInt(2, book.getSysuserId());
            preparedStatement.setInt(3, book.getBublisherId());
            preparedStatement.setString(4, book.getBookName());
            preparedStatement.setLong(5, book.getPressDate());
            int effactedRow = preparedStatement.executeUpdate();

            preparedStatement = createPrepareStatement(INSERT_BOOK_AUTHOR);
            for (AuthorModel am : book.getAuthor()) {
                preparedStatement.setLong(1, book.getIsbn());
                preparedStatement.setInt(2, am.getAuthorId());
                preparedStatement.executeUpdate();
            }
            preparedStatement = createPrepareStatement(INSERT_BOOKTYPE_BOOK);
            for (BookTypeModel btm : book.getBookType()) {
                preparedStatement.setLong(1, book.getIsbn());
                preparedStatement.setInt(2, btm.getBookTypeId());
                preparedStatement.executeUpdate();
            }
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateBook(BookModel book) {

    }

    @Override
    public void deleteBook(int bookid) {
        PreparedStatement preparedStatement = createPrepareStatement(DELETE_BOOK);
        try {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, bookid);
            int affectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(affectedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Delete Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<BookTypeModel> getAllBooksType() {
        bookTypeList = new ArrayList<>();
        ResultSet resultSet = createResultSet(BOOK_TYPE);
        try {
            while (resultSet.next()) {
                booksTypeModel = new BookTypeModel();
                booksTypeModel.setBookTypeId(resultSet.getInt("booktypeid"));
                booksTypeModel.setTypeName(resultSet.getString("typename"));
                booksTypeModel.setLastUpdate(resultSet.getDate("lastupdate"));
                bookTypeList.add(booksTypeModel);
            }
            return bookTypeList;
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Search Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<AuthorModel> allAuthors() {
        authorModelList = new ArrayList<>();
        ResultSet resultSet = createResultSet(AUTHOR);
        try {
            while (resultSet.next()) {
                authorModel = new AuthorModel();
                authorModel.setAuthorId(resultSet.getInt("authorid"));
                authorModel.setFirstName(resultSet.getString("firstname"));
                authorModel.setLastName(resultSet.getString("lastname"));
                authorModelList.add(authorModel);
            }
            return authorModelList;
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Search Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<PublisherModel> allPublisher() {
        publisherModelList = new ArrayList<>();
        ResultSet resultSet = createResultSet(PUBLISHER);
        try {
            while (resultSet.next()) {
                publisherModel = new PublisherModel();
                publisherModel.setPublisherId(resultSet.getInt("publisherid"));
                publisherModel.setPublisherName(resultSet.getString("publishername"));
                publisherModelList.add(publisherModel);
            }
            return publisherModelList;
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Search Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void fillFilters(StringBuilder query, Map<String, String> map) {
        if (!map.isEmpty()) {
            if (map.containsKey("isbn")) {
                query.append("AND ");
                query.append("b.isbn ");
                query.append("LIKE '");
                query.append(map.get("isbn"));
                query.append("%' ");
            }

            if (map.containsKey("bookName")) {
                query.append("AND ");
                query.append("b.bookname ");
                query.append("LIKE '%");
                query.append(map.get("bookName"));
                query.append("%' ");
            }

            if (map.containsKey("authorName")) {
                query.append("AND ");
                query.append("(p.firstname || ' ' || p.lastname) ");
                query.append("LIKE '%");
                query.append(map.get("authorName"));
                query.append("%' ");
            }

            if (map.containsKey("bookType")) {
                query.append("AND ");
                query.append("bt.typename ");
                query.append("LIKE '%");
                query.append(map.get("bookType"));
                query.append("%' ");
            }
        }
    }
}
