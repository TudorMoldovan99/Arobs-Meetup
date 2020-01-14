package com.Arobs.Meetup.repository;

import com.Arobs.Meetup.model.PrizeEntity;
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
public class PrizeRepositoryImpl implements IRepository<PrizeEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<PrizeEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<PrizeEntity> cq = cb.createQuery(PrizeEntity.class);
        Root<PrizeEntity> root = cq.from(PrizeEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        PrizeEntity user = session.byId(PrizeEntity.class).load(id);
        session.delete(user);
        session.flush();
        session.clear();
    }

    @Override
    public void updateData(PrizeEntity object) {

        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public void saveData(PrizeEntity theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theUser);
    }

    @Override
    public PrizeEntity findById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(PrizeEntity.class, theId);
    }
}

