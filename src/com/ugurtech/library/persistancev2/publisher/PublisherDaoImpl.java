/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistancev2.publisher;

import com.ugurtech.library.modelv2.PublisherModel;
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
public class PublisherDaoImpl extends DaoAbstract implements PublisherDao {

    public static final String ALL_PUBLISHER_QUERY = "SELECT * FROM publisher";
    private final List<PublisherModel> publisherList = new ArrayList<>();
    @Override
    public List<PublisherModel> getAll() {

        ResultSet resultSet = createResultSet(ALL_PUBLISHER_QUERY);
        try {
            while (resultSet.next()) {
                publisherList.add(new PublisherModel(resultSet.getInt("publisherid"),
                        resultSet.getString("publishername"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        0,
                        resultSet.getLong("lastupdate")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return publisherList;
    }

    @Override
    public PublisherModel get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(PublisherModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PublisherModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(PublisherModel v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
