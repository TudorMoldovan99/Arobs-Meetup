package com.Arobs.Meetup.service.VoteService;

import com.Arobs.Meetup.model.ProposalEntity;
import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.model.VoteEntity;
import com.Arobs.Meetup.repository.ProposalRepositoryImpl;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class VoteMapper {

    @Autowired
    ProposalRepositoryImpl proposalRepository;

    @Autowired
    UserRepositoryImpl userRepository;

    public  void map (VoteEntity source , VoteDTO destination)
    {
        destination.setProposalId(source.getProposal().getProposalId());
        destination.setUserId(source.getUser().getUserId());
    }

    public  void map(VoteDTO source, VoteEntity destination)
    {
        ProposalEntity proposalEntity ;
        UserEntity user ;

        proposalEntity = proposalRepository.findById(source.getProposalId());


        user = userRepository.findById(source.getUserId());
        destination.setProposal(proposalEntity);
        destination.setUser(user);
    }

}
