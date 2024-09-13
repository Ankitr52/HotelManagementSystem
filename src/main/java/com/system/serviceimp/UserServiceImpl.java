package com.system.serviceimp;

import com.system.Dao.UserDao;
import com.system.daoimp.UserDaoImpl;
import com.system.entity.User;
import com.system.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    private UserDao userDao; // Dependency Injection of UserDao
    
    public UserServiceImpl() {
        this.userDao = new UserDaoImpl(); // Initialize the RoomDao instance
    }


    // Constructor Injection (can also use Setter Injection or Dependency Injection frameworks)
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User addUser(User user) {
        // Delegate to DAO to add the user
        return userDao.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        // Delegate to DAO to update the user
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        // Delegate to DAO to delete the user
        userDao.deleteUser(userId);
    }

    @Override
    public User getUserById(int userId) {
        // Delegate to DAO to retrieve a user by ID
        return userDao.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        // Delegate to DAO to get all users
        return userDao.getAllUsers();
    }

    @Override
    public User authenticateUser(String username, String password) {
        // Delegate to DAO for authentication
        return userDao.authenticateUser(username, password);
    }
}
