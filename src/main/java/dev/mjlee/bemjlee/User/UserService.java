package dev.mjlee.bemjlee.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long userId) {
        if (!userRepository.existsById(userId))
            throw new IllegalStateException("User " + userId + " not found");
        else
            return userRepository.findById(userId);
    }

    public List<User> getTop5Users() {
        return userRepository.findTop5ByOrderByScoreDesc();
    }

    public void addUser(User user) {
        System.out.println(user);
        userRepository.save(user);
    }

    public void deleteUser(Long user) {
        userRepository.findById(user);
        if (!userRepository.existsById(user)) {
            throw new IllegalStateException("Project " + user + " not found");
        } else {
            userRepository.deleteById(user);
        }
    }
}
