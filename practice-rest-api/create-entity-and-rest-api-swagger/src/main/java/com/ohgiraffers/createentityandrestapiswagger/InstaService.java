package com.ohgiraffers.createentityandrestapiswagger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstaService {

    private final InstaRepository instaRepository;

    @Autowired
    public InstaService(InstaRepository instaRepository) {
        this.instaRepository = instaRepository;
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
