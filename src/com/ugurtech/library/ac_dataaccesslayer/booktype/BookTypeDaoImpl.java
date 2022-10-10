/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.booktype;

import com.ugurtech.library.ab_application.af_lib.sql.DbUtils;
import com.ugurtech.library.ad_model.BookTypeModel;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ac_dataaccesslayer.enumeration.Tables;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookTypeDaoImpl extends DaoAbstract implements BookTypeDao {

    public static final String BOOKTYPE_INSERT_QUERY = "INSERT INTO booktype (typename,abbreviation) VALUES(?,?)";
    public static final String BOOKTYPE_DELETE_QUERY = "DELETE FROM booktype WHERE booktype.booktypeid=?";
    public static final String BOOKTYPE_UPDATE_QUERY = "UPDATE booktype SET typename=?,abbreviation=? WHERE booktypeid=?";
    public static final String BOOKTYPE_SEARCH_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.booktype+".booktypeid")+ ","
            + columnNameAsColumnTitle(Tables.booktype+".typename")+ ","
            + columnNameAsColumnTitle(Tables.booktype+".abbreviation")
            + " FROM booktype ";


    private final List<BookTypeModel> bookTypeList;
    private final StringBuilder query;

    public BookTypeDaoImpl() {
        bookTypeList = new ArrayList<>();
        query = new StringBuilder();
    }

    @Override
    public List<BookTypeModel> getAll() {
        if (!bookTypeList.isEmpty()) {
            bookTypeList.clear();
        }
        ResultSet resultSet = createResultSet(BOOKTYPE_SEARCH_QUERY);
        try {
            while (resultSet.next()) {
                bookTypeList.add(new BookTypeModel(
                        resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3)));
            }
        } catch (SQLException ex) {
            getLogger(ex,"GetAll Exception",BookTypeDaoImpl.class.getName());
        }
        return bookTypeList;
    }  
    
    @Override
    public BookTypeModel get(int id) {
        BookTypeModel bookTypeModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, BOOKTYPE_SEARCH_QUERY," WHERE"," booktype.booktypeid="));
        try {
            bookTypeModel = new BookTypeModel();
            if (resultSet.next()) {
                bookTypeModel.setBookTypeId(resultSet.getInt(1));
                bookTypeModel.setTypeName(resultSet.getString(2));
                bookTypeModel.setAbbrivation(resultSet.getString(3));
            }
        } catch (SQLException ex) {
            getLogger(ex,"Get Exception ",BookTypeDaoImpl.class.getName());
        }

        return bookTypeModel;
    }

    @Override
    public void add(BookTypeModel bookTypeModel) {
        PreparedStatement preparedStatement = createPrepareStatement(BOOKTYPE_INSERT_QUERY);
        try {
            preparedStatement.setString(1, bookTypeModel.getTypeName());
            preparedStatement.setString(2, bookTypeModel.getAbbrivation());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            getLogger(ex,"Add Exception ",BookTypeDaoImpl.class.getName());
        }
    }

    @Override
    public void update(BookTypeModel bookTypeModel) {
        PreparedStatement preparedStatement = createPrepareStatement(BOOKTYPE_UPDATE_QUERY);
        try {
            preparedStatement.setString(1, bookTypeModel.getTypeName());
            preparedStatement.setString(2, bookTypeModel.getAbbrivation());
            preparedStatement.setInt(3, bookTypeModel.getBookTypeId());
            int affectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(affectedRow);
        } catch (SQLException ex) {
            getLogger(ex,"Update Exception ",BookTypeDaoImpl.class.getName());
        }
    }

    @Override
    public void delete(BookTypeModel bookTypeModel) {
        PreparedStatement preparedStatement = createPrepareStatement(BOOKTYPE_DELETE_QUERY);
        try {
            preparedStatement.setInt(1, bookTypeModel.getBookTypeId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            getLogger(ex,"Delete Exception ",BookTypeDaoImpl.class.getName());
        }
    }

    @Override
    public TableModel search(String str) {
        query.setLength(0);
        query.append(BOOKTYPE_SEARCH_QUERY);
        query.append(" WHERE");
        query.append(" (booktype.booktypeid").append(" LIKE '").append(str).append("%'");
        query.append(" or booktype.typename").append(" LIKE '").append(str).append("%'");
        query.append(" or booktype.abbreviation").append(" LIKE '").append(str).append("%')");
        return DbUtils.resultSetToTableModel(createResultSet(query.toString()));
    }

}
