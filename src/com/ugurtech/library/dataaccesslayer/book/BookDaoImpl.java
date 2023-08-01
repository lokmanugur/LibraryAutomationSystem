/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package com.ugurtech.library.dataaccesslayer.book;

import resources.lib.sql.DbUtils;
import com.ugurtech.library.model.AuthorModel;
import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.model.BookTypeModel;
import com.ugurtech.library.dataaccesslayer.DaoAbstract;
import resources.lib.validation.UserInfoMessages;
import com.ugurtech.library.dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.model.PublisherModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * 
 */
public class BookDaoImpl extends DaoAbstract implements BookDao {

    public static final String BOOK_SERACH_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.Book.bookid) + ","
            + columnNameAsColumnTitle(Tables.Book.isbn) + ","
            + columnNameAsColumnTitle(Tables.Book.bookname) + ","
            + columnNameAsColumnTitle(Tables.Publisher.publishername) + ","
            + columnNameAsColumnTitle(Tables.Book.publishdate) + ","
            + "group_concat(DISTINCT booktype.typename) as " + columnTitleWithPrime(Tables.BookType.typename) + ","
            + "group_concat(DISTINCT (person.firstname || ' ' || person.lastname)) as " + columnTitleWithPrime(Tables.Author.name) + ","
            + columnNameAsColumnTitle(Tables.Book.pages) + ","
            + columnNameAsColumnTitle(Tables.Book.stock) + ","
            + columnNameAsColumnTitle(Tables.Book.quantity) + ","
            + columnNameAsColumnTitle(Tables.Book.lastupdate) + " "
            + "FROM book "
            + "left join booktypebook on book.bookid=booktypebook.bookid "
            + "left join booktype on booktypebook.booktypeid = booktype.booktypeid "
            + "left join publisher on book.publisherid=publisher.publisherid "
            + "left join bookauthor on book.bookid=bookauthor.bookid "
            + "left join author on bookauthor.authorid=author.authorid "
            + "left join person on author.personid=person.personid ";

    public static final String INSERT_BOOK_AUTHOR = "INSERT INTO bookauthor(bookid,authorid) VALUES(?,?)";
    public static final String INSERT_BOOKTYPE_BOOK = "INSERT INTO booktypebook(bookid,booktypeid) VALUES(?,?)";
    public static final String INSERT_BOOK = "INSERT INTO book (isbn,sysuserid,publisherid,bookname,publishdate,lastupdate,pages,quantity,stock,shelf) VALUES (?,?,?,?,?,?,?,?,?,?)";

    public static final String CHECK_BOOK_BORROW = "SELECT bookid FROM personbook WHERE finishdate=null AND bookid=?";

    public static final String SEARCH_BOOK_QUERY = "SELECT bookid FROM book ";

    public static final String DELETE_BOOK_BOOKTYPE = "DELETE FROM booktypebook WHERE bookid=?";
    public static final String DELETE_BOOK_AUTHOR = "DELETE FROM bookauthor WHERE bookid=?";
    public static final String DELETE_BOOK = "DELETE FROM book WHERE bookid=?";

    public static final String UPDATE_BOOK = "UPDATE book SET isbn=?,sysuserid=?,publisherid=?,bookname=?,publishdate=?,lastupdate=?,pages=?,quantity=?,stock=?,shelf=? WHERE bookid=?";
    public static final String UPDATE_BOOK_AUTHOR = "UPDATE bookauthor SET authorid=? WHERE bookid=?";
    public static final String UPDATE_BOOKTYPE_BOOK = "UPDATE booktypebook SET booktypeid=? WHERE bookid=?";
    public static final String SEARCH_ISBN_QUERY = "SELECT quantity,stock FROM book WHERE isbn=";

    private final StringBuilder query;

    public BookDaoImpl() {
        this.query = new StringBuilder();
    }

    private boolean isIsbn(BookModel book) {
        try {
            ResultSet rs = createResultSet(SEARCH_ISBN_QUERY + book.getIsbn());
            if (rs.next()) {
                int quantity = rs.getInt("quantity");
                int stock = rs.getInt("stock");

                PreparedStatement preparedStatement = createPrepareStatement("UPDATE book SET quantity=?,stock=? WHERE isbn=?");
                preparedStatement.setInt(1, book.getQuantity() + quantity);
                preparedStatement.setInt(2, book.getStock() + stock);
                preparedStatement.setLong(3, book.getIsbn());
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            getLogger(ex, "Search Isbn error", BookDaoImpl.class.getName());
        }
        return false;
    }

    @Override
    public TableModel search(String srch, int selInd, long firstD, long lastD) {
        query.setLength(0);
        query.append(BOOK_SERACH_QUERY);
        query.append(" WHERE ");
        query.append("  (").append(Tables.Book.bookid).append(" LIKE '").append(srch).append("%'");
        query.append(" OR ").append(Tables.Book.isbn).append(" LIKE '").append(srch).append("%'");
        query.append(" OR ").append(Tables.Book.bookname).append(" LIKE '").append(srch).append("%'");
        query.append(" OR ").append(Tables.Publisher.publishername).append(" LIKE '").append(srch).append("%'");
        query.append(" OR ").append(Tables.BookType.typename).append(" LIKE '").append(srch).append("%'");
        query.append(")");
        if (selInd == 1) {
            query.append(" AND ").append(Tables.Book.publishdate).append(" BETWEEN ").append(firstD).append(" AND ").append(lastD);
        } else if (selInd == 2) {
            query.append(" AND ").append(Tables.Book.lastupdate).append(" BETWEEN ").append(firstD).append(" AND ").append(lastD);
        }
        query.append(" GROUP BY book.bookid");
        ResultSet rs = createResultSet(query.toString());
        TableModel tableModel = DbUtils.resultSetToTableModel(rs, columnTitleWithOutPrime("book.publishdate"), columnTitleWithOutPrime("book.lastupdate"));
        return tableModel;
    }

    @Override
    public List<BookModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(BookModel book) {
        if (isIsbn(book)) {
        } else {
            beginTransection();
            PreparedStatement preparedStatement = createPrepareStatement(INSERT_BOOK);
            try {
                preparedStatement.setLong(1, book.getIsbn());
                preparedStatement.setInt(2, book.getSysuserId());
                preparedStatement.setInt(3, book.getPublisherModel().getPublisherId());
                preparedStatement.setString(4, book.getBookName());
                preparedStatement.setLong(5, book.getPressDate());
                preparedStatement.setLong(6, new Date().getTime());
                preparedStatement.setInt(7, book.getPageNumbber());
                preparedStatement.setInt(8, book.getQuantity());
                preparedStatement.setInt(9, book.getStock());
                preparedStatement.setString(10, book.getShelf());
                preparedStatement.executeUpdate();
                int generatedKey = preparedStatement.getGeneratedKeys().getInt(1);
                addAuthorAndBookType(book, generatedKey, preparedStatement);
                
            } catch (SQLException ex) {
                rollBack();
                getLogger(ex, "Add book error", BookDaoImpl.class.getName());
            }
            commit();
            UserInfoMessages.getInstance().insertMessage();
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
            rollBack();
            getLogger(ex, "Add Author and Booktype error", BookDaoImpl.class.getName());
        }

    }

    @Override
    public void update(BookModel book) {
        beginTransection();
        int quantity = 0;
        int stock = 0;
            PreparedStatement preparedStatement = createPrepareStatement(UPDATE_BOOK);
            try {
            ResultSet rs = createResultSet(SEARCH_ISBN_QUERY + book.getIsbn());
            if (rs.next()) {
                quantity = rs.getInt("quantity");
                stock = rs.getInt("stock");
            }
                preparedStatement.setLong(1, book.getIsbn());
                preparedStatement.setInt(2, book.getSysuserId());
                preparedStatement.setInt(3, book.getPublisherModel().getPublisherId());
                preparedStatement.setString(4, book.getBookName());
                preparedStatement.setLong(5, book.getPressDate());
                preparedStatement.setLong(6, new Date().getTime());
                preparedStatement.setInt(7, book.getPageNumbber());
                preparedStatement.setInt(8, book.getQuantity());
                preparedStatement.setInt(9, book.getQuantity()-(quantity-stock));
                preparedStatement.setString(10, book.getShelf());
                preparedStatement.setInt(11, book.getBookId());
                int effactedRow = preparedStatement.executeUpdate();

                deleteAuthorAndBookType(book, preparedStatement);
                addAuthorAndBookType(book, book.getBookId(), preparedStatement);
                UserInfoMessages.getInstance().insertMessage(effactedRow);
            } catch (SQLException ex) {
                rollBack();
                getLogger(ex, "Update book error", BookDaoImpl.class.getName());
            }
            commit();
        }

        @Override
        public void delete(BookModel book) {
        beginTransection();
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
                rollBack();
                getLogger(ex, "Delete book error", BookDaoImpl.class.getName());
            }
            commit();
        }

    

    private int deleteAuthorAndBookType(BookModel book, PreparedStatement preparedStatement) {
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
            rollBack();
            getLogger(ex, "Delete Author And Book error", BookDaoImpl.class.getName());
        }
        return effactedRow;
    }

    @Override
    public BookModel get(int id) {
        List<AuthorModel> authorList = new ArrayList<>();
        List<BookTypeModel> bookTypeList = new ArrayList<>();
        BookModel bookModel = new BookModel();
        ResultSet resultSet = createResultSet("SELECT "
                + "book.bookid,"
                + "book.isbn,"
                + "book.bookname,"
                + "book.publishdate,"
                + "book.pages,"
                + "book.quantity,"
                + "book.shelf,"
                + "publisher.publisherid,"
                + "publisher.publishername "
                + "FROM book left join publisher on book.publisherid=publisher.publisherid "
                + "WHERE book.bookid=" + String.valueOf(id));
        try {
            PublisherModel publisherModel = new PublisherModel();
            if (resultSet.next()) {
                bookModel.setBookId(resultSet.getInt(1));
                bookModel.setIsbn(resultSet.getLong(2));
                bookModel.setBookName(resultSet.getString(3));
                bookModel.setPressDate(resultSet.getLong(4));
                bookModel.setPageNumbber(resultSet.getInt(5));
                bookModel.setQuantity(resultSet.getInt(6));
                bookModel.setShelf(resultSet.getString(7));
                publisherModel.setPublisherId(resultSet.getInt(8));
                publisherModel.setPublisherName(resultSet.getString(9));
            }
            bookModel.setPublisherModel(publisherModel);
        } catch (SQLException ex) {
            getLogger(ex, "Get book error", BookDaoImpl.class.getName());
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
            getLogger(ex, "Get book error", BookDaoImpl.class.getName());
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
            getLogger(ex, "BookType error", BookDaoImpl.class.getName());
        }

        return bookModel;
    }

}
