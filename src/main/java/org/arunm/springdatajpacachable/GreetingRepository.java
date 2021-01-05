package org.arunm.springdatajpacachable;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, String> {

    @Override
    @Cacheable("GreetingsCache")
    Optional<Greeting> findById(String s);
}
