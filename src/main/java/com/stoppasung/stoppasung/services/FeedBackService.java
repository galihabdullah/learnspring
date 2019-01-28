package com.stoppasung.stoppasung.services;

import com.stoppasung.stoppasung.model.FeedBackModel;
import com.stoppasung.stoppasung.model.pilihan.Role;
import com.stoppasung.stoppasung.shared.dto.FeedBackDto;

import java.util.List;
import java.util.Map;

public interface FeedBackService {
    FeedBackDto createFeedback(Long idLaporan, FeedBackDto feedBackDto, Role role);
    List<FeedBackDto> loadFeedBackByIdLaporan(Long idLaporan);
}
