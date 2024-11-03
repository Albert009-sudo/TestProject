package com.example.testproject.Service.users;


import com.example.testproject.Entity.security.User;
import com.example.testproject.Repository.UserRepository;
import com.example.testproject.Service.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    @Lazy
    private final SecurityService securityService;

    
    public User get(long id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException(String.format("User with with id %s", id));
        }
        return user.get();
    }

    
    public User getAuthorisedUser() {
        long userId= SecurityService.getCurrentUserId();
        return get(userId);
    }

    
    @Transactional(rollbackFor = Exception.class)
    public void addNew(User user) {
        if (repository.existsByUsername(user.getUsername())){
            throw new RuntimeException(String.format("User with username %s already exists", user.getUsername()));
        }
        user.setActive(true);
        user.setPassword(securityService.getEncodedPassword(user.getPassword()));
        save(user);
    }

    
    public User save(User user) {
        return repository.save(user);
    }

    
    @Transactional(rollbackFor = Exception.class)
    public User edit(long id, User editedUser) {
        User oldUser = get(id);
        oldUser.setUsername(editedUser.getUsername());
        return save(oldUser);
    }


    
    public Optional<User> findByUsername(String username) {
        return repository.findByUsernameAndActiveTrue(username);
    }

    
    @Transactional(rollbackFor = Exception.class)
    public void changePassword(String oldPassword, String newPassword) {
        securityService.changePassword(oldPassword, newPassword);
    }


    
    @Transactional(rollbackFor = Exception.class)
    public void registerUser(User newUser) {
        User user = new User();
        user.setPassword(newUser.getPassword());
        user.setUsername(newUser.getUsername());
        validateUser(user);
        addNew(user);
    }

    private void validateUser(User user){
        Optional<User> checker= repository.findByUsernameAndActiveTrue(user.getUsername());
        if(checker.isPresent() && (user.getId()==null || !checker.get().getId().equals(user.getId()))){
            throw new RuntimeException("User with username " + user.getUsername() + " already exists");
        }
    }

}
