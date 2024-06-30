package com.ohgiraffers.createentityandrestapiswagger.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class InstaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Insta insta) {

        entityManager.persist(insta);

    }

}
