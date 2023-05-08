package dev.rentit.rentit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){userRepository.save(user);}
    public User getUser(String email){ return userRepository.findByEmail(email);}
}
