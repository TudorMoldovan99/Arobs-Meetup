package com.Arobs.Meetup.repository;

import com.Arobs.Meetup.model.AwardingEntity;
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
public class AwardingRepositoryImpl implements IRepository<AwardingEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AwardingEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<AwardingEntity> cq = cb.createQuery(AwardingEntity.class);
        Root<AwardingEntity> root = cq.from(AwardingEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        AwardingEntity awarding = session.byId(AwardingEntity.class).load(id);
        session.delete(awarding);
        session.flush();
        session.clear();
    }

    @Override
    public void updateData(AwardingEntity object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public void saveData(AwardingEntity theAwarding) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theAwarding);
    }

    @Override
    public AwardingEntity findById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(AwardingEntity.class, theId);
    }
}

