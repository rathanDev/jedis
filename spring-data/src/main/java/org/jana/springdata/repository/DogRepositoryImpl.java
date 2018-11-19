package org.jana.springdata.repository;

import org.jana.springdata.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class DogRepositoryImpl implements DogRepository {

    private static final String KEY = "dog";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public DogRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        this.hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public Map<Object, Object> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void add(Dog dog) {
        this.hashOperations.put(KEY, dog.getId(), dog.getName());
    }

}
