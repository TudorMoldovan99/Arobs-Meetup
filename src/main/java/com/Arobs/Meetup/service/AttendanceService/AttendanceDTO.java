package com.Arobs.Meetup.service.AttendanceService;


import lombok.*;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Component
@JsonComponent
public class AttendanceDTO {

    private String comment;

    private int note;

    @NonNull
    private int userId;

    @NonNull
    private int eventId;
}
