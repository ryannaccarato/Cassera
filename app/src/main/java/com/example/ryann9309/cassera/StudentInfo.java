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

    public String[] getAvailableSubscriptions() {
        String[] subs = new String[availableSubscriptions.size()];
        for (int i = 0; i < availableSubscriptions.size(); i++) {
            AvailableSubscriptionsItem item = availableSubscriptions.get(i);
            subs[i] = "Id: " + item.subscriptionId + "\nCategory: " + item.sportCategory + "\nSport: " + item.sport;
        }
        return subs;
    }
}