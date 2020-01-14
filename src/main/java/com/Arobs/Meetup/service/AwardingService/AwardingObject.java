package com.Arobs.Meetup.service.AwardingService;

import com.Arobs.Meetup.model.AwardingEntity;
import com.Arobs.Meetup.repository.AwardingRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AwardingObject {

    @Autowired
    private AwardingRepositoryImpl AwardingDAO;

    @Autowired
    private AwardingMapper awardingMapper;


    @Transactional
    public List<AwardingDTO> findAllAwardings() {
        List<AwardingDTO> theAwardingList = new ArrayList<AwardingDTO>();

        for (AwardingEntity currentAwarding : AwardingDAO.findAll()) {
            AwardingDTO currentAwardingDTO = new AwardingDTO();
            awardingMapper.map(currentAwarding, currentAwardingDTO);
            theAwardingList.add(currentAwardingDTO);
        }
        return theAwardingList;
    }


    @Transactional
    public void saveAwarding(AwardingDTO theAwarding) throws IOException {


        AwardingEntity Awarding = new AwardingEntity();
        awardingMapper.map(theAwarding, Awarding);
        AwardingDAO.saveData(Awarding);
    }


    @Transactional
    public AwardingDTO findAwardingById(int theId) {
        AwardingEntity Awarding = AwardingDAO.findById(theId);
        AwardingDTO theAwarding = new AwardingDTO();
        awardingMapper.map(Awarding, theAwarding);
        return theAwarding;
    }

    @Transactional
    public void removeAwarding(int theId) {
        AwardingDAO.removeData(theId);
    }

    @Transactional
    void updateAwarding(AwardingDTO theAwarding)
    {
        AwardingEntity awarding = new AwardingEntity();
        awardingMapper.map(theAwarding, awarding);
        AwardingDAO.updateData(awarding);
    }
}
