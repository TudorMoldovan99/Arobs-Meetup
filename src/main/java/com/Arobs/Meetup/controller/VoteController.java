package com.Arobs.Meetup.controller;

import com.Arobs.Meetup.service.VoteService.VoteDTO;
import com.Arobs.Meetup.service.VoteService.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("/list")
    public ResponseEntity<List<VoteDTO>> listVotes() {
        return  ResponseEntity.ok(voteService.findAllVotes());
    }


    @PostMapping("/saveVote")
    public ResponseEntity<String> saveVote(@RequestBody VoteDTO theVote) throws Exception {
        voteService.saveVote(theVote);
        return ResponseEntity.ok("Vote saved");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteVote(@RequestParam("VoteId") int theId) {
        voteService.removeVote(theId);
        return ResponseEntity.ok("Vote deleted");
    }



}
