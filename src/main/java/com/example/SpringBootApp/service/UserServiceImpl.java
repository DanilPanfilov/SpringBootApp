package com.example.SpringBootApp.service;

import com.example.SpringBootApp.dao.UserDao;
import com.example.SpringBootApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User showUser(int id) {
        return userDao.showUser(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(int id, User updateUser) {
        User findUserById = userDao.showUser(id);
        findUserById.setName(updateUser.getName());
        findUserById.setLastName(updateUser.getLastName());
        userDao.update(findUserById);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
