package com.Arobs.Meetup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Proposal")
public class ProposalEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "proposal_id")
    private int proposalId;
    @Column(name="proposal_title")
    private String proposalTitle;
    @Column(name="proposal_description")
    private String proposalDescription;
    @Column(name="proposal_type")
    private String proposalType;
    @Column(name="proposal_difficulty")
    private String proposalDifficulty;
    @Column(name="proposal_language")
    private String proposalLanguage;
    @Column(name="proposal_duration")
    private String proposalDuration;
    @Column(name="proposal_maximum_number_of_people")
    private int proposalMaximumNumberOfPeople;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

    @OneToMany(mappedBy = "proposal")
    List<VoteEntity> votes;

}
