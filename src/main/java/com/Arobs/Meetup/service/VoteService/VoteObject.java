package com.Arobs.Meetup.service.VoteService;

import com.Arobs.Meetup.model.VoteEntity;
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
    private VoteRepositoryImpl VoteDAO;

    @Autowired
    private VoteMapper voteMapper;


    @Transactional
    public List<VoteDTO> findAllVotes() {
        List<VoteDTO> theVotesList = new ArrayList<VoteDTO>();

        for (VoteEntity currentVote : VoteDAO.findAll())
        {
            VoteDTO currentVoteDTO = new VoteDTO();
            voteMapper.map(currentVote,currentVoteDTO);
            theVotesList.add(currentVoteDTO);
        }
        return theVotesList;
    }


    @Transactional
    public void saveVote(VoteDTO theVote) throws IOException {


        VoteEntity Vote = new VoteEntity();
        voteMapper.map(theVote,Vote);
        VoteDAO.saveData(Vote);
    }


    @Transactional
    public VoteDTO findVoteById(int theId) {
        VoteEntity Vote = VoteDAO.findById(theId);
        VoteDTO theVote = new VoteDTO();
        voteMapper.map(Vote,theVote);
        return theVote;
    }


    @Transactional
    public void removeVote(int theId) {
        VoteDAO.removeData(theId);
    }

    @Transactional
    public void updateVote(VoteDTO theVote) {
        VoteEntity vote = new VoteEntity();
        voteMapper.map(theVote,vote);
        VoteDAO.saveData(vote);
    }
}
