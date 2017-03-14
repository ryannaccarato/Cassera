package com.example.ryann9309.cassera.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class CurrentSubscription {
    @JsonProperty("currentLesson")
    public CurrentLesson currentLesson;
    @JsonProperty("sportCategory")
    public String sportCategory;
    @JsonProperty("availableLessons")
    public List<AvailableLessonsItem> availableLessons;
    @JsonProperty("subscriptionId")
    public String subscriptionId;
    @JsonProperty("type")
    public Integer type;
    @JsonProperty("coach")
    public Coach coach;
    @JsonProperty("sport")
    public String sport;
    @JsonProperty("status")
    public Integer status;
}