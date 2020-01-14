package com.Arobs.Meetup.service.AwardingService;


import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface AwardingService {

    void saveAwarding(AwardingDTO Awarding) throws IOException;

    void removeAwarding(int AwardingId);

    void updateAwarding(AwardingDTO Awarding);

    List<AwardingDTO> findAllAwardings();

    AwardingDTO findAwardingById(int id);
}
