package com.Arobs.Meetup;

import com.Arobs.Meetup.model.UserEntity;
import com.Arobs.Meetup.Configuration.HibernateUtil;
import com.Arobs.Meetup.repository.IRepository;
import com.Arobs.Meetup.repository.UserRepositoryImpl;
import com.Arobs.Meetup.service.UserService.*;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class MeetupApplication {


    public static void main(String[] args) {
        SpringApplication.run(MeetupApplication.class, args);
       // UserEntity userEntity = new UserEntity("Tudor","123","admin",5,"Tudor@email.com");









    }
}