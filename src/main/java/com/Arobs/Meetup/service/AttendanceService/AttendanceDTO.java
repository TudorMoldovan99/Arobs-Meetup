package com.Arobs.Meetup.service.AttendanceService;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class AttendanceDTO {

    private String comment;

    private int note;


    private int userId;


    private int eventId;
}
