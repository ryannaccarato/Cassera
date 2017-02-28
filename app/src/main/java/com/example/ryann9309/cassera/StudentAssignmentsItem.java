package com.example.ryann9309.cassera;

/**
 * Created by JacksonGenerator on 2/28/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;

import java.util.List;


public class StudentAssignmentsItem {
    @JsonProperty("isDenied")
    private Boolean isDenied;
    @JsonProperty("studentFeedback")
    private List studentFeedback;
    @JsonProperty("uploadUrl")
    private JSONObject uploadUrl;
    @JsonProperty("completedOn")
    private JSONObject completedOn;
    @JsonProperty("description")
    private String description;
    @JsonProperty("reasonDenied")
    private JSONObject reasonDenied;
    @JsonProperty("title")
    private String title;
    @JsonProperty("assignmentId")
    private String assignmentId;
    @JsonProperty("createdOn")
    private String createdOn;
}