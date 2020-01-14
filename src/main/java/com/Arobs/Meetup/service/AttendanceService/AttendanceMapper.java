package com.Arobs.Meetup.service.AttendanceService;

import com.Arobs.Meetup.model.AttendanceEntity;
import com.Arobs.Meetup.model.EventEntity;
import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.repository.EventRepositoryImpl;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class AttendanceMapper {

    @Autowired
    UserRepositoryImpl userRepository;

    @Autowired
    EventRepositoryImpl eventRepository;

    public  void map(AttendanceEntity source, AttendanceDTO destination) {
        destination.setComment(source.getComment());
        destination.setNote(source.getNote());
        destination.setUserId(source.getUser().getUserId());
        destination.setEventId(source.getEvent().getEventId());
    }

    public void map(AttendanceDTO source, AttendanceEntity destination) {

        UserEntity userEntity = userRepository.findById(source.getUserId());
        EventEntity eventEntity = eventRepository.findById(source.getEventId());

        destination.setComment(source.getComment());
        destination.setNote(source.getNote());
        destination.setUser(userEntity);
        destination.setEvent(eventEntity);

    }


}
