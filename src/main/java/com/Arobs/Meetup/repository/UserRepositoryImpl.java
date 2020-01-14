package com.Arobs.Meetup.repository;

import com.Arobs.Meetup.model.UserEntity;
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
    public void removeData(int theId) {
        Session session = sessionFactory.getCurrentSession();
        UserEntity user = session.byId(UserEntity.class).load(theId);
        session.delete(user);
        session.flush();
        session.clear();
    }

    @Override
    public void updateData(UserEntity newUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(newUser);
    }

    @Override
    public void saveData(UserEntity theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theUser);
    }


    @Override
    public UserEntity findById(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(UserEntity.class, theId);
    }

    public UserEntity findByEmailAndPassword(String email, String password) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Query hql = session.createQuery("from UserEntity u where u.userEmail = :email and u.userPassword = :password")
                .setParameter("email", email)
                .setParameter("password", password);
        UserEntity foundUser = null;
        try {
            foundUser = (UserEntity) hql.getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException("User does not exist!");
        }
        return foundUser;
    }
}


