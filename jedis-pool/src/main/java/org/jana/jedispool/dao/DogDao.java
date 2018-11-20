package org.jana.jedispool.dao;

import org.jana.jedispool.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Repository
@Transactional
public class DogDao {

    private static final String KEY = "dog";

    @Autowired
    private RedisTemplate<String, Dog> redisTemplate;

    private ListOperations<String, Dog> listOperations;

    @PostConstruct
    public void init() {
        listOperations = redisTemplate.opsForList();
    }

    public void addDog(Dog dog) {
        listOperations.leftPush(KEY, dog);
    }

    public long getSize() {
        return listOperations.size(KEY);
    }

    public Dog getAtIndex(int index) {
        return listOperations.index(KEY, index);
    }

    public void remove(Dog dog) {
        listOperations.remove(KEY, 1, dog);
    }

}
