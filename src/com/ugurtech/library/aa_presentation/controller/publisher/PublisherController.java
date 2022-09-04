/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.aa_presentation.controller.publisher;

import com.ugurtech.library.aa_presentation.controller.AbstractController;
import com.ugurtech.library.aa_presentation.controller.Controller;
import com.ugurtech.library.ab_application.service.publisher.PublisherService;
import com.ugurtech.library.ab_application.service.publisher.PublisherServiceImpl;
import com.ugurtech.library.ac_dataaccesslayer.publisher.PublisherDaoImpl;
import com.ugurtech.library.ad_model.PublisherModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 */
public class PublisherController extends AbstractController implements Controller<PublisherModel>{

    protected PublisherModel publisherModel;
    private final PublisherService publisherService = new PublisherServiceImpl(new PublisherDaoImpl());
    
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
