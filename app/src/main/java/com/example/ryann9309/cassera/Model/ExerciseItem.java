package com.example.ryann9309.cassera.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExerciseItem {
    @JsonProperty("curcuitsCompleted")
    public int curcuitsCompleted;
    @JsonProperty("description")
    public String description;
    @JsonProperty("exampleVideoURL")
    public String exampleVideoURL;
    @JsonProperty("exerciseId")
    public String exerciseId;
    @JsonProperty("notes")
    public String notes;
    @JsonProperty("numberOfCircuits")
    public int numberOfCircuits;
    @JsonProperty("numberOfReps")
    public int numberOfReps;
    @JsonProperty("numberOfSets")
    public int numberOfSets;
    @JsonProperty("studentComments")
    public String studentComments;
}
