/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.book;

import com.ugurtech.library.ab_application.af_lib.sql.DbUtils;
import com.ugurtech.library.ad_model.AuthorModel;
import com.ugurtech.library.ad_model.BookModel;
import com.ugurtech.library.ad_model.BookTypeModel;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ad_model.PublisherModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookDaoImpl extends DaoAbstract implements BookDao {

    public static final String BOOK_SERACH_QUERY = "SELECT "
            + getTableTitle(TableNames.book + ".bookid") + ","
            + getTableTitle(TableNames.book + ".isbn") + ","
            + getTableTitle(TableNames.book + ".bookname") + ","
            + getTableTitle(TableNames.publisher + ".publishername") + ","
            + getTableTitle(TableNames.book + ".publishdate") + ","
            + getTableTitle(TableNames.book + ".lastupdate") + ","
            + "group_concat(DISTINCT booktype.typename) as " + setLanguage("booktype.name") + ","
            + "group_concat(DISTINCT (person.firstname || ' ' || person.lastname)) as " + setLanguage("author.name") + ","
            + "CASE WHEN book.bookborrowed=0 THEN '" + setLanguage("bookborrowed.no") + "' "
            + "WHEN book.bookborrowed=1 THEN '" + setLanguage("bookborrowed.yes") + "' "
            + "END as " + setLanguage("book.bookborrowed") + " "
            + "FROM book "
            + "left join booktypebook on book.bookid=booktypebook.bookid "
            + "left join booktype on booktypebook.booktypeid = booktype.booktypeid "
            + "left join publisher on book.publisherid=publisher.publisherid "
            + "left join bookauthor on book.bookid=bookauthor.bookid "
            + "left join author on bookauthor.authorid=author.authorid "
            + "left join person on author.personid=person.personid ";

    public static final String INSERT_BOOK_AUTHOR = "INSERT INTO bookauthor(bookid,authorid) VALUES(?,?)";
    public static final String INSERT_BOOKTYPE_BOOK = "INSERT INTO booktypebook(bookid,booktypeid) VALUES(?,?)";
    public static final String INSERT_BOOK = "INSERT INTO book (isbn,sysuserid,publisherid,bookname,publishdate,lastupdate,quantity,shelf) VALUES (?,?,?,?,?,?,?,?)";

    public static final String CHECK_BOOK_BORROW = "SELECT bookid FROM personbook WHERE finishdate=null AND bookid=?";

    public static final String SEARCH_BOOK_QUERY = "SELECT bookid FROM book ";

    public static final String DELETE_BOOK_BOOKTYPE = "DELETE FROM booktypebook WHERE bookid=?";
    public static final String DELETE_BOOK_AUTHOR = "DELETE FROM bookauthor WHERE bookid=?";
    public static final String DELETE_BOOK = "DELETE FROM book WHERE bookid=?";

    public static final String UPDATE_BOOK = "UPDATE book SET isbn=?,publisherid=?,sysuserid=?,bookname=?,publishdate=?,lastupdate=?,quantity=?,shelf=? WHERE bookid=?";
    public static final String UPDATE_BOOK_AUTHOR = "UPDATE bookauthor SET authorid=? WHERE bookid=?";
    public static final String UPDATE_BOOKTYPE_BOOK = "UPDATE booktypebook SET booktypeid=? WHERE bookid=?";

    private final StringBuilder query;

    public BookDaoImpl() {
        this.query = new StringBuilder();
    }

    @Override
    public TableModel search(String srch, int selInd, long firstD, long lastD) {
        query.setLength(0);
        query.append(BOOK_SERACH_QUERY);
        query.append(" WHERE ");
        query.append("  (").append(setLanguage(TableNames.book + ".bookid")).append(" LIKE '").append(srch).append("%'");
        query.append(" OR ").append(setLanguage(TableNames.book + ".isbn")).append(" LIKE '").append(srch).append("%'");
        query.append(" OR ").append(setLanguage(TableNames.book + ".bookname")).append(" LIKE '").append(srch).append("%'");
        query.append(" OR ").append(setLanguage(TableNames.publisher + ".publishername")).append(" LIKE '").append(srch).append("%'");
        query.append(")");
        if (selInd == 1) {
            query.append(" AND ").append(setLanguage(TableNames.book + ".publishdate")).append(" BETWEEN ").append(firstD).append(" AND ").append(lastD);
        } else if (selInd == 2) {
            query.append(" AND ").append(setLanguage(TableNames.book + ".lastupdate")).append(" BETWEEN ").append(firstD).append(" AND ").append(lastD);
        }
        query.append(" GROUP BY book.bookid");
        ResultSet rs = createResultSet(query.toString());
        TableModel tableModel = DbUtils.resultSetToTableModel(rs, setLanguage("book.publishdate"), setLanguage("book.lastupdate"));
        return tableModel;
    }

    @Override
    public List<BookModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BookModel get(int id) {
        BookModel bookModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, SEARCH_BOOK_QUERY, " WHERE", " bookid="));
        try {
            bookModel = new BookModel();
            while (resultSet.next()) {
                bookModel.setBookId(resultSet.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bookModel;
    }

    @Override
    public void add(BookModel book) {
        PreparedStatement preparedStatement = createPrepareStatement(INSERT_BOOK);
        try {
            preparedStatement.setLong(1, book.getIsbn());
            preparedStatement.setInt(2, book.getSysuserId());
            preparedStatement.setInt(3, book.getPublisherModel().getPublisherId());
            preparedStatement.setString(4, book.getBookName());
            preparedStatement.setLong(5, book.getPressDate());
            preparedStatement.setLong(6, new Date().getTime());
            preparedStatement.setInt(7, book.getQuantity());
            preparedStatement.setString(8, book.getShelf());
            int effactedRow = preparedStatement.executeUpdate();
            int generatedKey = preparedStatement.getGeneratedKeys().getInt(1);
            addAuthorAndBookType(book, generatedKey, preparedStatement);
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addAuthorAndBookType(BookModel book, int id, PreparedStatement preparedStatement) {
        preparedStatement = createPrepareStatement(INSERT_BOOK_AUTHOR);
        try {
            for (AuthorModel am : book.getAuthor()) {
                preparedStatement.setLong(1, id);
                preparedStatement.setInt(2, am.getAuthorId());
                preparedStatement.executeUpdate();
            }
            preparedStatement = createPrepareStatement(INSERT_BOOKTYPE_BOOK);
            for (BookTypeModel btm : book.getBookType()) {
                preparedStatement.setLong(1, id);
                preparedStatement.setInt(2, btm.getBookTypeId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(BookModel book) {
        PreparedStatement preparedStatement = createPrepareStatement(UPDATE_BOOK);
        try {
            preparedStatement.setLong(1, book.getIsbn());
            preparedStatement.setInt(3, book.getPublisherModel().getPublisherId());
            preparedStatement.setInt(2, book.getSysuserId());
            preparedStatement.setString(4, book.getBookName());
            preparedStatement.setLong(5, book.getPressDate());
            preparedStatement.setLong(6, new Date().getTime());
            preparedStatement.setInt(7, book.getQuantity());
            preparedStatement.setString(8, book.getShelf());
            preparedStatement.setInt(9, book.getBookId());
            int effactedRow = preparedStatement.executeUpdate();

            deleteAuthorAndBookType(book, preparedStatement);
            addAuthorAndBookType(book, book.getBookId(), preparedStatement);
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(BookModel book) {
        PreparedStatement preparedStatement = createPrepareStatement(DELETE_BOOK);
        try {
            int effactedRow;
            effactedRow = deleteAuthorAndBookType(book, preparedStatement);
            
            preparedStatement.setInt(1, book.getBookId());
            if (effactedRow > 1) {
                preparedStatement.executeUpdate();
            }
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Delete Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int deleteAuthorAndBookType(BookModel book, PreparedStatement preparedStatement){
        int effactedRow = 0;
        try {
            preparedStatement = createPrepareStatement(DELETE_BOOK_BOOKTYPE);
            preparedStatement.setInt(1, book.getBookId());
            effactedRow = preparedStatement.executeUpdate();
            
            preparedStatement = createPrepareStatement(DELETE_BOOK_AUTHOR);
            preparedStatement.setInt(1, book.getBookId());

            if (effactedRow > 0) {
                effactedRow += preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Delete Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return effactedRow;
    }
    
    

    @Override
    public BookModel getUpdate(int id) {
        List<AuthorModel> authorList = new ArrayList<>();
        List<BookTypeModel> bookTypeList = new ArrayList<>();
        BookModel bookModel = new BookModel();
        ResultSet resultSetPublisher = createResultSet("SELECT "
                + "book.bookid,"
                + "book.isbn,"
                + "book.bookname,"
                + "book.publishdate,"
                + "book.quantity,"
                + "book.shelf,"
                + "publisher.publisherid,"
                + "publisher.publishername "
                + "FROM book left join publisher on book.publisherid=publisher.publisherid "
                + "WHERE book.bookid=" + String.valueOf(id));
        try {
            PublisherModel publisherModel = new PublisherModel();
            if (resultSetPublisher.next()) {
                bookModel.setBookId(resultSetPublisher.getInt(1));
                bookModel.setIsbn(resultSetPublisher.getLong(2));
                bookModel.setBookName(resultSetPublisher.getString(3));
                bookModel.setPressDate(resultSetPublisher.getLong(4));
                bookModel.setQuantity(resultSetPublisher.getInt(5));
                bookModel.setShelf(resultSetPublisher.getString(6));
                publisherModel.setPublisherId(resultSetPublisher.getInt(7));
                publisherModel.setPublisherName(resultSetPublisher.getString(8));
            }
            bookModel.setPublisherModel(publisherModel);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Author Update Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet resultSetAuthor = createResultSet("SELECT author.authorid,person.firstname,person.lastname "
                + "FROM book "
                + "left join bookauthor on book.bookid=bookauthor.bookid "
                + "left join author on bookauthor.authorid=author.authorid "
                + "left join person on author.personid=person.personid WHERE book.bookid=" + String.valueOf(id));
        try {
            AuthorModel authorModel;
            while (resultSetAuthor.next()) {
                authorModel = new AuthorModel();
                authorModel.setAuthorId(resultSetAuthor.getInt(1));
                authorModel.setFirstName(resultSetAuthor.getString(2));
                authorModel.setLastName(resultSetAuthor.getString(3));
                authorList.add(authorModel);
            }
            bookModel.setAuthor(authorList);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Author Update Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet resultSetBookType = createResultSet("SELECT booktype.booktypeid,booktype.typename "
                + "FROM book "
                + "left join booktypebook on book.bookid=booktypebook.bookid "
                + "left join booktype on booktypebook.booktypeid = booktype.booktypeid "
                + "WHERE book.bookid=" + String.valueOf(id));
        try {
            BookTypeModel bookTypeModel;
            while (resultSetBookType.next()) {
                bookTypeModel = new BookTypeModel();
                bookTypeModel.setBookTypeId(resultSetBookType.getInt(1));
                bookTypeModel.setTypeName(resultSetBookType.getString(2));
                bookTypeList.add(bookTypeModel);
            }
            bookModel.setBooksType(bookTypeList);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Author Update Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bookModel;
    }

}
