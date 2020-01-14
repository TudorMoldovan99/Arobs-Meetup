package com.Arobs.Meetup.service.ProposalService;

import com.Arobs.Meetup.model.ProposalEntity;
import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProposalMapper {

    @Autowired
    UserRepositoryImpl userRepository;

    public static void map(ProposalEntity source , ProposalDTO destination)
    {
        destination.setProposalDescription(source.getProposalDescription());
        destination.setProposalDifficulty(source.getProposalDifficulty());
        destination.setProposalDuration(source.getProposalDuration());
        destination.setProposalLanguage(source.getProposalLanguage());
        destination.setProposalMaximumNumberOfPeople(source.getProposalMaximumNumberOfPeople());
        destination.setProposalTitle(source.getProposalTitle());
        destination.setProposalType(source.getProposalType());
        destination.setUserId(source.getUser().getUserId());
    }

    public  void map(ProposalDTO source, ProposalEntity destination)
    {
        destination.setProposalDescription(source.getProposalDescription());
        destination.setProposalDifficulty(source.getProposalDifficulty());
        destination.setProposalDuration(source.getProposalDuration());
        destination.setProposalLanguage(source.getProposalLanguage());
        destination.setProposalMaximumNumberOfPeople(source.getProposalMaximumNumberOfPeople());
        destination.setProposalTitle(source.getProposalTitle());
        destination.setProposalType(source.getProposalType());
        UserEntity user = userRepository.findById(source.getUserId());
        destination.setUser(user);
    }

}
