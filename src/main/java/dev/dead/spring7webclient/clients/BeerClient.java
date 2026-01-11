package dev.dead.spring7webclient.clients;

import dev.dead.spring7webclient.model.BeerDTO;
import reactor.core.publisher.Flux;

public interface BeerClient {
    Flux<String> listBeers();

    Flux<BeerDTO> listBeersDto();
}
