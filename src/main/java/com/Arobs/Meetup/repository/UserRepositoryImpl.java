package com.Arobs.Meetup.repository;

import com.Arobs.Meetup.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



@Repository
public class UserRepositoryImpl implements IRepository<UserEntity> {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = cq.from(UserEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserEntity book = session.byId(UserEntity.class).load(id);session.delete(book);
    }

    @Override
    public void updateData(UserEntity object) {

    }

    @Override
    public void saveData(UserEntity theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theUser);
    }

    @Override
    public UserEntity findById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        UserEntity theUser = currentSession.get(UserEntity.class, theId);
        return theUser;
    }
}


