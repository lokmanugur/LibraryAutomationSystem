/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ac_dataaccesslayer.publisher;

import com.ugurtech.library.ab_application.af_lib.sql.DbUtils;
import com.ugurtech.library.ad_model.PublisherModel;
import com.ugurtech.library.ac_dataaccesslayer.DaoAbstract;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.ac_dataaccesslayer.enumeration.Tables;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class PublisherDaoImpl extends DaoAbstract implements PublisherDao {

    public static final String PUBLISHER_INSERT_QUERY = "INSERT INTO publisher(publishername,phone,address) VALUES(?,?,?)";
    public static final String PUBLISHER_DELETE_QUERY = "DELETE FROM publisher WHERE publisherid=?";
    public static final String PUBLISHER_UPDATE_QUERY = "UPDATE publisher SET publishername=?,phone=?,address=? WHERE publisherid=?";
    public static final String PUBLISHER_SEARCH_QUERY = "SELECT "
            + columnNameAsColumnTitle(Tables.Publisher.publisherid) + ","
            + columnNameAsColumnTitle(Tables.Publisher.publishername) + ","
            + columnNameAsColumnTitle(Tables.Publisher.phone) + ","
            + columnNameAsColumnTitle(Tables.Publisher.address)
            + " FROM publisher ";

    private List<PublisherModel> publisherList;

    public PublisherDaoImpl() {
    }

    @Override
    public List<PublisherModel> getAll() {

        if (publisherList!=null) {
            if (!publisherList.isEmpty()) {
                publisherList.clear();
            }
        }else{publisherList = new ArrayList<>();}
        ResultSet resultSet = createResultSet(getExistID(0, PUBLISHER_SEARCH_QUERY));
        try {
            
            while (resultSet.next()) {
                publisherList.add(new PublisherModel(
                        resultSet.getInt(columnTitleWithoutPrime(Tables.Publisher.publisherid)),
                      resultSet.getString(columnTitleWithoutPrime(Tables.Publisher.publishername)),
                            resultSet.getString(columnTitleWithoutPrime(Tables.Publisher.phone)),
                          resultSet.getString(columnTitleWithoutPrime(Tables.Publisher.address))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return publisherList;
    }

    @Override
    public PublisherModel get(int id) {
        PublisherModel publisherModel = null;
        ResultSet resultSet = createResultSet(getExistID(id, 
                PUBLISHER_SEARCH_QUERY, 
                " WHERE ",
                columnTitleWithoutPrime(Tables.publisher + ".publisherid"), "="));
        try {
            publisherModel = new PublisherModel();
            if (resultSet.next()) {
                publisherModel.setPublisherId(resultSet.getInt(columnTitleWithoutPrime(Tables.publisher + ".publisherid")));
                publisherModel.setPublisherName(resultSet.getString(columnTitleWithoutPrime(Tables.publisher + ".publishername")));
                publisherModel.setPhone(resultSet.getString(columnTitleWithoutPrime(Tables.publisher + ".phone")));
                publisherModel.setAddress(resultSet.getString(columnTitleWithoutPrime(Tables.publisher + ".address")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublisherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return publisherModel;
    }

    @Override
    public void add(PublisherModel publisherModel) {
        PreparedStatement preparedStatement = createPrepareStatement(PUBLISHER_INSERT_QUERY);
        try {
            preparedStatement.setString(1, publisherModel.getPublisherName());
            preparedStatement.setString(2, publisherModel.getPhone());
            preparedStatement.setString(3, publisherModel.getAddress());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            getLogger(ex, "Publisher add error ", PublisherDaoImpl.class.getName());
        }
    }

    @Override
    public void update(PublisherModel publisherModel) {
        PreparedStatement preparedStatement = createPrepareStatement(PUBLISHER_UPDATE_QUERY);
        try {
            preparedStatement.setString(1, publisherModel.getPublisherName());
            preparedStatement.setString(2, publisherModel.getPhone());
            preparedStatement.setString(3, publisherModel.getAddress());
            preparedStatement.setInt(4, publisherModel.getPublisherId());
            int affectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(affectedRow);
        } catch (SQLException ex) {
                getLogger(ex, "Publisher update error ", PublisherDaoImpl.class.getName()); 
        }
    }

    @Override
    public void delete(PublisherModel publisherModel) {
        PreparedStatement preparedStatement = createPrepareStatement(PUBLISHER_DELETE_QUERY);
        try {
            preparedStatement.setInt(1, publisherModel.getPublisherId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            getLogger(ex, "Publisher delete error ", PublisherDaoImpl.class.getName());
        }
    }

    @Override
    public TableModel search(String str) {
        String query="";
        query+=PUBLISHER_SEARCH_QUERY+" WHERE";
        query+=" publisher.publisherid"+" LIKE '"+str+"%'";
        query+=" OR publisher.publishername"+" LIKE '"+str+"%'";
        query+=" OR publisher.phone"+" LIKE '"+str+"%'";
        query+=" OR publisher.address"+" LIKE '"+str+"%'";
        return DbUtils.resultSetToTableModel(createResultSet(query));
    }

}
