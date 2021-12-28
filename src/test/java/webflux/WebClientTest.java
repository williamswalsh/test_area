package webflux;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class WebClientTest {

    @Test
    public void test() {
        WebClient webClient;

        // webClient.post()
        //         .uri(organisation.getUrl() + SEARCH_URL)
        //         .contentType(MediaType.APPLICATION_JSON)
        //         .accept(MediaType.APPLICATION_JSON)
        //         .header(AUTHORIZATION, "BASIC: " + organisation.getServiceAccount().encodeCredentialsBase64())
        //         .bodyValue(request)
        //         .retrieve()
        //         .onStatus(HttpStatus::isError, this::processErrorResponse)
        //         .bodyToMono(VerificationResponse.class).block();
    }
}
