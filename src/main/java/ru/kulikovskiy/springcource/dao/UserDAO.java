package ru.kulikovskiy.springcource.dao;

import ru.kulikovskiy.springcource.model.User;
import java.util.List;

public interface UserDAO {

    void addUser(User user);

    User showUser(long id);

    void deleteUser(long id);

    void update(User updateUser);

    List<User> getAllUsers();
}
