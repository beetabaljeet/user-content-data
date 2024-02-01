package com.contentdata.client;


import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService
{
    private final WebClient webClient;

    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("localhost:8083/corecontent/api/video/testviedo").build();
    }

    public Mono<Resource> playMovies(String tital){
        return this.webClient.get().uri("/video/{tital}",tital).header(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_RELATED_VALUE)
                .retrieve()
                .bodyToMono(Resource.class);
    }




}
