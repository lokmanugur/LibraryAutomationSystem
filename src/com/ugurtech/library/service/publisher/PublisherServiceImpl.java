/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.publisher;

import com.ugurtech.library.modelv2.PublisherModel;
import com.ugurtech.library.persistancev2.publisher.PublisherDao;
import java.sql.ResultSet;
import java.util.List;

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
    public void delete(PublisherModel v) {
        publisherDao.delete(v);
    }

    @Override
    public ResultSet search(String str) {
       return publisherDao.search(str);
    }
    
}
