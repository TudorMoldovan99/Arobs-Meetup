package com.Arobs.Meetup.service.VoteService;


import com.fasterxml.jackson.annotation.JsonCreator;
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
public class VoteDTO {
    @NonNull
    private int userId;
    @NonNull
    private int proposalId;

}
