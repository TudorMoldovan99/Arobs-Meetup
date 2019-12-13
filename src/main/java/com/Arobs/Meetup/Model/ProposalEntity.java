package com.Arobs.Meetup.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProposalEntity {
    private int proposalId;
    private String proposalTitle;
    private String proposalDescription;
    private String proposalType;
    private String proposalDifficulty;
    private String proposalLanguage;
    private String proposalDuration;
    private int proposalMaximumNumberOfPeople;
}
