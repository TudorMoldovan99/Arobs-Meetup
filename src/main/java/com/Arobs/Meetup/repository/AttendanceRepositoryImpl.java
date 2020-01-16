package com.Arobs.Meetup.repository;

import com.Arobs.Meetup.model.AttendanceEntity;
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
public class AttendanceRepositoryImpl implements IRepository<AttendanceEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AttendanceEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<AttendanceEntity> cq = cb.createQuery(AttendanceEntity.class);
        Root<AttendanceEntity> root = cq.from(AttendanceEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        AttendanceEntity attendance = session.byId(AttendanceEntity.class).load(id);
        session.delete(attendance);
        session.flush();
        session.clear();
    }

    @Override
    public void updateData(AttendanceEntity object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public void saveData(AttendanceEntity theAttendance) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theAttendance);
    }

    @Override
    public AttendanceEntity findById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(AttendanceEntity.class, theId);
    }

    public AttendanceEntity findByUserIdAndEventId(int userId, int eventId) throws Exception
    {
        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("from AttendanceEntity u where u.event.id = :eventId and u.user.id = :userId")
                .setParameter("userId", userId)
                .setParameter("eventId", eventId);
        AttendanceEntity foundAttendance = null;
        try {
            foundAttendance = (AttendanceEntity) hql.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return foundAttendance;
    }
}
