package org.jana.springdata.api;

import org.jana.springdata.model.Dog;
import org.jana.springdata.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class DogApi {

    @Autowired
    private DogRepository dogRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from dog api";
    }

    @PostMapping("/add-name")
    public ResponseEntity<String> add(@RequestParam String key,
                                         @RequestParam String value) {
        Dog dog = new Dog();
        dog.setId(key);
        dog.setName(value);
        dogRepository.addName(dog);
        System.out.println("dog = " + dog);
        return ResponseEntity.ok("Barked");
    }

    @PostMapping("/add-dog")
    public ResponseEntity<String> addDog(@RequestParam String key,
                                         @RequestParam String value) {
        Dog dog = new Dog();
        dog.setId(key);
        dog.setName(value);
        dogRepository.addDog(dog);
        System.out.println("dog = " + dog);
        return ResponseEntity.ok("Barked");
    }

    @GetMapping("/find-all")
    public Map<String, String> findAll() {
        Map<Object, Object> dogMap = dogRepository.findAll();
        System.out.println("dogMap = " + dogMap);
        return dogMap
                .entrySet()
                .stream()
                .map(e -> {
                    String key = (String) e.getKey();
                    String val = dogMap.get(key).toString();
                    return new AbstractMap.SimpleEntry<>(key, val);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @GetMapping("/get-name")
    public String getName(@RequestParam String id) {
        return dogRepository.getName(id);
    }

    @GetMapping("/get-dog")
    public Dog getDog(@RequestParam String id) {
        return dogRepository.getDog(id);
    }

    @PostMapping("/chase-out")
    public String chaseOut(@RequestParam String id) {
        dogRepository.delete(id);
        return "Chased";
    }

}
