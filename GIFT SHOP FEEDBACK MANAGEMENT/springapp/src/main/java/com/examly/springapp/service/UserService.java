package com.examly.springapp.service;

import com.examly.springapp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    Page<User> getAllUserPaginated(Pageable pageable);
    User getUser(long id);
    User updateUser(long id, User user);
    void deleteUser(long id);
    List<User> getUsersByRole(String role);
    List<User> getUsersByUsernameAndRole(String username, String role);
}