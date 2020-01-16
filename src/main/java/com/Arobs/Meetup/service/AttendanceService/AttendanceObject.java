package com.Arobs.Meetup.service.AttendanceService;

import com.Arobs.Meetup.model.AttendanceEntity;
import com.Arobs.Meetup.model.EventEntity;
import com.Arobs.Meetup.repository.AttendanceRepositoryImpl;
import com.Arobs.Meetup.repository.EventRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class AttendanceObject {

    @Autowired
    private AttendanceRepositoryImpl attendanceDAO;

    @Autowired
    private EventRepositoryImpl eventDAO;

    @Autowired
    private AttendanceMapper attendanceMapper;


    @Transactional
    public List<AttendanceDTO> findAllAttendances() {
        List<AttendanceDTO> theAttendancesList = new ArrayList<AttendanceDTO>();

        for (AttendanceEntity currentAttendance : attendanceDAO.findAll()) {
            AttendanceDTO currentAttendanceDTO = new AttendanceDTO();
            attendanceMapper.map(currentAttendance, currentAttendanceDTO);
            theAttendancesList.add(currentAttendanceDTO);
        }
        return theAttendancesList;
    }


    @Transactional
    public void saveAttendance(AttendanceDTO theAttendance) throws Exception {

        AttendanceEntity attendanceEntity = attendanceDAO.findByUserIdAndEventId(theAttendance.getUserId(), theAttendance.getEventId());
        if (attendanceEntity != null)
            throw new Exception("User already attends the event!");

        AttendanceEntity attendance = new AttendanceEntity();
        attendanceMapper.map(theAttendance, attendance);
        attendanceDAO.saveData(attendance);

        EventEntity eventEntity = eventDAO.findById(theAttendance.getEventId());
        eventEntity.setEventMaximumNumberOfPeople(eventEntity.getEventMaximumNumberOfPeople() - 1);
        eventDAO.updateData(eventEntity);
    }


    @Transactional
    public AttendanceDTO findAttendanceById(int theId) {
        AttendanceEntity Attendance = attendanceDAO.findById(theId);
        AttendanceDTO theAttendance = new AttendanceDTO();
        attendanceMapper.map(Attendance, theAttendance);
        return theAttendance;
    }

    @Transactional
    public void removeAttendance(int theId) {
        attendanceDAO.removeData(theId);
    }

    @Transactional
    public void updateAttendance(AttendanceDTO theAttendance) throws Exception {

        AttendanceEntity attendanceEntity = attendanceDAO.findByUserIdAndEventId(theAttendance.getUserId(), theAttendance.getEventId());
        if (attendanceEntity == null)
            throw new Exception("User does not attend the event!");

        attendanceEntity.setNote(theAttendance.getNote());
        attendanceEntity.setComment(theAttendance.getComment());
        attendanceDAO.updateData(attendanceEntity);
    }

}
