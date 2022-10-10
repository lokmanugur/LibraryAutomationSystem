/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.borrow;

import com.ugurtech.library.ab_application.af_lib.sql.DbUtils;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ac_dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.ad_model.BookModel;
import com.ugurtech.library.ad_model.PersonBookModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BorrowDaoImpl extends DaoAbstract implements BorrowDao {

    public static String PERSON_BOOK_ADD_QUERY = "INSERT INTO personbook (personid,bookid,startdate,deadline) VALUES(?,?,?,?);";
    public static String BORROW_SEARCH_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.Book.bookid) + ","
            + columnNameAsColumnTitle(Tables.Book.isbn) + ","
            + columnNameAsColumnTitle(Tables.Book.bookname) + ","
            + columnNameAsColumnTitle(Tables.Publisher.publishername) + ","
            + columnNameAsColumnTitle(Tables.Book.publishdate) + ","
            + "group_concat(DISTINCT booktype.typename) as " + columnTitleWithPrime(Tables.BookType.typename) + ","
            + "group_concat(DISTINCT (person.firstname || ' ' || person.lastname)) as " + columnTitleWithPrime(Tables.Author.name) + ","
            + columnNameAsColumnTitle(Tables.Book.stock) + ","
            + columnNameAsColumnTitle(Tables.Book.lastupdate) + " "
            + "FROM book "
            + "left join booktypebook on book.bookid=booktypebook.bookid "
            + "left join booktype on booktypebook.booktypeid = booktype.booktypeid "
            + "left join publisher on book.publisherid=publisher.publisherid "
            + "left join bookauthor on book.bookid=bookauthor.bookid "
            + "left join author on bookauthor.authorid=author.authorid "
            + "left join person on author.personid=person.personid ";

    @Override
    public TableModel search(int dateId, long startDate, long endDate, int optionsId, String searchText) {
        String query = "";
        query += BORROW_SEARCH_QUERY;
        query += " WHERE ";
        query += "  (" + Tables.Book.bookid + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Book.isbn + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Book.bookname + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Publisher.publishername + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.BookType.typename + " LIKE '" + searchText + "%'";
        query += ")";
        if (dateId == 1) {
            query += " AND " + Tables.Book.publishdate + " BETWEEN " + startDate + " AND " + endDate;
        } else if (dateId == 2) {
            query += " AND " + Tables.Book.lastupdate + " BETWEEN " + startDate + " AND " + endDate;
        }
        query += " GROUP BY book.bookid";
        ResultSet rs = createResultSet(query);
        TableModel tableModel = DbUtils.resultSetToTableModel(rs,
                columnTitleWithoutPrime("book.publishdate"),
                columnTitleWithoutPrime("book.lastupdate"));
        return tableModel;
    }

    @Override
    public void add(PersonBookModel personBookModel) {
        beginTransection();
        String query = PERSON_BOOK_ADD_QUERY;
        PreparedStatement preparedStatement = createPrepareStatement(query);
        try {
            preparedStatement.setInt(1, personBookModel.getStudentModel().getPersonId());
            preparedStatement.setLong(3, personBookModel.getStartDate());
            preparedStatement.setLong(4, personBookModel.getDeadLine());
            for (BookModel bbm : personBookModel.getBookModel()) {
                for (int amount = 1; amount <= bbm.getStock(); amount++) {
                    preparedStatement.setInt(2, bbm.getBookId());
                    preparedStatement.executeUpdate();
                }
                updateStock(bbm.getBookId(), getStock(bbm.getBookId()), bbm.getStock());
            }
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, "Add person book query error", BorrowDaoImpl.class.getName());
        }
        commit();
    }

    private int getStock(int bookId) {
        ResultSet rs = createResultSet("SELECT stock FROM book WHERE bookid=" + bookId);
        try {
            return rs.getInt("stock");
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, "Get stock error", BorrowDaoImpl.class.getName());
            return -1;
        }

    }

    private void updateStock(int bookid, int databaseStock, int amountOfGotenBook) {
        PreparedStatement preparedStatement = createPrepareStatement("UPDATE book SET stock=? WHERE bookid=?");
        try {
            preparedStatement.setInt(1, databaseStock - amountOfGotenBook);
            preparedStatement.setInt(2, bookid);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, "Book update stock error ", BorrowDaoImpl.class.getName());
        }
    }
}
