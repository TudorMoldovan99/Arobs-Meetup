package com.Arobs.Meetup.service.UserService;

import lombok.*;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class UserDTO {

    private String userEmail;
    private String userFullName;
    private String userRole;
    private String userPassword;
    private int userVotes;
}
