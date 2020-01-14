package com.Arobs.Meetup.controller;

import com.Arobs.Meetup.service.PrizeService.PrizeDTO;
import com.Arobs.Meetup.service.PrizeService.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/prize")
public class PrizeController {

    @Autowired
    private PrizeService prizeService;

    @GetMapping("/list")
    public ResponseEntity<List<PrizeDTO>> listPrizes() {
        return  ResponseEntity.ok(prizeService.findAllPrizes());
    }


    @PostMapping("/savePrize")
    public ResponseEntity<String> savePrize(@RequestBody PrizeDTO thePrize) throws IOException {
        prizeService.savePrize(thePrize);
        return ResponseEntity.ok("Prize saved");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deletePrize(@RequestParam("PrizeId") int theId) {
        prizeService.removePrize(theId);
        return ResponseEntity.ok("Prize deleted");
    }
}
