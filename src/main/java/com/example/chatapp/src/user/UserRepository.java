package com.example.chatapp.src.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Slf4j
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;


}
