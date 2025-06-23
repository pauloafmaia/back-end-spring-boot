package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(Long id, User updatedUser) {
        User existingUser = findById(id);

        if (!existingUser.getUsername().equals(updatedUser.getUsername())
                && userRepository.existsByUsername(updatedUser.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (!existingUser.getEmail().equals(updatedUser.getEmail())
                && userRepository.existsByEmail(updatedUser.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setEmail(updatedUser.getEmail());

        return userRepository.save(existingUser);
    }

    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


}
