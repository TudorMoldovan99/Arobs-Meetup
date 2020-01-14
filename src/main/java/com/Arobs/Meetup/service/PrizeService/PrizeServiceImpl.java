package com.Arobs.Meetup.service.PrizeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    private PrizeObject PrizeObject;

    @Override
    public void savePrize(PrizeDTO thePrize) throws IOException {
        PrizeObject.savePrize(thePrize);
    }

    @Override
    public void removePrize(int PrizeId) {
        PrizeObject.removePrize(PrizeId);
    }

    @Override
    public void updatePrize(PrizeDTO prize) {
        PrizeObject.updatePrize(prize);
    }

    @Override
    public List<PrizeDTO> findAllPrizes() {
        return PrizeObject.findAllPrizes();
    }

    @Override
    public PrizeDTO findPrizeById(int id) {
        return PrizeObject.findPrizeById(id);
    }
}
