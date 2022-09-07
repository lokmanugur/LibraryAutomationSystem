/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurtech.library.facadesvector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Lokman Ugur <lokman.ugur@hotmail.com>
 * @param <TARGET>
 * @param <SOURCE>
 */
public class PopulatingConverter<SOURCE, TARGET> {
    
    private final Class<TARGET> targetClass;
    
    private final List<Populator> populators = new ArrayList<>();
    public PopulatingConverter(Class<TARGET> targetClass) {
        this.targetClass = targetClass;
    }
    public static <SOURCE, TARGET> PopulatingConverter<SOURCE, TARGET> of(Class<TARGET> targetClass) {
        return new PopulatingConverter<>(targetClass);
    }
    
    public TARGET convert(SOURCE source) {
        TARGET target = createFromClass();
        populators.forEach(populator -> {
            populator.populate(source, target);
        });
        
        return target;
    }
    
    public List<TARGET> convertAll(List<SOURCE> objectsToConvert) {
        List<TARGET> convertedList = new ArrayList<>();
        objectsToConvert.forEach(objectToConvert -> {
            convertedList.add(convert(objectToConvert));
        });
        return convertedList;
    }
    
    private TARGET createFromClass() {
        try {
            return targetClass.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
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