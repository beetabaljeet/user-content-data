package com.contentdata.client;


import com.contentdata.dto.NewMovieList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Flux;

@FeignClient(name = "corecontent", url = "http://localhost:8082", fallback = ContentCoreFallback.class)
 public interface ContentCoreFeignClient
{
 @RequestMapping(method = RequestMethod.GET, value = "corecontent/api/get-new_movie_list")
 NewMovieList  getCoreNewMoiveList();




}
