package com.Arobs.Meetup.service.AttendanceService;

import com.Arobs.Meetup.model.AttendanceEntity;
import com.Arobs.Meetup.repository.AttendanceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AttendanceObject {

    @Autowired
    private AttendanceRepositoryImpl attendanceDAO;

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
    public void saveAttendance(AttendanceDTO theAttendance) throws IOException {


        AttendanceEntity attendance = new AttendanceEntity();
        attendanceMapper.map(theAttendance, attendance);
        attendanceDAO.saveData(attendance);
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
    void updateAttendance(AttendanceDTO theAttendance) {
        AttendanceEntity attendance = new AttendanceEntity();
        attendanceMapper.map(theAttendance, attendance);
        attendanceDAO.updateData(attendance);
    }
}
