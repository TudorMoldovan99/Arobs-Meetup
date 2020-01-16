package com.Arobs.Meetup.repository;

import com.Arobs.Meetup.model.EventEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EventRepositoryImpl implements IRepository<EventEntity> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveData(EventEntity object) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(object);
    }

    @Override
    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        EventEntity event = session.byId(EventEntity.class).load(id);
        session.delete(event);

    }

    @Override
    public void updateData(EventEntity object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public List<EventEntity> findAll() {

        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<EventEntity> cq = cb.createQuery(EventEntity.class);
        Root<EventEntity> root = cq.from(EventEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public EventEntity findById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(EventEntity.class, id);
    }

    public EventEntity findByTitle(String title) throws Exception{

        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("from EventEntity u where u.eventTitle = :title")
                .setParameter("title", title);
        EventEntity foundEvent = null;
        try {
            foundEvent = (EventEntity) hql.getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException("Event does not exist!");
        }
        return foundEvent;

    }
}
