package com.Arobs.Meetup.service.PrizeService;

import com.Arobs.Meetup.model.PrizeEntity;
import org.springframework.stereotype.Component;


@Component
public final class PrizeMapper {

    public  void map(PrizeEntity source, PrizeDTO destination)
    {
        destination.setPrizeValue(source.getValue());
        destination.setPrizeDescription(source.getDescription());
    }


    public  void map (PrizeDTO source, PrizeEntity destination)
    {
        destination.setDescription(source.getPrizeDescription());
        destination.setValue(source.getPrizeValue());
    }

}
