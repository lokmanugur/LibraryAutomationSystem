/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.dataaccesslayer.borrow;

import resources.lib.sql.DbUtils;
import resources.lib.validation.UserInfoMessages;
import com.ugurtech.library.dataaccesslayer.DaoAbstract;
import com.ugurtech.library.dataaccesslayer.enumeration.Tables;
import com.ugurtech.library.model.BookModel;
import com.ugurtech.library.model.ClassModel;
import com.ugurtech.library.model.PersonBookModel;
import com.ugurtech.library.model.SchoolModel;
import com.ugurtech.library.model.StudentModel;
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
 */
public class BorrowDaoImpl extends DaoAbstract<PersonBookModel> implements BorrowDao {

    public static String PERSON_BOOK_ADD_QUERY = "INSERT INTO personbook (personid,bookid,startdate,deadline) VALUES(?,?,?,?)";
    public static String UPDATE_PERSONBOOK = "UPDATE personbook SET finishdate=?,readpage=? WHERE personbookid=?";
    public static final String PERSONBOOK_DELETE_QUERTY = "DELETE FROM personbook WHERE personbookid=?";
    public static String BORROW_GET_QUERY = "SELECT "
            + "pb.personbookid,b.bookid,b.isbn,b.bookname,b.pages,b.shelf,"
            + "pb.startdate,pb.deadline,"
            + "p.firstname,p.lastname,s.studentnumber,c.classname,sch.schoolname,p.phone,p.address "
            + "FROM book b LEFT JOIN personbook pb on pb.bookid = b.bookid "
            + "LEFT JOIN person p on pb.personid = p.personid "
            + "LEFT JOIN student s on s.personid = p.personid "
            + "LEFT JOIN school sch on sch.schoolid = s.schoolid "
            + "LEFT JOIN clss c on s.classid = c.classid ";
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
            + columnNameAsColumnTitle(Tables.PersonBook.finishdate) + ","
            + columnNameAsColumnTitle(Tables.PersonBook.readpage) + " "
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
        query += " OR " + Tables.PersonBook.readpage + " LIKE '" + searchText + "%'";
        query += " OR " + Tables.Book.bookid + " LIKE '" + searchText + "%'";
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
        switch (optionsId) {
            case 1:
                query += " AND " + Tables.PersonBook.finishdate + " NOT NULL";
                break;
            case 2:
                query += " AND " + Tables.PersonBook.finishdate + " IS NULL";
                break;
            case 3:
                query += " AND " + Tables.PersonBook.finishdate + " IS NULL AND "+new Date().getTime()+">"+ Tables.PersonBook.deadline;
                break;
            case 4:
                query += " AND " + Tables.PersonBook.finishdate + " IS NULL AND "+new Date().getTime()+"<"+ Tables.PersonBook.deadline;
                break;
            default:
                break;
        }
        query += " GROUP BY personbook.personbookid";
        ResultSet rs = createResultSet(query);
        TableModel tableModel = DbUtils.resultSetToTableModel(rs,
                columnTitleWithOutPrime("personbook.startdate"),
                columnTitleWithOutPrime("personbook.deadline"),
                columnTitleWithOutPrime("personbook.finishdate"));
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
                stockDecrease(bbm.getBookId(), getStock(bbm.getBookId()), bbm.getStock());
            }
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, "Add person book query error", BorrowDaoImpl.class.getName());
        }
        commit();
        UserInfoMessages.getInstance().insertMessage();
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

    private void stockDecrease(int bookid, int databaseStock, int amountOfGotenBook) {
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
    private void stockIncrease(int bookid, int databaseStock, int amountOfGotenBook) {
        PreparedStatement preparedStatement = createPrepareStatement("UPDATE book SET stock=? WHERE bookid=?");
        try {
            preparedStatement.setInt(1, databaseStock + amountOfGotenBook);
            preparedStatement.setInt(2, bookid);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, "Book update stock error ", BorrowDaoImpl.class.getName());
        }
    }    

    @Override
    public void update(PersonBookModel personBookModel) {
        beginTransection();
        String query = UPDATE_PERSONBOOK;
        PreparedStatement preparedStatement = createPrepareStatement(query);
        try {
            preparedStatement.setLong(1, personBookModel.getFinishDate());
            preparedStatement.setInt(2, personBookModel.getReadPage());
            preparedStatement.setInt(3, personBookModel.getPersonBookId());
            preparedStatement.executeUpdate();
            stockIncrease(personBookModel.getBookModel().get(0).getBookId(), 
                    getStock(personBookModel.getBookModel().get(0).getBookId()), 1);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, "Add person book query error", BorrowDaoImpl.class.getName());
        }
        commit();
        UserInfoMessages.getInstance().updateMessage();
    }

    @Override
    public List<PersonBookModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonBookModel get(int id) {
        PersonBookModel personBookModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, BORROW_GET_QUERY, " WHERE", " pb.personbookid="));
        try {
            List<BookModel> bookModels = new ArrayList<>();
            personBookModel = new PersonBookModel();
            if (resultSet.next()) {
                personBookModel.setPersonBookId(resultSet.getInt("personbookid"));
                BookModel bookModel = new BookModel();
                bookModel.setBookId(resultSet.getInt("bookid"));
                bookModel.setIsbn(resultSet.getLong("isbn"));
                bookModel.setBookName(resultSet.getString("bookname"));
                bookModel.setPageNumbber(resultSet.getInt("pages"));
                bookModel.setShelf(resultSet.getString("shelf"));
                bookModels.add(bookModel);
                personBookModel.setBookModel(bookModels);
                personBookModel.setStartDate(resultSet.getLong("startdate"));
                personBookModel.setDeadLine(resultSet.getLong("deadline"));
                personBookModel.setFinishDate(new Date().getTime());
                StudentModel personModel = new StudentModel();
                personModel.setFirstName(resultSet.getString("firstname"));
                personModel.setLastName(resultSet.getString("lastname"));
                personModel.setStudentNumber(resultSet.getString("studentnumber"));
                personModel.setClassModel(new ClassModel(resultSet.getString("classname")));
                personModel.setSchoolModel(new SchoolModel(resultSet.getString("schoolname")));
                personModel.setPhone(resultSet.getString("phone"));
                personModel.setAddress(resultSet.getString("address"));
                personBookModel.setStudentModel(personModel);
            }

        } catch (SQLException ex) {
            getLogger(ex, "Get Exception ", PersonBookModel.class.getName());
        }

        return personBookModel;
    }

    @Override
    public void delete(PersonBookModel v) {
        beginTransection();
        PreparedStatement preparedStatement = createPrepareStatement(PERSONBOOK_DELETE_QUERTY);
        try {
            preparedStatement.setInt(1, v.getPersonBookId());
            int effactedRow = preparedStatement.executeUpdate();
                stockIncrease(v.getBookModel().get(0).getBookId(), getStock(v.getBookModel().get(0).getBookId()), 1);
        } catch (SQLException ex) {
            rollBack();
            getLogger(ex, "Delete Exception ", BorrowDaoImpl.class.getName());
        }
        commit();
        UserInfoMessages.getInstance().deletedMessage();
    }
}
