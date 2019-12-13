package com.Arobs.Meetup.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {
    private int eventId;
    private String eventTitle;
    private String eventDescription;
    private String eventType;
    private String eventDifficulty;
    private String eventLanguage;
    private String eventDuration;
    private int eventMaximumNumberOfPeople;


}
