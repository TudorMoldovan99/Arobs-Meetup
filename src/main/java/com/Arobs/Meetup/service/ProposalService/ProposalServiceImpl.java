package com.Arobs.Meetup.service.ProposalService;

import com.Arobs.Meetup.service.ProposalService.ProposalDTO;
import com.Arobs.Meetup.service.ProposalService.ProposalObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalObject proposalObject;

    @Override
    public void saveProposal(ProposalDTO theProposal) throws IOException {
        proposalObject.saveProposal(theProposal);
    }

    @Override
    public void removeProposal(int ProposalId) {
        proposalObject.removeProposal(ProposalId);
    }

    @Override
    public void updateProposal(ProposalDTO proposal) {
        proposalObject.updateProposal(proposal);
    }

    @Override
    public List<ProposalDTO> findAllProposals() {
        return proposalObject.findAllProposals();
    }

    @Override
    public ProposalDTO findProposalById(int id) {
        return proposalObject.findProposalById(id);
    }

    @Override
    public List<ProposalDTO> getTopProposals(int noOfProposals) {
        return proposalObject.getTopProposals(noOfProposals);
    }
}
