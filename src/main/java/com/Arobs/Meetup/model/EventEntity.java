package com.Arobs.Meetup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="`Event`")
public class EventEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "event_id")
    private int eventId;
    @Column(name = "event_title")
    private String eventTitle;
    @Column(name="event_description")
    private String eventDescription;
    @Column(name="event_type")
    private String eventType;
    @Column(name="event_difficulty")
    private String eventDifficulty;
    @Column(name="event_language")
    private String eventLanguage;
    @Column(name="event_duration")
    private String eventDuration;
    @Column(name="event_maximum_number_of_people")
    private int eventMaximumNumberOfPeople;
    @Column(name="event_date")
    private Date date;
    @Column(name="event_room")
    private String room;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "event")
    Set<AttendanceEntity> attendances;


}
