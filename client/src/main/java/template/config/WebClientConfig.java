package template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.resources.LoopResources;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        // Custom connection pool
        ConnectionProvider connectionProvider = ConnectionProvider.builder("custom-conn-pool")
                .maxConnections(200) // adjust based on your concurrency
                .maxIdleTime(Duration.ofSeconds(30))
                .maxLifeTime(Duration.ofMinutes(5))
                .pendingAcquireTimeout(Duration.ofSeconds(5))
                .build();

        // Separate worker threads (so we don't block Netty's event loop)
        LoopResources loopResources = LoopResources.create("webclient-worker", 4, true);

        HttpClient httpClient = HttpClient.create(connectionProvider)
                .runOn(loopResources)
                .responseTimeout(Duration.ofSeconds(10));

        return builder
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}