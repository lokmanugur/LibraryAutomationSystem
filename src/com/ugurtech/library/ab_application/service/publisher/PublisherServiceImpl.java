/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.ab_application.service.publisher;

import com.ugurtech.library.ad_model.PublisherModel;
import com.ugurtech.library.ac_dataaccesslayer.publisher.PublisherDao;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class PublisherServiceImpl implements PublisherService{
    
    private final PublisherDao publisherDao;

    public PublisherServiceImpl(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }
       
    @Override
    public List<PublisherModel> getAll() {
        return publisherDao.getAll();
    }

    @Override
    public PublisherModel get(int id) {
        return publisherDao.get(id);
    }

    @Override
    public void add(PublisherModel v) {
         publisherDao.add(v);
    }

    @Override
    public void update(PublisherModel v) {
        publisherDao.update(v);
    }

    @Override
    public void delete(int id) {
        publisherDao.delete(get(id));
    }

    @Override
    public TableModel search(String str) {
       return publisherDao.search(str);
    }
    
}