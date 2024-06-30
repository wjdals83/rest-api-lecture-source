package com.ohgiraffers.createentityandrestapiswagger.model.dao;

import com.ohgiraffers.createentityandrestapiswagger.entity.Insta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstaRepository extends JpaRepository<Insta, Integer> {
}
