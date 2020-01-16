package com.Arobs.Meetup.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;
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
    List<ProposalEntity> proposals;

    @OneToMany(mappedBy = "user")
    List<EventEntity> events;

    @OneToMany(mappedBy = "user")
    List<AttendanceEntity> attendances;

    @OneToMany(mappedBy = "user")
    List<VoteEntity> votes;

    @OneToMany(mappedBy = "user" )
    List<AwardingEntity> awardings;



}

