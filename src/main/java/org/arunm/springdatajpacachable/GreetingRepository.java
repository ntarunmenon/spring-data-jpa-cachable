package org.arunm.springdatajpacachable;

import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting, String> {
}
