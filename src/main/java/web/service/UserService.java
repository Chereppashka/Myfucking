package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    User showUser(long id);
    void deleteUser(long id);
    void update(User updateUser);
    List<User> getAllUsers();
}
