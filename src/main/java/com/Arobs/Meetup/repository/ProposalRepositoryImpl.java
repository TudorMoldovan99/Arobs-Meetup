package com.Arobs.Meetup.repository;

import com.Arobs.Meetup.model.ProposalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProposalRepositoryImpl implements IRepository {
    @Override
    public void saveData(Object object) {

    }

    @Override
    public void removeData(int id) {

    }

    @Override
    public void updateData(Object object) {

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
