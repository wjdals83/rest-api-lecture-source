package com.ohgiraffers.createentityandrestapiswagger.model.service;

import com.ohgiraffers.createentityandrestapiswagger.entity.Insta;
import com.ohgiraffers.createentityandrestapiswagger.entity.InstaRepository;
import com.ohgiraffers.createentityandrestapiswagger.model.dto.InstaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstaService {

    private final InstaRepository instaRepository;

    private ModelMapper modelMapper;

    @Autowired
    public InstaService(InstaRepository instaRepository, ModelMapper modelMapper) {
        this.instaRepository = instaRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void registInsta(InstaDTO newInsta) {

        Insta insta = new Insta(
                newInsta.getRegistNo(),
                newInsta.getEnrollDate(),
                newInsta.getLikedNumber(),
                newInsta.getDescription(),
                newInsta.getStatus()
        );

        instaRepository.save(insta);

    }

}
