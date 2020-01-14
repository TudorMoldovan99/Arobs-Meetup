package com.Arobs.Meetup.service.AwardingService;

import com.Arobs.Meetup.model.AwardingEntity;
import com.Arobs.Meetup.model.PrizeEntity;
import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.repository.PrizeRepositoryImpl;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class AwardingMapper {

    @Autowired
    UserRepositoryImpl userRepository;

    @Autowired
    PrizeRepositoryImpl prizeRepository;

    public  void map(AwardingEntity source, AwardingDTO destination)
    {
        destination.setDate(source.getDate());
        destination.setNumberOfPoints(source.getNumberOfPoints());
        destination.setUserId(source.getUser().getUserId());
        destination.setPrizeId(source.getPrize().getPrizeId());
    }

    public  void map(AwardingDTO source, AwardingEntity destination)
    {

        UserEntity userEntity = userRepository.findById(source.getUserId());
        PrizeEntity prizeEntity= prizeRepository.findById(source.getPrizeId());

        destination.setDate(source.getDate());
        destination.setNumberOfPoints(source.getNumberOfPoints());
        destination.setPrize(prizeEntity);
        destination.setUser(userEntity);

    }
}
