package com.Arobs.Meetup.service.PrizeService;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface PrizeService {

    void savePrize(PrizeDTO Prize) throws IOException;

    void removePrize(int PrizeId);

    void updatePrize(PrizeDTO Prize);

    List<PrizeDTO> findAllPrizes();

    PrizeDTO findPrizeById(int id);
}
