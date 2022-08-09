/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistancev2.author;

import com.ugurtech.library.modelv2.AuthorModel;
import com.ugurtech.library.persistance.DaoAbstract;
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
public class AuthorDaoImpl extends DaoAbstract implements AuthorDao {
    
    public static final String ALL_AUTHOR_QUERY ="SELECT a.authorid,a.personid,p.firstname,p.lastname FROM author a,person p WHERE a.authorid = p.personid";
    
    private final List<AuthorModel> authorList = new ArrayList<>();

    @Override
    public List<AuthorModel> getAll() {
                if(!authorList.isEmpty()){
            authorList.clear();
        }
        ResultSet resultSet = createResultSet(ALL_AUTHOR_QUERY);
        try {
            while(resultSet.next())
            authorList.add(new AuthorModel(resultSet.getInt("a.authorid"),resultSet.getInt("a.personid"),resultSet.getString("p.firstname"),resultSet.getString("p.lastname")));
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authorList;
    }

    @Override
    public AuthorModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(AuthorModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(AuthorModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(AuthorModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
