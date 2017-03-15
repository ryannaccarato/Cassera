package com.example.ryann9309.cassera.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;
import java.util.List;

public class StudentAssignmentsItem {
    @JsonProperty("isDenied")
    public Boolean isDenied;
    @JsonProperty("studentFeedback")
    public List<Feedback> studentFeedback;
    @JsonProperty("uploadUrl")
    public JSONObject uploadUrl;
    @JsonProperty("completedOn")
    public JSONObject completedOn;
    @JsonProperty("description")
    public String description;
    @JsonProperty("reasonDenied")
    public JSONObject reasonDenied;
    @JsonProperty("title")
    public String title;
    @JsonProperty("assignmentId")
    public String assignmentId;
    @JsonProperty("createdOn")
    public String createdOn;
}