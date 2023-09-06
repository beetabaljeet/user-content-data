package com.contentdata.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBO<T> {
    @JsonProperty("data")
    T data;

    @JsonProperty("errors")
    List<ErrorBO> errors;

    @JsonProperty("status")
    String status;
}
