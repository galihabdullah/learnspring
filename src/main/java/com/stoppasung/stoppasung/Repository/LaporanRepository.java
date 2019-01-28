package com.stoppasung.stoppasung.Repository;

import com.stoppasung.stoppasung.model.LaporanModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaporanRepository extends CrudRepository<LaporanModel, Long> {
    List<LaporanModel> findByEmailDokter(String email);
    List<LaporanModel> findByEmailPelapor(String email);
    LaporanModel findByIdLaporan(String idLaporan);
    Optional<LaporanModel> findById(Long id);
}
