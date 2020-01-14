package com.Arobs.Meetup.repository;

import com.Arobs.Meetup.model.VoteEntity;
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
public class VoteRepositoryImpl implements IRepository<VoteEntity> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<VoteEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<VoteEntity> cq = cb.createQuery(VoteEntity.class);
        Root<VoteEntity> root = cq.from(VoteEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        VoteEntity user = session.byId(VoteEntity.class).load(id);
        session.delete(user);
        session.flush();
        session.clear();
    }

    @Override
    public void updateData(VoteEntity object) {

        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public void saveData(VoteEntity theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theUser);
    }

    @Override
    public VoteEntity findById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(VoteEntity.class, theId);
    }
}

