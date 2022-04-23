package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
public class UserService {


    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
    }

    public List<User> index() {
        return userDao.findAll();
    }

    public User getUserById(long id) {
        return userDao.findById(id).get();
    }

    public void addUser(User user) {
        userDao.save(user);
    }

    public void removeUser(long id) {
        userDao.deleteById(id);
    }

    public void updateUser(User user) {
        userDao.save(user);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
