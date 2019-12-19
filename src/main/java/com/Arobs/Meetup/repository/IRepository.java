package com.Arobs.Meetup.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepository<T> {

    void saveData(T object);

    void removeData(int id);

    void updateData(T object);

    List<T> findAll();

    T findById(int id);

}
