package com.contentdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewMovieList
{

    private String movieName;
    private String movieType;
    private String movieLanguage;
    private String movieDuration;
    private String relaseDate;
    private Byte movieClip;
    private String movieUri;


}
