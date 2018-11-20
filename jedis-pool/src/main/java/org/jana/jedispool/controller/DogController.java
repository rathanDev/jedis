package org.jana.jedispool.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {

    @GetMapping("/")
    public String index() {
        return "Greetings from jedis connection pool app";
    }

}
