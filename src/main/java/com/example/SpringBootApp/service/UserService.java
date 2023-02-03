package com.example.SpringBootApp.service;

import com.example.SpringBootApp.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User showUser(int id);

    public void save(User user);

    public void update(int id, User updateUser);

    public void delete(int id);
}
