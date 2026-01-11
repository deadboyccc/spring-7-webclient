package dev.dead.spring7webclient.clients;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class BeerClientImpl implements BeerClient {
    private final WebClient webClient;

    public BeerClientImpl() {
        this.webClient =
                WebClient.builder()
                        .baseUrl("http://localhost:8080")
                        .build();
    }


    @Override
    public Flux<String> listBeers() {
        return webClient.get()
                .uri("api/v2/beer", String.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(String.class);

    }
}
