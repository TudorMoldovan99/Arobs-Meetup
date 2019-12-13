package com.Arobs.Meetup.Service.UserService;

import ma.glasnost.orika.*;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.Type;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

public class UserMapper  extends ConfigurableMapper implements ApplicationContextAware {

    private MapperFactory factory;
    ApplicationContext applicationContext;


    public UserMapper() {
        super(false);
    }

    @Override
    protected void configure(MapperFactory factory)
    {
        this.factory = factory;
        //TODO - factory.MapClass (DTO,Entitate). nume fielduri
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void addMappers(ApplicationContext applicationContext)
    {
        Map<String,Mapper> mapperMap = applicationContext.getBeansOfType(Mapper.class);
        //for (Map<String , Mapper> mapperMap : applicationContext.getBeansOfType(Mapper.class))
        {

        }
    }

}
