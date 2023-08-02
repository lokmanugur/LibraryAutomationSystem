/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ugurtech.library.service.person;

import com.ugurtech.library.dataaccesslayer.person.PersonDao;
import com.ugurtech.library.model.PersonModel;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author Teacher
 * 
 */
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }
    
    @Override
    public TableModel search(String searchText) {
       return personDao.search(searchText);
    }

    @Override
    public List<PersonModel> getAll() {
        return personDao.getAll();
    }

    @Override
    public PersonModel get(int id) {
        return personDao.get(id);
    }

    @Override
    public void add(PersonModel v) {
        personDao.add(v);
    }

    @Override
    public void update(PersonModel v) {
        personDao.update(v);
    }

    @Override
    public void delete(int id) {
        personDao.delete(get(id));
    }
    
}
