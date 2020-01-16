package com.Arobs.Meetup.service.ProposalService;

import com.Arobs.Meetup.model.ProposalEntity;

import java.util.Comparator;

public class ProposalComparator implements Comparator<ProposalEntity> {

    @Override
    public int compare(ProposalEntity proposalDTO, ProposalEntity t1) {
        return proposalDTO.getVotes().size() - t1.getVotes().size();
    }
}
