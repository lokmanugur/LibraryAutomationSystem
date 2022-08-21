/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistancev2.book;

import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.modelv2.BookModel;
import com.ugurtech.library.modelv2.BookTypeModel;
import com.ugurtech.library.persistancev2.DaoAbstract;
import com.ugurtech.library.service.validation.UserInfoMessages;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookDaoImpl extends DaoAbstract implements BookDao {

    public static final String BOOK_SERACH_QUERY = "SELECT "
            + "b.bookid as Kitap_No,"
            + "b.isbn as ISBN,"
            + "b.bookname as Kitap_Adı,"
            + "pub.publishername as Yayın_Evi,"
            + "b.pressdate as Yayınlama_Tarihi,"
            + "b.lastupdate as Son_Güncelleme_Tarihi,"
            + "group_concat(DISTINCT bt.typename) Kitap_Türü,"
            + "group_concat(DISTINCT (p.firstname || ' ' || p.lastname)) Kitap_Yazarı,"
            + "CASE WHEN b.bookborrowed=0 THEN 'Hayır' ELSE 'Evet' END as Ödünç_Verildimi "
            + "FROM book b "
            + "left join booktypebook btb on b.bookid=btb.bookid "
            + "left join booktype bt on btb.booktypeid = bt.booktypeid "
            + "left join publisher pub on b.publisherid=pub.publisherid "
            + "left join bookauthor ba on b.bookid=ba.bookid "
            + "left join author a on ba.authorid=a.authorid "
            + "left join person p on a.personid=p.personid ";
    public static final String INSERT_BOOK_AUTHOR = "INSERT INTO bookauthor(bookid,authorid) VALUES(?,?)";
    public static final String INSERT_BOOKTYPE_BOOK = "INSERT INTO booktypebook(bookid,booktypeid) VALUES(?,?)";
    public static final String INSERT_BOOK = "INSERT INTO book (isbn,sysuserid,publisherid,bookname,pressdate,quantity,shelf) VALUES (?,?,?,?,?,?,?)";
    public static final String DELETE_BOOK = "UPDATE book SET deleted=? WHERE isbn=?";

    private BookModel bookModel;

    @Override
    public List<BookModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BookModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(BookModel book) {
        PreparedStatement preparedStatement = createPrepareStatement(INSERT_BOOK);
        try {
            preparedStatement.setLong(1, book.getIsbn());
            preparedStatement.setInt(2, book.getSysuserId());
            preparedStatement.setInt(3, book.getBublisherModel().getPublisherId());
            preparedStatement.setString(4, book.getBookName());
            preparedStatement.setLong(5, book.getPressDate());
            preparedStatement.setInt(6, book.getQuantity());
            preparedStatement.setString(7, book.getShelf());
            int effactedRow = preparedStatement.executeUpdate();
           int generatedKey = preparedStatement.getGeneratedKeys().getInt(1);

            preparedStatement = createPrepareStatement(INSERT_BOOK_AUTHOR);
            for (AuthorModel am : book.getAuthor()) {
                preparedStatement.setLong(1, generatedKey);
                preparedStatement.setInt(2, am.getAuthorId());
                preparedStatement.executeUpdate();
            }
            preparedStatement = createPrepareStatement(INSERT_BOOKTYPE_BOOK);
            for (BookTypeModel btm : book.getBookType()) {
                preparedStatement.setLong(1, generatedKey);
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
    public void update(BookModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BookModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
