package com.Arobs.Meetup.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class RepositoryFactory {

   // @Autowired
   private  static UserRepositoryImpl userRepository;

   // @Autowired
   private static ProposalRepositoryImpl proposalRepository;

  //  @Autowired
    private static EventRepositoryImpl eventRepository;


    public static IRepository getRepository(String repoType)
    {
        if (repoType.equals("user")) {
            return userRepository;
        }
        else if (repoType.equals("proposal")) {
            return proposalRepository;
        }
        else if (repoType.equals("event")) {
            return eventRepository;
        }
        else {
            return null;
        }
    }


}
