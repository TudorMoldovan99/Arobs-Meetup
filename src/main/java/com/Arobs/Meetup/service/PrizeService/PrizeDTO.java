package com.Arobs.Meetup.service.PrizeService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class PrizeDTO {

    private String prizeDescription;

    @NonNull
    private int prizeValue;

}


