package com.stoppasung.stoppasung.Repository;

import com.stoppasung.stoppasung.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmailAndPassword(String email, String Password);
    UserModel findByEmail(String email);
    UserModel findByEmailVerificationToken(String token);
}
