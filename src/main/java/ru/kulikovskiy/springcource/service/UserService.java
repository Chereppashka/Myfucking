package ru.kulikovskiy.springcource.service;


import ru.kulikovskiy.springcource.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    User showUser(long id);
    void deleteUser(long id);
    void update(User updateUser);
    List<User> getAllUsers();
}
