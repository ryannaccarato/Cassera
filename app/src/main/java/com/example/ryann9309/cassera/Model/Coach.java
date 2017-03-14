package com.example.ryann9309.cassera.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coach {
    @JsonProperty("avatarUri")
    public String avatarUri;
    @JsonProperty("name")
    public String name;
}