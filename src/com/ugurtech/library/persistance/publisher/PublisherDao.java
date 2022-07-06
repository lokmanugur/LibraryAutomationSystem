/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.persistance.publisher;

import com.ugurtech.library.model.PublisherModel;
import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author ugur
 */
public interface PublisherDao {
    
    public PublisherModel getPublisher(int publisherId);
    public void addPublisher(PublisherModel publisher);
    public void updatePublisher(PublisherModel publisher);
    public void deletePublisher(int publisherId);
    public ResultSet findPublisherByName(Map<String, String> filters);
    
}
