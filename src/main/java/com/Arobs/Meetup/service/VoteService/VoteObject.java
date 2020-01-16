package com.Arobs.Meetup.service.VoteService;

import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.model.VoteEntity;
import com.Arobs.Meetup.repository.EventRepositoryImpl;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import com.Arobs.Meetup.repository.VoteRepositoryImpl;
import com.Arobs.Meetup.service.VoteService.VoteDTO;
import com.Arobs.Meetup.service.VoteService.VoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoteObject {

    @Autowired
    private VoteRepositoryImpl voteDAO;

    @Autowired
    private UserRepositoryImpl userDAO;

    @Autowired
    private EventRepositoryImpl eventRepository;

    @Autowired
    private VoteMapper voteMapper;


    @Transactional
    public List<VoteDTO> findAllVotes() {
        List<VoteDTO> theVotesList = new ArrayList<VoteDTO>();

        for (VoteEntity currentVote : voteDAO.findAll())
        {
            VoteDTO currentVoteDTO = new VoteDTO();
            voteMapper.map(currentVote,currentVoteDTO);
            theVotesList.add(currentVoteDTO);
        }
        return theVotesList;
    }


    @Transactional
    public void saveVote(VoteDTO theVote) throws Exception {

        VoteEntity vote = new VoteEntity();
        voteMapper.map(theVote,vote);

        UserEntity userEntity = vote.getUser();

        for (VoteEntity voteEntity : userEntity.getVotes())
        {
            if (voteEntity.getUser().getUserId() == theVote.getUserId() &&
                voteEntity.getProposal().getProposalId() == theVote.getProposalId())
                    throw new Exception("User cannot vote the same proposal twice!");
        }

        voteDAO.saveData(vote);
    }


    @Transactional
    public VoteDTO findVoteById(int theId) {
        VoteEntity Vote = voteDAO.findById(theId);
        VoteDTO theVote = new VoteDTO();
        voteMapper.map(Vote,theVote);
        return theVote;
    }


    @Transactional
    public void removeVote(int theId) {
        voteDAO.removeData(theId);
    }

    @Transactional
    public void updateVote(VoteDTO theVote) {
        VoteEntity vote = new VoteEntity();
        voteMapper.map(theVote,vote);
        voteDAO.saveData(vote);
    }

    @Transactional
    public void deleteVotesForProposal(int proposalId) {
        List<VoteEntity> votes = voteDAO.findAll();
        for(VoteEntity vote : votes )
        {
            if (vote.getProposal().getProposalId() == proposalId)
            {
                voteDAO.removeData(vote.getVoteId());
            }
        }
    }
}
