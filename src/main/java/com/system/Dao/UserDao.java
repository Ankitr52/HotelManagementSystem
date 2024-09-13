package com.system.Dao;

import com.system.entity.User;
import java.util.List;

public interface UserDao {
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(int userId);
    User getUserById(int userId);
    List<User> getAllUsers();
	User authenticateUser(String username, String password);
}
