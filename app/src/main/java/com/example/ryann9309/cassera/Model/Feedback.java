package com.example.ryann9309.cassera.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feedback {
    @JsonProperty("message")
    public String message;
    @JsonProperty("submittedOn")
    public String submittedOn;
    @JsonProperty("videoURL")
    public String videoURL;
}
