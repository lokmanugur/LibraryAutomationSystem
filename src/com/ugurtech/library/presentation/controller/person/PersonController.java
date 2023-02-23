/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.presentation.controller.person;

import com.ugurtech.library.presentation.controller.AbstractController;
import com.ugurtech.library.presentation.controller.Controller;
import com.ugurtech.library.application.service.person.PersonService;
import com.ugurtech.library.application.service.person.PersonServiceImpl;
import com.ugurtech.library.dataaccesslayer.person.PersonDaoImpl;
import com.ugurtech.library.model.PersonModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 */
public class PersonController extends AbstractController implements Controller<PersonModel> {

    private final PersonService personService = new PersonServiceImpl(new PersonDaoImpl());
    protected PersonModel personModel;
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
