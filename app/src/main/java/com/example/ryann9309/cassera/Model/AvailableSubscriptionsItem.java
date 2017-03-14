package com.example.ryann9309.cassera.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AvailableSubscriptionsItem {
    @JsonProperty("sportCategory")
    public String sportCategory;
    @JsonProperty("subscriptionId")
    public String subscriptionId;
    @JsonProperty("sport")
    public String sport;
}