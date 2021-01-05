package org.arunm.springdatajpacachable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringDataJpaCachableApplication implements CommandLineRunner {

    @Autowired
    private GreetingRepository greetingRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaCachableApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        greetingRepository.save(new Greeting("100","Hello darkness"));
        greetingRepository.save(new Greeting("200","Hello light"));
    }
}
