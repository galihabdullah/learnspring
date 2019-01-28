package com.stoppasung.stoppasung.services.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.stoppasung.stoppasung.Repository.LaporanRepository;
import com.stoppasung.stoppasung.error.ResourceNotFoundException;
import com.stoppasung.stoppasung.model.LaporanModel;
import com.stoppasung.stoppasung.services.LaporanService;
import com.stoppasung.stoppasung.shared.dto.FeedBackDto;
import com.stoppasung.stoppasung.shared.dto.LaporanDto;
import com.stoppasung.stoppasung.shared.utils.Utils;
import com.stoppasung.stoppasung.ui.model.request.FeedBackRequest;
import com.stoppasung.stoppasung.ui.model.request.LaporanRequest;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

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

    public LaporanDto pickLaporanById(Long idlaporan, String emailDokter) {
        LaporanDto returnValue = new LaporanDto();
        Optional<LaporanModel> laporanModel = laporanRepository.findById(idlaporan);
        if(!laporanModel.isPresent()) throw new ResourceNotFoundException("Laporan tidak ditemukan");
        return laporanModel.map(laporan -> {
            if(!laporan.getEmailDokter().equals("none")) throw new ResourceNotFoundException("Laporan sudah dihandle oleh dokter lain");
            laporan.setEmailDokter(emailDokter);
            laporanRepository.save(laporan);
            BeanUtils.copyProperties(laporan, returnValue);
            return returnValue;
        }).orElseThrow(()-> new ResourceNotFoundException("server error"));
    }

    @Override
    public Optional<LaporanDto> loadLaporanById(Long id) {
        Optional<LaporanModel> laporanModel = laporanRepository.findById(id);
        Optional<LaporanDto> laporanDto = Optional.of(new LaporanDto());
        BeanUtils.copyProperties(laporanModel, laporanDto);
        return laporanDto;
    }
}
