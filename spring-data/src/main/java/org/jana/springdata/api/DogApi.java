package org.jana.springdata.api;

import org.jana.springdata.model.Dog;
import org.jana.springdata.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DogApi {

    @Autowired
    private DogRepository dogRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from dog api";
    }

    // localhost:8090/insert?key=m&value=milo
    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestParam String key, @RequestParam String value) {
        Dog dog = new Dog();
        dog.setId(key);
        dog.setName(value);
        System.out.println("dog = " + dog);
        return ResponseEntity.ok("Barked");
    }

    // localhost:8090/find-all
    @GetMapping("/find-all")
    public Map<String, String> findAll() {
        Map<Object, Object> all = dogRepository.findAll();
        System.out.println("all = " + all);
        return new HashMap<>();
    }

}
