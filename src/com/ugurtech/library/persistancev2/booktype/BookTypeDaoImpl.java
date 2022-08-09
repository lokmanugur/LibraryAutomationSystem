/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistancev2.booktype;

import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.modelv2.BookTypeModel;
import com.ugurtech.library.persistance.DaoAbstract;
import com.ugurtech.library.persistancev2.author.AuthorDaoImpl;
import static com.ugurtech.library.persistancev2.author.AuthorDaoImpl.ALL_AUTHOR_QUERY;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class BookTypeDaoImpl extends DaoAbstract implements BookTypeDao {

    public static final String ALL_BOOKTYPE_QUERY = "SELECT * FROM booktype";

    private final List<BookTypeModel> bookTypeList = new ArrayList<>();

    @Override
    public List<BookTypeModel> getAll() {
        if (!bookTypeList.isEmpty()) {
            bookTypeList.clear();
        }
        ResultSet resultSet = createResultSet(ALL_BOOKTYPE_QUERY);
        try {
            while (resultSet.next()) {
                bookTypeList.add(new BookTypeModel(resultSet.getInt("booktypeid"), resultSet.getString("typename"), resultSet.getString("abbreviation"),0,resultSet.getDate("lastupdate").getTime()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookTypeList;
    }

    @Override
    public BookTypeModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(BookTypeModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BookTypeModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BookTypeModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
