package com.contentdata.service;

import com.contentdata.client.ContentCoreFeignClient;
import com.contentdata.dto.NewMovieList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContentServiceImpl implements  ContentService {

    @Autowired
    private ContentCoreFeignClient contentCoreFeignClient;


    @Override
    public NewMovieList getNewMovieList() {
      return  contentCoreFeignClient.getCoreNewMoiveList();
    }
}
