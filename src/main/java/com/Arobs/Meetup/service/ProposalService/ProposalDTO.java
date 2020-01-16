package com.Arobs.Meetup.service.ProposalService;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent
public class ProposalDTO  {


    private String proposalTitle;

    private String proposalDescription;

    private String proposalType;

    private String proposalDifficulty;

    private String proposalLanguage;

    private String proposalDuration;

    private int proposalMaximumNumberOfPeople;

    private int userId;
}
