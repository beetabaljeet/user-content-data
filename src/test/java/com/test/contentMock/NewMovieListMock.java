package com.test.contentMock;

import com.contentdata.dto.NewMovieList;

public class NewMovieListMock
{

    public static NewMovieList getNewMovieList()
    {
         return  NewMovieList.builder().
                   movieName("Interseteller").
                   movieDuration("2 hour").
                   movieLanguage("English").movieClip(Byte.valueOf("sss")).
                   movieUri("www.test.com").movieType("").build();

    }

}
