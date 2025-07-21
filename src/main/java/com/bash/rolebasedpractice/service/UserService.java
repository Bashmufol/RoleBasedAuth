package com.bash.rolebasedpractice.service;

import com.bash.rolebasedpractice.model.Role;
import com.bash.rolebasedpractice.model.Users;
import com.bash.rolebasedpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Users registerUser(Users user) {
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>());
        }
        if (user.getRoles().isEmpty()) { // Check if the set is empty
            user.getRoles().add(Role.USER);
        }
        return userRepository.save(user);
    }

}
