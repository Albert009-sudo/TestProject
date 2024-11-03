package com.example.testproject.Repository;




import com.example.testproject.Entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndActiveTrue(String username);

    boolean existsByUsername(String username);



}
