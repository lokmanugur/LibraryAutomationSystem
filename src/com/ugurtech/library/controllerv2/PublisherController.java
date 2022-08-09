/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.controllerv2;

import com.ugurtech.library.service.validation.UserInfoMessages;
import com.ugurtech.library.modelv2.PublisherModel;
import com.ugurtech.library.persistancev2.publisher.PublisherDaoImpl;
import com.ugurtech.library.service.publisher.PublisherService;
import com.ugurtech.library.service.publisher.PublisherServiceImpl;
import com.ugurtech.library.view.book.PublisherForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ugur
 *
 */
public class PublisherController extends AbstractController {

    private final PublisherForm publisherForm;
    private PublisherModel publisherModel;
    private final PublisherService publisherService = new PublisherServiceImpl(new PublisherDaoImpl());
    private List<PublisherModel> publisherList;

    public PublisherController(PublisherForm publisherForm) {
        this.publisherForm = publisherForm;
    }

    public void addPublisher() {
        publisherModel = new PublisherModel();
        if (publisherForm.getPublisherNameTextField().getText().equals("")) {
            UserInfoMessages.getInstance().showInfoMessages("Lütfen Yayıncı Kuruluş: alanını doldurunuz.");
        } else {
            publisherModel.setPublisherName(publisherForm.getPublisherNameTextField().getText());
            publisherModel.setPhone(publisherForm.getPhoneTextField().getText());
            publisherModel.setAddress(publisherForm.getAddressTextArea().getText());
            publisherDao.addPublisher(publisherModel);
        }
        fillAllPublisher();
    }

    public void fillAllPublisher() {
        Map<String, String> filters = new HashMap<>();
        Optional.ofNullable(publisherForm.getPublisherSearchTextField().getText())
                .filter(value -> !value.equals(""))
                .ifPresent(value -> filters.put("publisherName", value));
        publisherForm.getPublisherTable().setModel(DbUtils.resultSetToTableModel(publisherDao.findPublisherByName(filters)));
    }

    public void deletePublisher() {
        if (publisherForm.getPublisherTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages("Lütfen silmek istediğiniz veriyi seçin");
        } else if (UserInfoMessages.getInstance().showApproveMessages("Seçilen satırı silmek istediğinize eminmisiniz?", "Silme İşlemi Onay Formu")) {
            publisherDao.deletePublisher((int) publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(), 0));
        }
        fillAllPublisher();
    }

    public void updatePublisher() {
        this.publisherModel = new PublisherModel();
        if (publisherForm.getPublisherTable().getSelectedRow() == -1) {
            UserInfoMessages.getInstance().showInfoMessages("Lütfen Güncellemek istediğiniz satırı seçin.");
        } else {
            publisherModel.setPublisherId((int) publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(), 0));
            publisherModel.setPublisherName((String) publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(), 1));
            publisherModel.setPhone((String) publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(), 2));
            publisherModel.setAddress((String) publisherForm.getPublisherTable().getModel().getValueAt(publisherForm.getPublisherTable().getSelectedRow(), 3));
            publisherDao.updatePublisher(publisherModel);
        }
        fillAllPublisher();
    }

    @Override
    void initView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void initController() {
        publisherForm.getSaveButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add();
            }
        });
        publisherForm.getUpdateButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update();
            }
        });
        publisherForm.getDeleteButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete();
            }
        });
        publisherForm.getPublisherSearchTextField().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search("");
            }
        });

    }

    @Override
    void get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    void getAll() {
       publisherList = publisherService.getAll();
    }

    @Override
    void add() {
    }

    @Override
    void delete() {
    }

    @Override
    void update() {
    }
    
    private void search(String searchQue){
    
    }
}
