/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */
package com.ugurtech.library.facades;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * @param <TARGET>
 * @param <SOURCE>
 */
public class PopulatingConverter<SOURCE, TARGET> {
    
    private final Class<TARGET> targetClass;
    private final Vector<Populator> populators = new Vector<>();
    
    public PopulatingConverter(Class<TARGET> targetClass) {
        this.targetClass = targetClass;
    }
    
    public static <SOURCE,TARGET> PopulatingConverter<SOURCE,TARGET> of(Class<TARGET> targetClass) {
        return new PopulatingConverter<>(targetClass);
    }
    
    public TARGET convert(SOURCE source) {
        TARGET target = createFromClass();
        populators.forEach(populator -> {
            populator.populate(source, target);
        });
        return target;
    }
    
    public Vector<TARGET> convertAll(List<SOURCE> objectsToConvert) {
        Vector<TARGET> convertedList = new Vector<>();
        objectsToConvert.forEach(objectToConvert -> {
            convertedList.add(convert(objectToConvert));
        });
        return convertedList;
    }
    
    private TARGET createFromClass() {
        try {
                return targetClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PopulatingConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public void addPopulator(Populator<SOURCE, TARGET> populator) {
        if (Objects.nonNull(populator)) {
            populators.add(populator);
        }
    }
    public <SOURCE, TARGET> PopulatingConverter<SOURCE, TARGET> withPopulator(Populator<SOURCE, TARGET> populator) {
        if (Objects.nonNull(populator)) {
            populators.add(populator);
        }
        return (PopulatingConverter<SOURCE, TARGET>) this;
    }
}