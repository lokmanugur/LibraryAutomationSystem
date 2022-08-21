/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistancev2.publisher;

import com.ugurtech.library.modelv2.PublisherModel;
import com.ugurtech.library.persistancev2.DaoAbstract;
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
public class PublisherDaoImpl extends DaoAbstract implements PublisherDao {

    public static final String PUBLISHER_INSERT_QUERY = "INSERT INTO publisher(publishername,phone,address) VALUES(?,?,?)";
    public static final String PUBLISHER_DELETE_QUERY = "UPDATE publisher SET deleted=?,lastupdate=? WHERE publisherid=?";
    public static final String PUBLISHER_UPDATE_QUERY = "UPDATE publisher SET publishername=?,phone=?,address=? WHERE publisherid=?";
    public static final String ALL_PUBLISHER_QUERY = "SELECT * FROM publisher WHERE deleted=0";
    public static final String PUBLISHER_SINGLE_QUERY = "SELECT * FROM publisher ";
    public static final String PUBLISHER_SEARCH_QUERY = "SELECT publisherid as Yayın_Evi_No,"
            + "publishername as Yayın_Evi_Adı,"
            + "phone as Telefon,"
            + "address as Adres,"
            + "lastupdate as Son_Güncelleme_Tarihi FROM publisher ";

    private final List<PublisherModel> publisherList = new ArrayList<>();

    public PublisherDaoImpl() {
    }

    @Override
    public List<PublisherModel> getAll() {

        if(!publisherList.isEmpty())
            publisherList.clear();
        ResultSet resultSet = createResultSet(ALL_PUBLISHER_QUERY);
        try {
            while (resultSet.next()) {
                publisherList.add(
                        new PublisherModel(resultSet.getInt("publisherid"),
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
        PublisherModel publisherModel = new PublisherModel();
               ResultSet resultSet = createResultSet(getID(id));
        try {
            if(resultSet.next()) {
                publisherModel.setPublisherId(resultSet.getInt("publisherid"));
                publisherModel.setPublisherName(resultSet.getString("publishername"));
                publisherModel.setPhone(resultSet.getString("phone"));
                publisherModel.setAddress(resultSet.getString("address"));
                publisherModel.setCreatedDate(0);
                publisherModel.setLastUpdate(resultSet.getLong("lastupdate"));
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
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Insert Error");
            Logger.getLogger(com.ugurtech.library.persistance.publisher.PublisherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            UserInfoMessages.getInstance().exceptionInfoMessages(null, ex.getMessage(), "Update Error");
            Logger.getLogger(PublisherModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(PublisherModel publisherModel) {
                PreparedStatement preparedStatement=createPrepareStatement(PUBLISHER_DELETE_QUERY);
        try {
            preparedStatement.setBoolean(1,true);
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setInt(3, publisherModel.getPublisherId());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Delete Error");
            Logger.getLogger(com.ugurtech.library.persistance.publisher.PublisherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet search(String str) {
        StringBuilder query = new StringBuilder(PUBLISHER_SEARCH_QUERY);
        query.append(" WHERE");
        query.append(" (publisherid").append(" LIKE '%").append(str).append("%'");
        query.append(" or publishername").append(" LIKE '%").append(str).append("%'");
        query.append(" or phone").append(" LIKE '%").append(str).append("%'");
        query.append(" or address").append(" LIKE '%").append(str).append("%'");
        query.append(" or lastupdate").append(" LIKE '%").append(str).append("%' ").append(") AND deleted=0");
        return createResultSet(query.toString());
    }
    
    private String getID(int id) {
        StringBuilder query = new StringBuilder(PUBLISHER_SINGLE_QUERY);
        query.append(" WHERE");
        query.append(" publisherid=").append(id).append(" AND deleted=0");
        return query.toString();
    }

}
