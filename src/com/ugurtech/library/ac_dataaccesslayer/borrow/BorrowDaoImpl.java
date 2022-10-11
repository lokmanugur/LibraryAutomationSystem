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
            + columnNameAsColumnTitle(Tables.PersonBook.personbookid) + ","
            + columnNameAsColumnTitle(Tables.Book.bookid) + ","
            + columnNameAsColumnTitle(Tables.Book.isbn) + ","
            + columnNameAsColumnTitle(Tables.Book.bookname) + ","
            + columnNameAsColumnTitle(Tables.Person.firstname) + ","
            + columnNameAsColumnTitle(Tables.Person.lastname) + ","
            + columnNameAsColumnTitle(Tables.Student.studentnumber) + ","
            + columnNameAsColumnTitle(Tables.Person.phone) + ","
            + columnNameAsColumnTitle(Tables.Person.address) + ","
            + columnNameAsColumnTitle(Tables.PersonBook.startdate) + ","
            + columnNameAsColumnTitle(Tables.PersonBook.deadline) + ","
            + columnNameAsColumnTitle(Tables.PersonBook.finishdate) + " "
            + "FROM personbook "
            + "LEFT JOIN person on personbook.personid = person.personid "
            + "LEFT JOIN book on personbook.bookid = book.bookid "
            + "LEFT JOIN student on person.personid = student.personid";

    @Override
    public TableModel search(int dateId, long startDate, long endDate, int optionsId, String searchText) {
        String query = "";
        query += BORROW_SEARCH_QUERY;
        query += " WHERE ";
        query += "  (" + Tables.PersonBook.personbookid + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Book.bookid  + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Book.isbn + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Book.bookname + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Person.firstname + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Person.lastname + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Student.studentnumber + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Person.phone + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Person.address + " LIKE '" + searchText + "%'";
        query += ")";
        switch (dateId) {
            case 1:
                query += " AND " + Tables.PersonBook.startdate + " BETWEEN " + startDate + " AND " + endDate;
                break;
            case 2:
                query += " AND " + Tables.PersonBook.deadline + " BETWEEN " + startDate + " AND " + endDate;
                break;
            case 3:
                query += " AND " + Tables.PersonBook.finishdate + " BETWEEN " + startDate + " AND " + endDate;
                break;
            default:
                break;
        }
        query += " GROUP BY personbook.personbookid";
        ResultSet rs = createResultSet(query);
        TableModel tableModel = DbUtils.resultSetToTableModel(rs,
                columnTitleWithoutPrime("personbook.startdate"),
                columnTitleWithoutPrime("personbook.deadline"),
                columnTitleWithoutPrime("personbook.finishdate"));
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
