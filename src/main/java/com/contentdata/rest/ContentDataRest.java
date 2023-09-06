package com.contentdata.rest;

import com.contentdata.dto.ResponseBO;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "api")
public class ContentDataRest
{

    @GetMapping("/get-new_movie_list")
    public ResponseEntity<ResponseBO>  newMovieList(HttpRequest httpRequest)
    {

        return null;
    }
}
