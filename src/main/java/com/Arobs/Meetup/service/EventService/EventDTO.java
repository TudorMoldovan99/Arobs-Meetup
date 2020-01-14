package com.Arobs.Meetup.service.EventService;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class EventDTO {

    private String eventTitle;

    private String eventDescription;

    private String eventType;

    private String eventDifficulty;

    private String eventLanguage;

    private String eventDuration;

    private int eventMaximumNumberOfPeople;

    private Date date;

    private String room;

    private int userId;

}
