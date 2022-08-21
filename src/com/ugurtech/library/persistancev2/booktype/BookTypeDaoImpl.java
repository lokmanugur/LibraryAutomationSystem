/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistancev2.booktype;

import com.ugurtech.library.modelv2.BookTypeModel;
import com.ugurtech.library.persistancev2.DaoAbstract;
import com.ugurtech.library.service.localization.Internationalization;
import com.ugurtech.library.service.validation.UserInfoMessages;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookTypeDaoImpl extends DaoAbstract implements BookTypeDao {

    public static final String BOOKTYPE_INSERT_QUERY = "INSERT INTO booktype(typename,abbreviation) VALUES(?,?)";
    public static final String BOOKTYPE_DELETE_QUERY = "UPDATE booktype SET deleted=?,lastupdate=? WHERE booktypeid=?";
    public static final String BOOKTYPE_UPDATE_QUERY = "UPDATE booktype SET typename=?,abbreviation=? WHERE booktypeid=?";
    public static final String BOOKTYPE_SEARCH_QUERY = "SELECT booktypeid as " + setLanguage("booktypedaoimpl.booktypeid") + ","
            + "typename as " +setLanguage("booktypedaoimpl.typename")+ ","
            + "abbreviation as " +setLanguage("booktypedaoimpl.abbreviation")+ ","
            + "lastupdate as " +setLanguage("booktypedaoimpl.lastupdate")+ " FROM booktype ";

    public static final String ALL_BOOKTYPE_QUERY = "SELECT * FROM booktype WHERE deleted=0";
    public static final String SINGLE_BOOKTYPE_QUERY = "SELECT * FROM booktype ";

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
        ResultSet resultSet = createResultSet(ALL_BOOKTYPE_QUERY);
        try {
            while (resultSet.next()) {
                bookTypeList.add(new BookTypeModel(resultSet.getInt("booktypeid"), resultSet.getString("typename"), resultSet.getString("abbreviation"), 0, resultSet.getDate("lastupdate").getTime()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookTypeList;
    }

    @Override
    public BookTypeModel get(int id) {
        BookTypeModel bookTypeModel = new BookTypeModel();
        ResultSet resultSet = createResultSet(getID(id));
        try {
            if (resultSet.next()) {
                bookTypeModel.setBookTypeId(resultSet.getInt("booktypeid"));
                bookTypeModel.setTypeName(resultSet.getString("typename"));
                bookTypeModel.setAbbrivation(resultSet.getString("abbreviation"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(BookTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Update Error");
            Logger.getLogger(BookTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(BookTypeModel bookTypeModel) {
        PreparedStatement preparedStatement = createPrepareStatement(BOOKTYPE_DELETE_QUERY);
        try {
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setInt(3, bookTypeModel.getBookTypeId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Delete Error");
            Logger.getLogger(BookTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet search(String str) {
        query.setLength(0);
        query.append(BOOKTYPE_SEARCH_QUERY);
        query.append(" WHERE");
        query.append(" (booktypeid").append(" LIKE '%").append(str).append("%'");
        query.append(" or typename").append(" LIKE '%").append(str).append("%'");
        query.append(" or abbreviation").append(" LIKE '%").append(str).append("%'");
        query.append(" or lastupdate").append(" LIKE '%").append(str).append("%' ").append(") AND deleted=0");
        return createResultSet(query.toString());
    }

    private String getID(int id) {
        query.setLength(0);
        query.append(SINGLE_BOOKTYPE_QUERY);
        query.append(" WHERE");
        query.append(" booktypeid=").append(id).append(" AND deleted=0");
        return query.toString();
    }

}
