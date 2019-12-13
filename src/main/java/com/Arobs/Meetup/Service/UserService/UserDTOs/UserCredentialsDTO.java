package com.Arobs.Meetup.Service.UserService.UserDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentialsDTO {

    private String userEmail;
    private String Password;
}
