package com.example.ryann9309.cassera.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class StudentInfo {
    @JsonProperty("currentSubscription")
    public CurrentSubscription currentSubscription;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("availableSubscriptions")
    public List<AvailableSubscriptionsItem> availableSubscriptions;
}