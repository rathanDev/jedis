package org.jana.springdata.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogApi {

    @RequestMapping("/")
    public String index() {
        return "Greetings from dog api";
    }

}
