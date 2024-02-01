package com.contentdata.service;

import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ContentService
{

      public List<Object> getNewMovieList();

      public Mono<Resource> playmovie(String movieName);




}
