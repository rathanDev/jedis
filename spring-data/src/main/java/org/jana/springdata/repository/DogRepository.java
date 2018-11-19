package org.jana.springdata.repository;

import org.jana.springdata.model.Dog;

import java.util.Map;

public interface DogRepository {

    Map<Object, Object> findAll();

    void add(Dog dog);

}
