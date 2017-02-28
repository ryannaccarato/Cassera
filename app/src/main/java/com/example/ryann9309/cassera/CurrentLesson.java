package com.example.ryann9309.cassera;

/**
 * Created by JacksonGenerator on 2/28/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;

import java.util.List;


public class CurrentLesson {
    @JsonProperty("studentExercises")
    private List studentExercises;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("completedOn")
    private JSONObject completedOn;
    @JsonProperty("studentAssignments")
    private List<StudentAssignmentsItem> studentAssignments;
    @JsonProperty("title")
    private String title;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("status")
    private Integer status;
}