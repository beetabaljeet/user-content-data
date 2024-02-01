package com.contentdata.service;

import com.contentdata.client.ContentCoreFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ContentServiceImpl implements  ContentService {

    @Autowired
    private ContentCoreFeignClient contentCoreFeignClient;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<Object> getNewMovieList()
    {
      return  contentCoreFeignClient.getCoreNewMoiveList();
    }

    @Override
    public Mono<Resource> playmovie(String tital)
    {
        String FORMAT = "classpath:videos/%s.mp4";
        return Mono.fromSupplier(() -> this.resourceLoader.getResource(String.format(FORMAT,tital)));

    }




}
