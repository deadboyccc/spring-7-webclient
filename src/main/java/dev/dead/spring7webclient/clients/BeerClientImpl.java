package dev.dead.spring7webclient.clients;

import dev.dead.spring7webclient.model.BeerDTO;
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
                        .baseUrl("http://127.0.0.1:8080")
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

    @Override
    public Flux<BeerDTO> listBeersDto() {
        return
                webClient.get()
                        .uri("api/v2/beer")
                        .retrieve()
                        .bodyToFlux(BeerDTO.class);
    }
}
