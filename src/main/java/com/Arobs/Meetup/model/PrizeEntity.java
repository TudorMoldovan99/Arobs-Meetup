package com.Arobs.Meetup.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Prize")
public class PrizeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "prize_id")
    private int prizeId;

    @Column(name = "prize_description") @NonNull
    private String description;

    @Column(name="prize_value")@NonNull
    private int value;

    @OneToMany(mappedBy = "prize" )
    Set<AwardingEntity> awardings;
}
