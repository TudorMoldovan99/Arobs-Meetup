package com.Arobs.Meetup.repository;

import com.Arobs.Meetup.model.ProposalEntity;
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
public class ProposalRepositoryImpl implements IRepository<ProposalEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveData(ProposalEntity object) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(object);
    }

    @Override
    public void removeData(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProposalEntity proposalEntity = session.byId(ProposalEntity.class).load(id);
        session.delete(proposalEntity);
        session.flush();
        session.clear();
    }

    @Override
    public void updateData(ProposalEntity object) {
        Session session = sessionFactory.getCurrentSession();
        session.update(object);
    }

    @Override
    public List<ProposalEntity> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ProposalEntity> cq = cb.createQuery(ProposalEntity.class);
        Root<ProposalEntity> root = cq.from(ProposalEntity.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public ProposalEntity findById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        ProposalEntity theProposal = currentSession.get(ProposalEntity.class, id);


        return theProposal;
    }
}
