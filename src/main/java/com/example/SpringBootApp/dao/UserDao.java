package com.example.SpringBootApp.dao;

import com.example.SpringBootApp.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User showUser(int id);

    public void save(User user);

    public void update(User updateUser);

    public void delete(int id);
}
