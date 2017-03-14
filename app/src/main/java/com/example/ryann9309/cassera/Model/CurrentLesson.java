package com.example.ryann9309.cassera.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;
import java.util.List;


public class CurrentLesson {
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("completedOn")
    public JSONObject completedOn;
    @JsonProperty("studentAssignments")
    public List<StudentAssignmentsItem> studentAssignments;
    @JsonProperty("studentExercises")
    public List<ExerciseItem> studentExercises;
    @JsonProperty("title")
    public String title;
    @JsonProperty("createdOn")
    public String createdOn;
    @JsonProperty("status")
    public Integer status;
}