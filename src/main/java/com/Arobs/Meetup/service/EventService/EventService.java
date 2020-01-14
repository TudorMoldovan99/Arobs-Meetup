package com.Arobs.Meetup.service.EventService;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface EventService {

    void saveEvent(EventDTO Event) throws IOException;

    void removeEvent(int EventId);

    void updateEvent(EventDTO Event);

    List<EventDTO> findAllEvents();

    EventDTO findEventById(int id);
}
