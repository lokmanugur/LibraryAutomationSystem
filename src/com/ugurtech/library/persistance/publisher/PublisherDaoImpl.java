/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.publisher;

import com.ugurtech.library.persistance.DaoAbstract;
import com.ugurtech.library.persistance.publisher.PublisherDao;
import com.ugurtech.library.persistance.book.BookDaoImpl;
import com.ugurtech.library.ab_application.af_lib.validation.UserInfoMessages;
import com.ugurtech.library.model.PublisherModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugur
 */
public class PublisherDaoImpl extends DaoAbstract implements PublisherDao {

    private static final String PUBLISHER_INSERT_QUERY="INSERT INTO publisher(publishername,phone,address) VALUES(?,?,?)";
    private static final String PUBLISHER_DELETE_QUERY="UPDATE publisher SET deleted=?,lastupdate=? WHERE publisherid=?";
    private static final String PUBLISHER_UPDATE_QUERY="UPDATE publisher SET publishername=?,phone=?,address=?,lastupdate=? WHERE publisherid=?";
    private static final String PUBLISHER_SEARCH_QUERY="SELECT publisherid as Yayın_Evi_No,"
            + "publishername as Yayın_Evi_Adı,"
            + "phone as Telefon,"
            + "address as Adres,"
            + "lastupdate as Son_Güncelleme_Tarihi FROM publisher ";
    
    @Override
    public ResultSet findPublisherByName(Map<String, String> filters) {
        StringBuilder query = new StringBuilder(PUBLISHER_SEARCH_QUERY);
        query.append("WHERE ");
        query.append("deleted=0 ");
        fillFilters(query,filters);
        return createResultSet(query.toString());
    }
        

    @Override
    public PublisherModel getPublisher(int publisherId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPublisher(PublisherModel publisher) {
        PreparedStatement preparedStatement=createPrepareStatement(PUBLISHER_INSERT_QUERY);
        try {
            preparedStatement.setString(1, publisher.getPublisherName());
            preparedStatement.setString(2, publisher.getPhone());
            preparedStatement.setString(3, publisher.getAddress());
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().insertMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Insert Error");
            Logger.getLogger(PublisherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatePublisher(PublisherModel publisher) {
        PreparedStatement preparedStatement = createPrepareStatement(PUBLISHER_UPDATE_QUERY);
        try{
            preparedStatement.setString(1, publisher.getPublisherName());
            preparedStatement.setString(2, publisher.getPhone());
            preparedStatement.setString(3, publisher.getAddress());
            preparedStatement.setString(4, new Date().toString());
            preparedStatement.setInt(5, publisher.getPublisherId());
            int affectedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().updateMessage(affectedRow);
        }catch(SQLException ex){
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Update Error");
            Logger.getLogger(BookDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletePublisher(int publisherId) {
        PreparedStatement preparedStatement=createPrepareStatement(PUBLISHER_DELETE_QUERY);
        try {
            preparedStatement.setBoolean(1,true);
            preparedStatement.setString(2, new Date().toString());
            preparedStatement.setInt(3, publisherId);
            int effactedRow = preparedStatement.executeUpdate();
            UserInfoMessages.getInstance().deletedMessage(effactedRow);
        } catch (SQLException ex) {
            UserInfoMessages.getInstance().exceptionInfoMessages(null,ex.getMessage(),"Delete Error");
            Logger.getLogger(PublisherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillFilters(StringBuilder query, Map<String, String> filters) {
        if(!filters.isEmpty()){
            if(filters.containsKey("publisherName")){
                query.append("AND ");
                query.append("publishername LIKE '%");
                query.append(filters.get("publisherName"));
                query.append("%' ");
            }
        }
    }
}
