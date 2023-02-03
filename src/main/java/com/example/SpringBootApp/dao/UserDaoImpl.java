package com.example.SpringBootApp.dao;

import com.example.SpringBootApp.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {//@Qualifier("makeEntityManager")  был написан перед ентити
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
