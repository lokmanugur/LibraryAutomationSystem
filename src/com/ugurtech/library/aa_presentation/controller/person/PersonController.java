/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.aa_presentation.controller.person;

import com.ugurtech.library.aa_presentation.controller.AbstractController;
import com.ugurtech.library.aa_presentation.controller.Controller;
import com.ugurtech.library.aa_presentation.view.person.PersonForm;
import com.ugurtech.library.ab_application.service.person.PersonService;
import com.ugurtech.library.ab_application.service.person.PersonServiceImpl;
import com.ugurtech.library.ac_dataaccesslayer.person.PersonDaoImpl;
import com.ugurtech.library.ad_model.PersonModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 */
public class PersonController extends AbstractController implements Controller<PersonModel> {

    private final PersonService personService = new PersonServiceImpl(new PersonDaoImpl());
    
    @Override
    public List<PersonModel> getAll() {
      return personService.getAll();
    }

    @Override
    public PersonModel get(int id) {
       return personService.get(id);
    }

    @Override
    public void add(PersonModel v) {
        personService.add(v);
    }

    @Override
    public void update(PersonModel v) {
        personService.update(v);
    }

    @Override
    public void delete(int id) {
        personService.delete(id);
    }
    public TableModel search(String searchText){
        return personService.search(searchText);
    }
    
}
