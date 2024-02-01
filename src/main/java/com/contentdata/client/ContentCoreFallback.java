package com.contentdata.client;

import com.contentdata.dto.NewMovieList;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
class ContentCoreFallback implements  ContentCoreFeignClient {

    @Override
    public List<Object> getCoreNewMoiveList() {
        throw new NoFallbackAvailableException("Boom!", new RuntimeException());
    }

}
