package com.Arobs.Meetup.controller;

import com.Arobs.Meetup.service.AwardingService.AwardingDTO;
import com.Arobs.Meetup.service.AwardingService.AwardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/awarding")
public class AwardingController {

    @Autowired
    private AwardingService awardingService;

    @GetMapping("/list")
    public ResponseEntity<List<AwardingDTO>> listAwardings() {
        return  ResponseEntity.ok(awardingService.findAllAwardings());
    }


    @PostMapping("/saveAwarding")
    public ResponseEntity<String> saveAwarding(@RequestBody AwardingDTO theAwarding) throws IOException {
        awardingService.saveAwarding(theAwarding);
        return ResponseEntity.ok("Awarding saved");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteAwarding(@RequestParam("AwardingId") int theId) {
        awardingService.removeAwarding(theId);
        return ResponseEntity.ok("Awarding deleted");
    }
}
