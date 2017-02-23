package com.example.ryann9309.cassera;

/**
 * Created by JacksonGenerator on 2/23/17.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class StudentInfo {
    @JsonProperty("currentSubscription")
    private CurrentSubscription currentSubscription;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("availableSubscriptions")
    private List<AvailableSubscriptionsItem> availableSubscriptions;
}