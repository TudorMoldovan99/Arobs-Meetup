package com.Arobs.Meetup.model;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Vote")
public class VoteEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "vote_id")
    private int voteId;

    @ManyToOne
    @JoinColumn(name="user_id" , nullable = false) @NonNull
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="proposal_id", nullable = false) @NonNull
    private ProposalEntity proposal;



}
