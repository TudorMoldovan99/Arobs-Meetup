package com.Arobs.Meetup.service.UserService;

import com.Arobs.Meetup.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    void saveUser(UserDTO user);

    void removeUser(int userId);

    void updateUser(UserDTO user);

    List<UserDTO> findAllUsers();

    UserDTO findUserById(int id);


}
