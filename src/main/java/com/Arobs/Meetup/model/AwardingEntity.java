package com.Arobs.Meetup.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Awarding_History")
public class AwardingEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "attendance_id")
    private int awardingId;

    @Column(name="awarding_date") @NonNull
    private Date date;

    @Column(name="number_of_points") @NonNull
    private int numberOfPoints;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="prize_id", nullable=false)
    private PrizeEntity prize;

}
