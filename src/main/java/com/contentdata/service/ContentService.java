package com.contentdata.service;

import com.contentdata.dto.NewMovieList;
import reactor.core.publisher.Flux;

public interface ContentService
{

      public NewMovieList getNewMovieList();

}
