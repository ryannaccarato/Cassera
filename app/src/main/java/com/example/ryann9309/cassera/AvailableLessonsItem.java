package com.example.ryann9309.cassera;

/**
 * Created by JacksonGenerator on 2/28/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;


public class AvailableLessonsItem {
    @JsonProperty("lessonNumber")
    public Integer lessonNumber;
    @JsonProperty("completedOn")
    public String completedOn;
    @JsonProperty("lessonId")
    public String lessonId;
    @JsonProperty("createdOn")
    public String createdOn;
    @JsonProperty("status")
    public Integer status;
}