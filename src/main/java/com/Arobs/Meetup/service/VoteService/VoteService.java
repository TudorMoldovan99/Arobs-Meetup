package com.Arobs.Meetup.service.VoteService;

import com.Arobs.Meetup.service.VoteService.VoteDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface VoteService {

    void saveVote(VoteDTO Vote) throws Exception;

    void removeVote(int VoteId);

    void updateVote(VoteDTO Vote);

    List<VoteDTO> findAllVotes();

    VoteDTO findVoteById(int id);

    void deleteVotesForProposal(int proposalId);
}
