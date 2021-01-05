package org.arunm.springdatajpacachable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private GreetingRepository greetingRepository;

    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "id") String id) {
        return greetingRepository
                .findById(id)
                .orElseThrow(IllegalStateException::new);
    }
}
