package com.bash.rolebasedpractice.service;

import com.bash.rolebasedpractice.model.Users;
import com.bash.rolebasedpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public Users registerUser(@RequestBody Users user) {
        return userRepository.save(user);
    }

}
