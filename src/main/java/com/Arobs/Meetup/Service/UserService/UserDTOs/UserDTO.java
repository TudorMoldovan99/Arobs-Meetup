package com.Arobs.Meetup.Service.UserService.UserDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private String userEmail;
    private String userFullName;
    private String userRole;
    private String userPassword;
}
