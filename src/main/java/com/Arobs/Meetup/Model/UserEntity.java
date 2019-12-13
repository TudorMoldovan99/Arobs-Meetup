package com.Arobs.Meetup.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class UserEntity {
    private int userId;
    private String userFullName;
    private String userPassword;
    private String userRole;
    private int userVotes;
}

