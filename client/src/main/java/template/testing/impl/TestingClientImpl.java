package template.testing.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import template.testing.TestingClient;
import template.testing.TestingClientResponseDTO;

@Service
public class TestingClientImpl implements TestingClient {

    private final WebClient webClient;

    public TestingClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com") // base URL here
                .build();
    }

    public TestingClientResponseDTO getOnePost(){
        return webClient.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(TestingClientResponseDTO.class)
                .block();
    }

}
