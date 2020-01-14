package com.Arobs.Meetup.service.EventService;

import com.Arobs.Meetup.model.EventEntity;
import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class EventMapper {

    @Autowired
    private UserRepositoryImpl userRepository;

    public  void map (EventEntity source , EventDTO destination)
    {
        destination.setDate(source.getDate());
        destination.setEventDescription(source.getEventDescription());
        destination.setEventDifficulty(source.getEventDifficulty());
        destination.setEventDuration(source.getEventDuration());
        destination.setEventLanguage(source.getEventLanguage());
        destination.setEventMaximumNumberOfPeople(source.getEventMaximumNumberOfPeople());
        destination.setEventTitle(source.getEventTitle());
        destination.setRoom(source.getRoom());
        destination.setEventType(source.getEventType());
        destination.setUserId(source.getUser().getUserId());
    }

    public  void map ( EventDTO source, EventEntity destination)
    {
        destination.setDate(source.getDate());
        destination.setEventDescription(source.getEventDescription());
        destination.setEventDifficulty(source.getEventDifficulty());
        destination.setEventLanguage(source.getEventLanguage());
        destination.setEventMaximumNumberOfPeople(source.getEventMaximumNumberOfPeople());
        destination.setEventTitle(source.getEventTitle());
        destination.setEventType(source.getEventType());
        destination.setRoom(source.getRoom());
        destination.setEventDuration(source.getEventDuration());

        UserEntity userEntity =  userRepository.findById(source.getUserId());

        destination.setUser(userEntity);


    }
}
