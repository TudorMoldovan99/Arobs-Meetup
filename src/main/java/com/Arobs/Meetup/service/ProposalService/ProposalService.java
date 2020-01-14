package com.Arobs.Meetup.service.ProposalService;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ProposalService {

    void saveProposal(ProposalDTO Proposal) throws IOException;

    void removeProposal(int ProposalId);

    void updateProposal(ProposalDTO Proposal);

    List<ProposalDTO> findAllProposals();

    ProposalDTO findProposalById(int id);

}
