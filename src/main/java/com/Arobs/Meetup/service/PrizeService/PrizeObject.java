package com.Arobs.Meetup.service.PrizeService;

import com.Arobs.Meetup.model.PrizeEntity;
import com.Arobs.Meetup.repository.PrizeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PrizeObject {

    @Autowired
    private PrizeRepositoryImpl PrizeDAO;

    @Autowired
    private PrizeMapper prizeMapper;

    @Transactional
    public List<PrizeDTO> findAllPrizes() {
        List<PrizeDTO> thePrizesList = new ArrayList<PrizeDTO>();

        for (PrizeEntity currentPrize : PrizeDAO.findAll())
        {
            PrizeDTO currentPrizeDTO = new PrizeDTO();
            prizeMapper.map(currentPrize,currentPrizeDTO);
            thePrizesList.add(currentPrizeDTO);
        }
        return thePrizesList;
    }


    @Transactional
    public void savePrize(PrizeDTO thePrize) throws IOException {


        PrizeEntity Prize = new PrizeEntity();
        prizeMapper.map(thePrize,Prize);
        PrizeDAO.saveData(Prize);
    }


    @Transactional
    public PrizeDTO findPrizeById(int theId) {
        PrizeEntity Prize = PrizeDAO.findById(theId);
        PrizeDTO thePrize = new PrizeDTO();
        prizeMapper.map(Prize,thePrize);
        return thePrize;
    }


    @Transactional
    public void removePrize(int theId) {
        PrizeDAO.removeData(theId);
    }

    @Transactional
    public void updatePrize(PrizeDTO thePrize) {
        PrizeEntity prize = new PrizeEntity();
        prizeMapper.map(thePrize,prize);
        PrizeDAO.updateData(prize);
    }
}
