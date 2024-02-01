package com.contentdata.rest;

import com.contentdata.client.WebClientService;
import com.contentdata.config.ContentServiceConfig;
import com.contentdata.dto.NewMovieList;
import com.contentdata.dto.ResponseBO;
import com.contentdata.service.ContentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Properties;
import java.util.function.Function;

@RestController
@RequestMapping("/api")
public class ContentDataRest  extends  GenericController
{

    @Autowired
    ContentService  contentService;

    @Autowired
    ContentServiceConfig contentServiceConfig;

    @Autowired
    WebClientService webClientService;


    @Retry(name="retryNewMovieList", fallbackMethod = "getfallbackMethodNewMovieList")
    @GetMapping(value = "/get-new_movie_list")
    public ResponseEntity<ResponseBO<Object>> newMovieList()
    {
      List<Object> newMovieList =  contentService.getNewMovieList();
      return  sendResponse(newMovieList);
    }
    ResponseEntity<String>  getfallbackMethodNewMovieList(Throwable throwable) {
        return ResponseEntity.status(HttpStatus.OK).body("There is some technical issue in server code");
    }

    @GetMapping(value = "/play_movie/{moviename}" ,produces = "video/mp4")
    public Mono<Resource> playMovie(@PathVariable(name = "moviename") String movieName)
    {
        return contentService.playmovie(movieName);
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails()  {

        return contentServiceConfig.getMsg();
    }


}
