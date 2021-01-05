package org.arunm.springdatajpacachable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Greeting {

    @Id
    private String id;
    private String content;

    public Greeting(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public Greeting() {

    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
