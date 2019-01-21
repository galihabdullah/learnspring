package com.stoppasung.stoppasung.Repository;

import com.stoppasung.stoppasung.model.UserDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailModel, Long> {
}
