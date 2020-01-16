package com.Arobs.Meetup.service.UserService;

import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.repository.RepositoryFactory;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import ma.glasnost.orika.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserObject {


    @Autowired
    private UserRepositoryImpl userDAO;

    @Autowired
    private UserMapper userMapper;


    @Transactional
    public List<UserDTO> findAllUsers() {
        List<UserDTO> theUsersList = new ArrayList<UserDTO>();

        for (UserEntity currentUser : userDAO.findAll())
        {
            UserDTO currentUserDTO = new UserDTO();
            userMapper.map(currentUser,currentUserDTO);
            theUsersList.add(currentUserDTO);
        }
        return theUsersList;
    }


    @Transactional
    public void saveUser(UserDTO theUser) throws Exception {

        UserEntity user = new UserEntity();
        userMapper.map(theUser,user);
        try {
            UserEntity userEntity = userDAO.findByEmail(theUser.getUserEmail());
            throw new Exception("User exists!");
            }
        catch(Exception e){
            if (e.getMessage().equals("User exists!"))
                throw new Exception("There is already an user using this email");
            else
                userDAO.saveData(user);
        }

    }


    @Transactional
    public UserDTO findUserById(int theId) {
        UserEntity user = userDAO.findById(theId);
        UserDTO theUser = new UserDTO();
        userMapper.map(user,theUser);
        return theUser;
    }


    @Transactional
    public void removeUser(int theId) {
        userDAO.removeData(theId);
    }


    @Transactional
    public void updateUser(UserDTO theUser) {
        UserEntity user = new UserEntity();
        userMapper.map(theUser,user);
        userDAO.updateData(user);
    }

    @Transactional
    public UserDTO findByEmailAndPassword(String email, String password) throws Exception {
        UserEntity userEntity = userDAO.findByEmailAndPassword(email,password);

        if (userEntity == null)
            throw new Exception("No user found with given credentials");

        UserDTO userDTO = new UserDTO();
        userMapper.map(userEntity,userDTO);

        return userDTO;
    }

    @Transactional
    public void addPointsToUser(String email, int numberOfPoints) throws Exception {

        UserEntity userEntity = userDAO.findByEmail(email);
        userEntity.setUserVotes(userEntity.getUserVotes() + numberOfPoints);

        userDAO.updateData(userEntity);


    }
}
