package com.Arobs.Meetup.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceObject attendanceObject;

    @Override
    public void saveAttendance(AttendanceDTO theAttendance) throws IOException {
        attendanceObject.saveAttendance(theAttendance);
    }

    @Override
    public void removeAttendance(int attendanceId) {
        attendanceObject.removeAttendance(attendanceId);
    }

    @Override
    public void updateAttendance(AttendanceDTO attendance) {
        attendanceObject.updateAttendance(attendance);
    }

    @Override
    public List<AttendanceDTO> findAllAttendances() {
        return attendanceObject.findAllAttendances();
    }

    @Override
    public AttendanceDTO findAttendanceById(int id) {
        return attendanceObject.findAttendanceById(id);
    }
}
