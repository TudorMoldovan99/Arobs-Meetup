package com.Arobs.Meetup.service.ProposalService;

import com.Arobs.Meetup.model.ProposalEntity;
import com.Arobs.Meetup.repository.ProposalRepositoryImpl;
import com.Arobs.Meetup.service.ProposalService.ProposalDTO;
import com.Arobs.Meetup.service.ProposalService.ProposalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProposalObject {

    @Autowired
    private ProposalRepositoryImpl ProposalDAO;

    @Autowired
    private ProposalMapper proposalMapper;


    @Transactional
    public List<ProposalDTO> findAllProposals() {
        List<ProposalDTO> theProposalsList = new ArrayList<ProposalDTO>();

        for (ProposalEntity currentProposal : ProposalDAO.findAll())
        {
            ProposalDTO currentProposalDTO = new ProposalDTO();
            proposalMapper.map(currentProposal,currentProposalDTO);
            theProposalsList.add(currentProposalDTO);
        }
        return theProposalsList;
    }


    @Transactional
    public void saveProposal(ProposalDTO theProposal) throws IOException {


        ProposalEntity Proposal = new ProposalEntity();
        proposalMapper.map(theProposal,Proposal);
        ProposalDAO.saveData(Proposal);
    }


    @Transactional
    public ProposalDTO findProposalById(int theId) {
        ProposalEntity Proposal = ProposalDAO.findById(theId);
        ProposalDTO theProposal = new ProposalDTO();
        proposalMapper.map(Proposal,theProposal);
        return theProposal;
    }


    @Transactional
    public void removeProposal(int theId) {
        ProposalDAO.removeData(theId);
    }

    @Transactional
    public void updateProposal(ProposalDTO theProposal) {
        ProposalEntity proposal = new ProposalEntity();
        proposalMapper.map(theProposal,proposal);
        ProposalDAO.updateData(proposal);
    }
}
