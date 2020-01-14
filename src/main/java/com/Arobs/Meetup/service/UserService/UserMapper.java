package com.Arobs.Meetup.service.UserService;

import com.Arobs.Meetup.model.UserEntity;
import ma.glasnost.orika.*;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public final class UserMapper  {

    public  void map (UserDTO sourceObject , UserEntity destinationObject)
    {
        destinationObject.setUserFullName(sourceObject.getUserFullName());
        destinationObject.setUserPassword(sourceObject.getUserPassword());
        destinationObject.setUserEmail(sourceObject.getUserEmail());
        destinationObject.setUserRole(sourceObject.getUserRole());
        destinationObject.setUserVotes(sourceObject.getUserVotes());
    }
    public  void map (UserEntity sourceObject, UserDTO destinationObject)
    {
        destinationObject.setUserEmail(sourceObject.getUserEmail());
        destinationObject.setUserFullName(sourceObject.getUserFullName());
        destinationObject.setUserPassword(sourceObject.getUserPassword());
        destinationObject.setUserRole(sourceObject.getUserRole());
        destinationObject.setUserVotes(sourceObject.getUserVotes());
    }


}
