package com.Arobs.Meetup.service.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteObject VoteObject;

    @Override
    public void saveVote(VoteDTO theVote) throws IOException {
        VoteObject.saveVote(theVote);
    }

    @Override
    public void removeVote(int VoteId) {
        VoteObject.removeVote(VoteId);
    }

    @Override
    public void updateVote(VoteDTO vote) {
        VoteObject.updateVote(vote);
    }

    @Override
    public List<VoteDTO> findAllVotes() {
        return VoteObject.findAllVotes();
    }

    @Override
    public VoteDTO findVoteById(int id) {
        return VoteObject.findVoteById(id);
    }
}
