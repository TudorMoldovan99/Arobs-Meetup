package com.Arobs.Meetup.controller;


import com.Arobs.Meetup.service.ProposalService.ProposalDTO;
import com.Arobs.Meetup.service.ProposalService.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Proposal")
public class ProposalController {


    @Autowired
    private ProposalService proposalService;

    @GetMapping("/list")
    public ResponseEntity<List<ProposalDTO>> listProposals() {
        return  ResponseEntity.ok(proposalService.findAllProposals());
    }


    @PostMapping("/saveProposal")
    public ResponseEntity<String> saveProposal(@RequestBody ProposalDTO theProposal) throws IOException {
        proposalService.saveProposal(theProposal);
        return ResponseEntity.ok("Proposal saved");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteProposal(@RequestParam("ProposalId") int theId) {
        proposalService.removeProposal(theId);
        return ResponseEntity.ok("Proposal deleted");
    }

}
