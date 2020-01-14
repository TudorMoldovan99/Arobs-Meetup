package com.Arobs.Meetup.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class EventServiceImpl implements  EventService {

    @Autowired
    private EventObject eventObject;

    @Override
    public void saveEvent(EventDTO theEvent) throws IOException {
        eventObject.saveEvent(theEvent);
    }

    @Override
    public void removeEvent(int eventId) {
        eventObject.removeEvent(eventId);
    }

    @Override
    public void updateEvent(EventDTO event) {
        eventObject.updateEvent(event);
    }

    @Override
    public List<EventDTO> findAllEvents() {
        return eventObject.findAllEvents();
    }

    @Override
    public EventDTO findEventById(int id) {
        return eventObject.findEventById(id);
    }
}
