package com.Arobs.Meetup.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "User")
public class UserEntity {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_full_name") @NonNull
    private String userFullName;
    @Column(name = "user_password") @NonNull
    private String userPassword;
    @Column(name="user_role") @NonNull
    private String userRole;
    @Column(name="user_votes") @NonNull
    private int userVotes;
    @Column(name="user_email") @NonNull
    private String userEmail;

    @OneToMany(mappedBy = "user")
    Set<ProposalEntity> proposals;

    @OneToMany(mappedBy = "user")
    Set<EventEntity> events;

    @OneToMany(mappedBy = "user")
    Set<AttendanceEntity> attendances;

    @OneToMany(mappedBy = "user")
    Set<VoteEntity> votes;

    @OneToMany(mappedBy = "user" )
    Set<AwardingEntity> awardings;



}

