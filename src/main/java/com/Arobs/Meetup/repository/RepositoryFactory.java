package com.Arobs.Meetup.repository;

import org.springframework.stereotype.Component;

@Component
public final class RepositoryFactory {

    private static UserRepositoryImpl userRepository = new UserRepositoryImpl();


    private static ProposalRepositoryImpl proposalRepository = new ProposalRepositoryImpl();


    private static EventRepositoryImpl eventRepository = new EventRepositoryImpl();


    public static IRepository getRepository(String repoType) {
        if (repoType.equals("user")) {
            return userRepository;
        } else if (repoType.equals("proposal")) {
            return proposalRepository;
        } else if (repoType.equals("event")) {
            return eventRepository;
        } else {
            return null;
        }
    }


}
