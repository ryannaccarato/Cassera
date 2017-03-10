package com.example.ryann9309.cassera.Model;

/**
 * Created by JacksonGenerator on 2/28/17.
 */

import com.example.ryann9309.cassera.Model.AvailableLessonsItem;
import com.example.ryann9309.cassera.Model.Coach;
import com.example.ryann9309.cassera.Model.CurrentLesson;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class CurrentSubscription {
    @JsonProperty("currentLesson")
    private CurrentLesson currentLesson;
    @JsonProperty("sportCategory")
    private String sportCategory;
    @JsonProperty("availableLessons")
    public List<AvailableLessonsItem> availableLessons;
    @JsonProperty("subscriptionId")
    private String subscriptionId;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("coach")
    private Coach coach;
    @JsonProperty("sport")
    private String sport;
    @JsonProperty("status")
    private Integer status;
}