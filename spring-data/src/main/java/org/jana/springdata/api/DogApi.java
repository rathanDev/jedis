package org.jana.springdata.api;

import org.jana.springdata.model.Dog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogApi {

    @RequestMapping("/")
    public String index() {
        return "Greetings from dog api";
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestParam String key, @RequestParam String value) {
        Dog dog = new Dog();
        dog.setId(key);
        dog.setName(value);
        System.out.println("dog = " + dog);
        return ResponseEntity.ok("Barked");
    }

}
