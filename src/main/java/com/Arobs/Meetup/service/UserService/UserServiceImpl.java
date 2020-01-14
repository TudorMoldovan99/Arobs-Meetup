package com.Arobs.Meetup.service.UserService;

import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserObject userObject;

    @Override
    public void saveUser(UserDTO theUser) throws IOException {
        if(theUser.getUserEmail() == "" )
            throw new IOException("Email cannot be empty");
        if (theUser.getUserFullName().equals( ""))
            throw new IOException("User Name cannot be empty");
        if ( theUser.getUserPassword().equals( ""))
            throw new IOException("Password cannot be empty");
        if (!theUser.getUserRole().equals("admin") && !theUser.getUserRole().equals("user"))
            throw new IOException("User Role must be Admin or User");
        userObject.saveUser(theUser);
    }

    @Override
    public void removeUser(int userId) {
        userObject.removeUser(userId);
    }

    @Override
    public void updateUser(UserDTO user) {
        userObject.updateUser(user);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userObject.findAllUsers();
    }

    @Override
    public UserDTO findUserById(int id) {
        return userObject.findUserById(id);
    }

    @Override
    public UserDTO findByEmailAndPassword(String email, String password) throws Exception {
        UserDTO userDTO = userObject.findByEmailAndPassword(email,password);
        return userDTO;
    }
}
