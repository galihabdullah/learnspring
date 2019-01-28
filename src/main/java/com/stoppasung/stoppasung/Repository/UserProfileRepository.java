package com.stoppasung.stoppasung.Repository;

import com.stoppasung.stoppasung.model.UserProfileModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileModel, Long> {
    UserProfileModel findByUserModelIdUser(Long idUser);

}
