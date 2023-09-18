package com.contentdata.rest;

import com.contentdata.config.ContentServiceConfig;
import com.contentdata.dto.ResponseBO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping("/api")
public class ContentDataRest
{


    @Autowired
    ContentServiceConfig contentServiceConfig;

    @GetMapping(value = "/get-new_movie_list")
    public ResponseEntity<ResponseBO>  newMovieList()
    {

        return null;
    }



    @GetMapping("/account/properties")
    public String getPropertyDetails()  {

        return contentServiceConfig.getMsg();

    }

}
