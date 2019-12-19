package com.Arobs.Meetup.service.UserService;

import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserObject userObject;

    @Override
    public void saveUser(UserDTO user) {
        userObject.saveUser(user);
    }

    @Override
    public void removeUser(int userId) {
        userObject.removeUser(userId);
    }

    @Override
    public void updateUser(UserDTO user) {
        //TODO
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userObject.findAllUsers();
    }

    @Override
    public UserDTO findUserById(int id) {
        return userObject.findUserById(id);
    }
}
