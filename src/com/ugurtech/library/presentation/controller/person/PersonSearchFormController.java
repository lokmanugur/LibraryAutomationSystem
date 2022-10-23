/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.presentation.controller.person;

import com.ugurtech.library.presentation.controller.Initialize;
import com.ugurtech.library.presentation.view.main.MainForm;
import com.ugurtech.library.presentation.view.person.PersonForm;
import com.ugurtech.library.presentation.view.person.PersonSearchForm;

/**
 *
 * @author ugur
 * 
 */
public final class PersonSearchFormController extends PersonController implements Initialize {

    private final PersonSearchForm personSearchForm;

    public PersonSearchFormController(PersonSearchForm personSearchForm) {
        this.personSearchForm = personSearchForm;
        initView();
        initController();
    }

    @Override
    public void initView() {
        search();
    }

    @Override
    public void initController() {
        personSearchForm.getTextFieldSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

        personSearchForm.getButtonWrite().addActionListener((evt) -> {
            write();
        });

        personSearchForm.getButtonDelete().addActionListener((evt) -> {
            delete();
        });

        personSearchForm.getButtonUpdate().addActionListener((evt) -> {
            update();
        });

        personSearchForm.getButtonAdd().addActionListener((evt) -> {
            add();
        });
    }

    public void search() {
        personSearchForm.getTableSearch().setModel(search(personSearchForm.getTextFieldSearch().getText()));
    }

    private void write() {
       write(personSearchForm.getTableSearch(), personSearchForm.getTitle());
    }

    private void delete() {
        if(deleteApproveMessage(personSearchForm.getTableSearch().getSelectedRow())){
            delete((int)personSearchForm.getTableSearch().getValueAt(personSearchForm.getTableSearch().getSelectedRow(), 0));
        }
        search();
    }

    private void update() {
        if(updateUnSelectRowMessage(personSearchForm.getTableSearch().getSelectedRow())){
            PersonForm pf=PersonForm.INSTANCE;
            MainForm.getInstance().addDesktopPane(pf);
            pf.getPersonFormController().modelToForm(get((int)personSearchForm.getTableSearch().getValueAt(personSearchForm.getTableSearch().getSelectedRow(), 0)));
        }
    }

    private void add() {
        MainForm.getInstance().addDesktopPane(PersonForm.INSTANCE);
    }
}
