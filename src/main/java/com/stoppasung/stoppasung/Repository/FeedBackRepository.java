package com.stoppasung.stoppasung.Repository;

import com.stoppasung.stoppasung.model.FeedBackModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FeedBackRepository extends CrudRepository<FeedBackModel, Long> {
    Optional<FeedBackModel> findByLaporanModelId(Long LaporanId);
    Optional<FeedBackModel> findByIdAndLaporanModelId(Long id, Long LaporanId);
}
