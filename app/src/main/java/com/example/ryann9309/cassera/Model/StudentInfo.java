package com.example.ryann9309.cassera.Model;

/**
 * Created by JacksonGenerator on 2/28/17.
 */

import com.example.ryann9309.cassera.Model.AvailableLessonsItem;
import com.example.ryann9309.cassera.Model.AvailableSubscriptionsItem;
import com.example.ryann9309.cassera.Model.CurrentSubscription;
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
        int size = currentSubscription.availableLessons.size();
        String[] lessons = new String[size];
        for (int i = 0; i < size; i++) {
            AvailableLessonsItem item = currentSubscription.availableLessons.get(i);
            lessons[i] = "Id: " + item.lessonId + "\nNumber: " + item.lessonNumber;
        }
        return lessons;
    }
}