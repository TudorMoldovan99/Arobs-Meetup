package com.Arobs.Meetup.model;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Attendance")
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "attendance_id")
    private int attendanceId;
    @Column(name = "comment")
    private String comment;
    @Column(name="note")
    private int note;

    @ManyToOne
    @JoinColumn(name="user_id" , nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="event_id", nullable = false)
    private EventEntity event;

}
