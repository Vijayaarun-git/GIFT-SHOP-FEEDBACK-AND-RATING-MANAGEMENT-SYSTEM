package com.examly.springapp.service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public Page<User> getAllUserPaginated(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public User getUser(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User updateUser(long id, User user) {
        if (userRepo.existsById(id)) {
            user.setUserId(id);
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
    
    @Override
    public List<User> getUsersByRole(String role) {
        return userRepo.findByRole(role);
    }
    
    @Override
    public List<User> getUsersByUsernameAndRole(String username, String role) {
        return userRepo.findByUsernameAndRole(username, role);
    }
}