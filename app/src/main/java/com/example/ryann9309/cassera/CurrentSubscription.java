package com.example.ryann9309.cassera;

/**
 * Created by JacksonGenerator on 2/23/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;
import java.util.List;


public class CurrentSubscription {
    @JsonProperty("currentLesson")
    private JSONObject currentLesson;
    @JsonProperty("sportCategory")
    private String sportCategory;
    @JsonProperty("availableLessons")
    private List availableLessons;
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