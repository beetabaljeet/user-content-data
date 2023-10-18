package com.contentdata.rest;

import com.contentdata.config.ContentServiceConfig;
import com.contentdata.dto.NewMovieList;
import com.contentdata.dto.ResponseBO;
import com.contentdata.service.ContentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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


    @Retry(name="retryNewMovieList", fallbackMethod = "getfallbackMethodNewMovieList")
    @GetMapping(value = "/get-new_movie_list")
    public ResponseEntity<ResponseBO<NewMovieList>> newMovieList()
    {
      NewMovieList newMovieList =  contentService.getNewMovieList();
      return  sendResponse(newMovieList);

    }
    ResponseEntity<String>  getfallbackMethodNewMovieList(Throwable throwable)
    {
          return  ResponseEntity.status(HttpStatus.OK).body("0.9");
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails()  {

        return contentServiceConfig.getMsg();

    }

}
