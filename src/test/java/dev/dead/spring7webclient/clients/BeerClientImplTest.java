package dev.dead.spring7webclient.clients;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest()
class BeerClientImplTest {
    @Autowired
    BeerClient beerClient;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listBeers() {
        val result = beerClient.listBeers()
                .blockLast();
        assertNotNull(result);

    }

    @Test
    void listBeersDto() {
        AtomicBoolean result = new AtomicBoolean(false);
        beerClient.listBeersDto()
                .subscribe(beer -> {
                    System.out.println(beer.getBeerName());
                    result.set(true);
                });

        await().untilTrue(result);
    }
}