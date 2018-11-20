package org.jana.jedispool.service;

import org.jana.jedispool.dao.DogDao;
import org.jana.jedispool.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    @Autowired
    private DogDao dogDao;

    public String aMethod() {
        return "aValue";
    }

    public void addDog(Dog dog) {
        dogDao.addDog(dog);
    }

}
