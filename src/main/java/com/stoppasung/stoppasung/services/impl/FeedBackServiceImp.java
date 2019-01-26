package com.stoppasung.stoppasung.services.impl;

import com.stoppasung.stoppasung.Repository.FeedBackRepository;
import com.stoppasung.stoppasung.Repository.LaporanRepository;
import com.stoppasung.stoppasung.error.ResourceNotFoundException;
import com.stoppasung.stoppasung.model.FeedBackModel;
import com.stoppasung.stoppasung.model.LaporanModel;
import com.stoppasung.stoppasung.model.pilihan.Role;
import com.stoppasung.stoppasung.services.FeedBackService;
import com.stoppasung.stoppasung.shared.dto.FeedBackDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FeedBackServiceImp implements FeedBackService {

    @Autowired
    FeedBackRepository feedBackRepository;
    @Autowired
    LaporanRepository laporanRepository;

    @Override
    public FeedBackDto createFeedback(Long idLaporan, FeedBackDto feedBackDto) {
        FeedBackModel feedBackModel = new FeedBackModel();
        FeedBackDto returnValue = new FeedBackDto();
        return laporanRepository.findById(idLaporan).map(laporanModel -> {
            feedBackModel.setLaporanModel(laporanModel);
            feedBackModel.setFeedback(feedBackDto.getFeedBack());
            feedBackModel.setResep(feedBackDto.getResep());
            feedBackModel.setRole(Role.dokter);
            feedBackRepository.save(feedBackModel);
            BeanUtils.copyProperties(feedBackModel, returnValue);
            return returnValue;
        }).orElseThrow(()-> new ResourceNotFoundException("Laporan tidak ditemukan"));

    }


}
