/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.borrow;

import com.ugurtech.library.ab_application.af_lib.sql.DbUtils;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ac_dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.ad_model.BookBorrowModel;
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

    public static String PERSON_BOOK_ADD_QUERY = "INSERT INTO bookperson (personid,bookid,startdate,deadline,finishdate) VALUES(?,?,?,?,?);";
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
    public TableModel search(int dateId, long startDate, long endDate, String searchText) {
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
        String query = "BEGIN TRANSACTION;" + PERSON_BOOK_ADD_QUERY;
        PreparedStatement preparedStatement = createPrepareStatement(query);
        try {
            preparedStatement.setInt(1, personBookModel.getPersonId());
            preparedStatement.setLong(3, personBookModel.getStartDate());
            preparedStatement.setLong(4, personBookModel.getDeadLine());
            preparedStatement.setLong(5, personBookModel.getFinishDate());
            for (BookBorrowModel bbm : personBookModel.getBookBorrowModel()) {
                for (int amount=0;amount<personBookModel.getAmount();amount++ ) {
                    preparedStatement.setInt(2, bbm.getBookId());
                    preparedStatement.executeUpdate();
                }

            }
        } catch (SQLException ex) {
            try {
                preparedStatement = createPrepareStatement("ROLLBACK;");
                preparedStatement.executeUpdate();
                getLogger(ex, "Add person book query error", BorrowDaoImpl.class.getName());
            } catch (SQLException ex1) {
                getLogger(ex, "Add Personbook Transection error", BorrowDaoImpl.class.getName());
            }
        }
        try {
            preparedStatement = createPrepareStatement("COMMIT;");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            getLogger(ex, "Add Personbook Commit error", BorrowDaoImpl.class.getName());
        }
    }
}
