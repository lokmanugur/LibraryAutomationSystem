/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.publisher;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import com.ugurtech.library.application.service.publisher.PublisherService;
import com.ugurtech.library.application.service.publisher.PublisherServiceImpl;
import com.ugurtech.library.dataaccesslayer.publisher.PublisherDaoImpl;
import com.ugurtech.library.model.PublisherModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class PublisherController extends AbstractController implements Controller<PublisherModel>{

    private final PublisherService publisherService = new PublisherServiceImpl(new PublisherDaoImpl());
    protected PublisherModel publisherModel;
    
    @Override
    public List<PublisherModel> getAll() {
       return publisherService.getAll();
    }

    @Override
    public PublisherModel get(int id) {
       return publisherService.get(id);
    }

    @Override
    public void add(PublisherModel v) {
        publisherService.add(v);
    }

    @Override
    public void update(PublisherModel v) {
        publisherService.update(v);
    }

    @Override
    public void delete(int id) {
        publisherService.delete(id);
    }
    
    public TableModel search(String str){
        return publisherService.search(str);
    }
    
}
