package com.Arobs.Meetup.service.AwardingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class AwardingDTO {


    private Date date;

    private int numberOfPoints;

    private int userId;

    private int prizeId;
}
