package org.jana.jedispool.controller;

import org.jana.jedispool.model.Dog;
import org.jana.jedispool.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/")
    public String index() {
        return "Greetings from jedis connection pool app";
    }

    @PostMapping("/add")
    public String addDog(@RequestParam String id,
                         @RequestParam String name,
                         @RequestParam String breed) {
        Dog dog = new Dog(Integer.parseInt(id), name, breed);
        dogService.addDog(dog);
        return "It barked when adding";
    }

    @GetMapping("/get-all")
    public List<Dog> getAll() {
        return dogService.getAll();
    }

}
