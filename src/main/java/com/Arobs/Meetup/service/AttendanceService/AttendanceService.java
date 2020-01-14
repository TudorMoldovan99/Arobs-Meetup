package com.Arobs.Meetup.service.AttendanceService;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface AttendanceService {

    void saveAttendance(AttendanceDTO Attendance) throws IOException;

    void removeAttendance(int AttendanceId);

    void updateAttendance(AttendanceDTO Attendance);

    List<AttendanceDTO> findAllAttendances();

    AttendanceDTO findAttendanceById(int id);
}
