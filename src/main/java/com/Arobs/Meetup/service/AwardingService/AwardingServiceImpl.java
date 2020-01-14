package com.Arobs.Meetup.service.AwardingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class AwardingServiceImpl implements AwardingService {

    @Autowired
    private AwardingObject awardingObject;

    @Override
    public void saveAwarding(AwardingDTO theAwarding) throws IOException {
        awardingObject.saveAwarding(theAwarding);
    }

    @Override
    public void removeAwarding(int awardingId) {
        awardingObject.removeAwarding(awardingId);
    }

    @Override
    public void updateAwarding(AwardingDTO awarding) {
        awardingObject.updateAwarding(awarding);
    }

    @Override
    public List<AwardingDTO> findAllAwardings() {
        return awardingObject.findAllAwardings();
    }

    @Override
    public AwardingDTO findAwardingById(int id) {
        return awardingObject.findAwardingById(id);
    }
}
