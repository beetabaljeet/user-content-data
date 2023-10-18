package com.contentdata.client;

import com.contentdata.dto.NewMovieList;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
class ContentCoreFallback implements  ContentCoreFeignClient {

    @Override
    public NewMovieList getCoreNewMoiveList() {
        throw new NoFallbackAvailableException("Boom!", new RuntimeException());
    }

}
