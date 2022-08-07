/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.service.publisher;

import com.ugurtech.library.modelv2.PublisherModel;
import com.ugurtech.library.persistancev2.publisher.PublisherDao;
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
