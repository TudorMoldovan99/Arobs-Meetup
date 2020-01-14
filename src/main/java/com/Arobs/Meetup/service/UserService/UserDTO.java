package com.Arobs.Meetup.service.UserService;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@JsonComponent

public class UserDTO {

    private String userEmail;
    private String userFullName;
    private String userRole;
    private String userPassword;
    private int userVotes;

}
