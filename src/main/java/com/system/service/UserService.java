package com.system.service;

import com.system.entity.User;
import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(int userId);
    User getUserById(int userId);
    List<User> getAllUsers();
    User authenticateUser(String username, String password); // For login/authentication
}
