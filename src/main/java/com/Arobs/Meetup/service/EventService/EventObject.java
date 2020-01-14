package com.Arobs.Meetup.service.EventService;

import com.Arobs.Meetup.model.EventEntity;
import com.Arobs.Meetup.repository.EventRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventObject {

    @Autowired
    private EventRepositoryImpl EventDAO;

    @Autowired
    private EventMapper eventMapper;


    @Transactional
    public List<EventDTO> findAllEvents() {
        List<EventDTO> theEventsList = new ArrayList<EventDTO>();

        for (EventEntity currentEvent : EventDAO.findAll())
        {
            EventDTO currentEventDTO = new EventDTO();
            eventMapper.map(currentEvent,currentEventDTO);
            theEventsList.add(currentEventDTO);
        }
        return theEventsList;
    }


    @Transactional
    public void saveEvent(EventDTO theEvent) throws IOException {


        EventEntity Event = new EventEntity();
        eventMapper.map(theEvent,Event);
        EventDAO.saveData(Event);
    }


    @Transactional
    public EventDTO findEventById(int theId) {
        EventEntity Event = EventDAO.findById(theId);
        EventDTO theEvent = new EventDTO();
        eventMapper.map(Event,theEvent);
        return theEvent;
    }

    @Transactional
    public void removeEvent(int theId) {
        EventDAO.removeData(theId);
    }

    @Transactional
    void updateEvent(EventDTO theEvent){
        EventEntity event = new EventEntity();
        eventMapper.map(theEvent,event);
        EventDAO.updateData(event);
    }

}
