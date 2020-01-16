package com.Arobs.Meetup.controller;

import com.Arobs.Meetup.service.AttendanceService.AttendanceDTO;
import com.Arobs.Meetup.service.AttendanceService.AttendanceService;
import com.Arobs.Meetup.service.UserService.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/list")
    public ResponseEntity<List<AttendanceDTO>> listAttendances() {
        return  ResponseEntity.ok(attendanceService.findAllAttendances());
    }


    @PostMapping("/saveAttendance")
    public ResponseEntity<String> saveAttendance(@RequestBody AttendanceDTO theAttendance) throws Exception {
        attendanceService.saveAttendance(theAttendance);
        return ResponseEntity.ok("Attendance saved");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteAttendance(@RequestParam("AttendanceId") int theId) {
        attendanceService.removeAttendance(theId);
        return ResponseEntity.ok("Attendance deleted");
    }

    @PostMapping("/updateAttendance")
    public ResponseEntity<String> updateAttendance(@RequestBody AttendanceDTO theAttendance) throws Exception {
        attendanceService.updateAttendance(theAttendance);
        return ResponseEntity.ok("Attendance updated");
    }
}
