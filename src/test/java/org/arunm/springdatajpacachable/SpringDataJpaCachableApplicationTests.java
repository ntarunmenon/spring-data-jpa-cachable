package org.arunm.springdatajpacachable;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SpringDataJpaCachableApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CacheManager caffeineCacheManager;

    @Test
    void testGreeting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting?id=100")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", is(equalTo("Hello darkness"))));

        Greeting cacheValue = caffeineCacheManager.getCache("GreetingsCache")
                .get("100",Greeting.class);
        Assertions.assertEquals(cacheValue.getContent(), "Hello darkness");

    }

}
