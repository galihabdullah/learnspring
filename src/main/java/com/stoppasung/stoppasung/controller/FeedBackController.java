package com.stoppasung.stoppasung.controller;

import com.stoppasung.stoppasung.Repository.LaporanRepository;
import com.stoppasung.stoppasung.model.FeedBackModel;
import com.stoppasung.stoppasung.model.pilihan.Role;
import com.stoppasung.stoppasung.services.FeedBackService;
import com.stoppasung.stoppasung.services.LaporanService;
import com.stoppasung.stoppasung.shared.dto.FeedBackDto;
import com.stoppasung.stoppasung.ui.model.request.FeedBackRequest;
import com.stoppasung.stoppasung.ui.model.response.FeedBackResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
public class FeedBackController {


    @Autowired
    LaporanService laporanService;

    @Autowired
    FeedBackService feedBackService;

    @PostMapping("/laporandokter/{idLaporan}/dokter/feedback")
    public Map<String, Object> addFeedBackDokter(@PathVariable(value = "idLaporan") Long idLaporan,
                                  @Valid @RequestBody FeedBackRequest feedBackRequest
                                            ){
        FeedBackDto feedBackDto = new FeedBackDto();
        BeanUtils.copyProperties(feedBackRequest, feedBackDto);
        feedBackService.createFeedback(idLaporan, feedBackDto, Role.dokter);
        Map<String, Object> returnValue = new HashMap<>();
        returnValue.put("status", "sukses");
        return returnValue;
    }

    @PostMapping("/laporan/{idLaporan}/pelapor/feeback")
    public Map<String, Object> addFeedBackPelapor(@PathVariable(value = "idLaporan") Long idLaporan,
                                                  @Valid @RequestBody FeedBackRequest feedBackRequest
                                                  ){
        FeedBackDto feedBackDto = new FeedBackDto();
        BeanUtils.copyProperties(feedBackRequest, feedBackDto);
        feedBackService.createFeedback(idLaporan, feedBackDto, Role.pelapor);
        Map<String, Object> returnValue = new HashMap<>();
        returnValue.put("Status", "sukses");
        return returnValue;
    }

    @GetMapping("laporan/{idLaporan}/feedback")
    public List<FeedBackDto> getFeedBackByIdLaporan(@PathVariable(value = "idLaporan") Long idLaporan){
        return feedBackService.loadFeedBackByIdLaporan(idLaporan);
    }

}
