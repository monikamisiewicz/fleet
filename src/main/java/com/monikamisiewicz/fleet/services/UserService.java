package com.monikamisiewicz.fleet.services;

import com.monikamisiewicz.fleet.models.User;
import com.monikamisiewicz.fleet.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public void save(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }
}
