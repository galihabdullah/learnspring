package com.stoppasung.stoppasung.services;

import com.stoppasung.stoppasung.model.FeedBackModel;
import com.stoppasung.stoppasung.shared.dto.FeedBackDto;

import java.util.Map;

public interface FeedBackService {
    FeedBackDto createFeedback(Long idLaporan, FeedBackDto feedBackDto);
}
