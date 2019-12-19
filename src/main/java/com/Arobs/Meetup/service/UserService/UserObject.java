package com.Arobs.Meetup.service.UserService;

import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.repository.RepositoryFactory;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import ma.glasnost.orika.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserObject {

    @Autowired
    private RepositoryFactory userRepositoryFactory;


    @Autowired
    private UserRepositoryImpl userDAO;


    @Transactional
    public List<UserDTO> findAllUsers() {
        List<UserDTO> theUsersList = new ArrayList<UserDTO>();

        for (UserEntity currentUser : userDAO.findAll())
        {
            UserDTO currentUserDTO = new UserDTO();
            UserMapper.map(currentUser,currentUserDTO);
            theUsersList.add(currentUserDTO);
        }
        return theUsersList;
    }


    @Transactional
    public void saveUser(UserDTO theUser) {
        UserEntity user = new UserEntity() ;
        UserMapper.map(theUser,user);
        userDAO.saveData(user);
    }


    @Transactional
    public UserDTO findUserById(int theId) {
        UserEntity user = userDAO.findById(theId);
        UserDTO theUser = new UserDTO();
        UserMapper.map(user,theUser);
        return theUser;
    }


    @Transactional
    public void removeUser(int theId) {
        userDAO.removeData(theId);
    }





}
