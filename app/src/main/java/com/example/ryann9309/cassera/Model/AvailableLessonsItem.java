package com.example.ryann9309.cassera.Model;

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
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("title")
    public String title;
}