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
    private ProposalObject ProposalObject;

    @Override
    public void saveProposal(ProposalDTO theProposal) throws IOException {
        ProposalObject.saveProposal(theProposal);
    }

    @Override
    public void removeProposal(int ProposalId) {
        ProposalObject.removeProposal(ProposalId);
    }

    @Override
    public void updateProposal(ProposalDTO proposal) {
        ProposalObject.updateProposal(proposal);
    }

    @Override
    public List<ProposalDTO> findAllProposals() {
        return ProposalObject.findAllProposals();
    }

    @Override
    public ProposalDTO findProposalById(int id) {
        return ProposalObject.findProposalById(id);
    }

}
