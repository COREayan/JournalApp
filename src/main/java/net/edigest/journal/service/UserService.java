package net.edigest.journal.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.edigest.journal.entity.User;
import net.edigest.journal.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(ObjectId myId) {
        return userRepository.findById(myId);
    }

    public void createUser(User newUser) {
        userRepository.insert(newUser);
    }

    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User updatedUser) {
        userRepository.save(updatedUser);
        return updatedUser;
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
