package com.Arobs.Meetup.service.UserService;

import com.Arobs.Meetup.model.UserEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface UserService {


    void saveUser(UserDTO user) throws Exception;

    void removeUser(int userId);

    void updateUser(UserDTO user);

    List<UserDTO> findAllUsers();

    UserDTO findUserById(int id);

    UserDTO findByEmailAndPassword(String email, String password) throws Exception;


    void addPointsToUser(String email, int numberOfPoints) throws Exception;
}
