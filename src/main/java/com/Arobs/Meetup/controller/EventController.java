package com.Arobs.Meetup.controller;

import com.Arobs.Meetup.service.EventService.EventDTO;
import com.Arobs.Meetup.service.EventService.EventService;
import com.Arobs.Meetup.service.ProposalService.ProposalDTO;
import com.Arobs.Meetup.service.ProposalService.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ProposalService proposalService;

    @GetMapping("/list")
    public ResponseEntity<List<EventDTO>> listEvents() {
        return  ResponseEntity.ok(eventService.findAllEvents());
    }


    @PostMapping("/saveEvent")
    public ResponseEntity<String> saveEvent(@RequestBody EventDTO theEvent , @RequestParam("ProposalId") int prososalId, @RequestParam("AdminId") int adminId) throws Exception {

        ProposalDTO  proposalDTO = proposalService.findProposalById(prososalId);
        int proposalHost = proposalDTO.getUserId();

        if(proposalHost != adminId) {
            eventService.saveEvent(theEvent);
            proposalService.removeProposal(prososalId);
            return ResponseEntity.ok("event saved");
        }
        else
        {
            throw new Exception("Admin cannot accept his own proposal!");
        }


    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteEvent(@RequestParam("eventId") int theId) {
        eventService.removeEvent(theId);
        return ResponseEntity.ok("event deleted");
    }

}
