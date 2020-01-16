package com.Arobs.Meetup.service.ProposalService;

import com.Arobs.Meetup.model.ProposalEntity;
import com.Arobs.Meetup.repository.ProposalRepositoryImpl;
import com.Arobs.Meetup.repository.VoteRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProposalObject {

    @Autowired
    private ProposalRepositoryImpl proposalDAO;

    @Autowired
    private VoteRepositoryImpl voteDAO;

    @Autowired
    private ProposalMapper proposalMapper;


    @Transactional
    public List<ProposalDTO> findAllProposals() {
        List<ProposalDTO> theProposalsList = new ArrayList<ProposalDTO>();

        for (ProposalEntity currentProposal : proposalDAO.findAll()) {
            ProposalDTO currentProposalDTO = new ProposalDTO();
            proposalMapper.map(currentProposal, currentProposalDTO);
            theProposalsList.add(currentProposalDTO);
        }
        return theProposalsList;
    }


    @Transactional
    public void saveProposal(ProposalDTO theProposal) throws IOException {


        ProposalEntity Proposal = new ProposalEntity();
        proposalMapper.map(theProposal, Proposal);
        proposalDAO.saveData(Proposal);
    }


    @Transactional
    public ProposalDTO findProposalById(int theId) {
        ProposalEntity Proposal = proposalDAO.findById(theId);
        ProposalDTO theProposal = new ProposalDTO();
        proposalMapper.map(Proposal, theProposal);
        return theProposal;
    }


    @Transactional
    public void removeProposal(int theId) {
        proposalDAO.removeData(theId);
    }

    @Transactional
    public void updateProposal(ProposalDTO theProposal) {
        ProposalEntity proposal = new ProposalEntity();
        proposalMapper.map(theProposal, proposal);
        proposalDAO.updateData(proposal);
    }

    @Transactional
    public List<ProposalDTO> getTopProposals(int noOfProposals) {

        List<ProposalEntity> proposalsList  = proposalDAO.findAll();
        Collections.sort(proposalsList , new ProposalComparator());
        List<ProposalDTO> topProposalsList = new ArrayList<>();

        while (topProposalsList.size() < noOfProposals && proposalsList.size()> 0) {
            ProposalDTO proposalDTO  = new ProposalDTO();
            proposalMapper.map(proposalsList.get(proposalsList.size()-1),proposalDTO);
            topProposalsList.add(proposalDTO);
            proposalsList.remove(proposalsList.size()-1);
        }
        return topProposalsList;
    }


}
