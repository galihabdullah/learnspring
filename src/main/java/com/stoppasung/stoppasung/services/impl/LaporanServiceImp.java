package com.stoppasung.stoppasung.services.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.stoppasung.stoppasung.Repository.LaporanRepository;
import com.stoppasung.stoppasung.error.ResourceNotFoundException;
import com.stoppasung.stoppasung.model.LaporanModel;
import com.stoppasung.stoppasung.services.LaporanService;
import com.stoppasung.stoppasung.shared.dto.LaporanDto;
import com.stoppasung.stoppasung.shared.utils.Utils;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LaporanServiceImp implements LaporanService {
    @Autowired
    LaporanRepository laporanRepository;

    @Autowired
    Utils utils;

    @Override
    public void createLaporan(LaporanDto laporanDto){
        LaporanModel laporanModel = new LaporanModel();
        BeanUtils.copyProperties(laporanDto, laporanModel);
        laporanModel.setEmailDokter("none");
        laporanModel.setIdLaporan(utils.randomString(6));
       laporanRepository.save(laporanModel);
    }

    @Override
    public List<LaporanDto> loadLaporanByEmailDokter(String email) {
        List<LaporanModel> laporanModels = laporanRepository.findByEmailDokter(email);
        List laporan = new ArrayList<>();
        laporan.addAll(laporanModels);
        //BeanUtils.copyProperties(laporanModels, laporanDtos);
        return laporan;
    }

    @Override
    public List<LaporanDto> loadLaporanByEmailPelapor(String email) {
        List<LaporanModel> laporanModels = laporanRepository.findByEmailPelapor(email);
        List laporan = new ArrayList();
        laporan.addAll(laporanModels);
        return laporan;
    }

    @Override
    public Map<String, Object> pickLaporan(String idlaporan, String emailDokter) {
        LaporanModel laporanModel = laporanRepository.findByIdLaporan(idlaporan);
        if(laporanModel == null) throw new ResourceNotFoundException("id laporan tidak ditemukan");
        if(laporanModel.getEmailDokter().equals("none")) {
            laporanModel.setEmailDokter(emailDokter);
            laporanRepository.save(laporanModel);
            Map<String, Object> returnValue = new HashMap<>();
            returnValue.put("status", "sukses");
            return returnValue;
        }throw new ResourceNotFoundException("Laporan sudah dihandle oleh " + laporanModel.getEmailDokter());
    }

    @Override
    public Optional<LaporanDto> loadLaporanById(Long id) {
        Optional<LaporanModel> laporanModel = laporanRepository.findById(id);
        Optional<LaporanDto> laporanDto = Optional.of(new LaporanDto());
        BeanUtils.copyProperties(laporanModel, laporanDto);
        return laporanDto;
    }
}
