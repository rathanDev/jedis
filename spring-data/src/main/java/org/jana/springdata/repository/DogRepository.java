package org.jana.springdata.repository;

import org.jana.springdata.model.Dog;

import java.util.Map;

public interface DogRepository {

    Map<Object, Object> findAll();

    void addName(Dog dog);

    void addDog(Dog dog);

    void delete(String id);

    String getName(String id);

    Dog getDog(String id);

}
