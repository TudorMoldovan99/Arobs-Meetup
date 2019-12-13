package com.Arobs.Meetup.Controller;

import com.Arobs.Meetup.Service.EventService.EventService;
import com.Arobs.Meetup.Service.EventService.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class EventController {

    @Qualifier("eventService")
    @Autowired
    private EventService event;
}
