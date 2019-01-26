package com.stoppasung.stoppasung.services;

import com.stoppasung.stoppasung.model.LaporanModel;
import com.stoppasung.stoppasung.shared.dto.LaporanDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface LaporanService {
    void createLaporan(LaporanDto laporanDto);
    List<LaporanDto> loadLaporanByEmailDokter(String email);
    List<LaporanDto> loadLaporanByEmailPelapor(String email);
    Map<String, Object> pickLaporan(String idlaporan, String emailDokter);
    Optional<LaporanDto> loadLaporanById(Long id);

}
