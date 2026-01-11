package dev.dead.spring7webclient.clients;

import reactor.core.publisher.Flux;

public interface BeerClient {
    Flux<String> listBeers();
}
