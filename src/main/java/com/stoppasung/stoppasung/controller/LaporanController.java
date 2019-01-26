package com.stoppasung.stoppasung.controller;

import com.stoppasung.stoppasung.model.LaporanModel;
import com.stoppasung.stoppasung.services.LaporanService;
import com.stoppasung.stoppasung.shared.dto.LaporanDto;
import com.stoppasung.stoppasung.ui.model.request.LaporanRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin
public class LaporanController {

    @Autowired
    LaporanService laporanService;

    @PostMapping("/laporan")
    public Map<String, Object> addLaporan(@Valid @RequestBody LaporanRequest laporanRequest){
        HashMap<String, Object> returnValue = new HashMap<>();
        LaporanDto laporanDto = new LaporanDto();
        BeanUtils.copyProperties(laporanRequest, laporanDto);
        laporanService.createLaporan(laporanDto);
        returnValue.put("status", "sukses");
        return returnValue;
    }
    @GetMapping("/laporanbelumditangani")
    public List<LaporanDto> getUnpickLaporan(){
        return laporanService.loadLaporanByEmailDokter("none");
    }

    @GetMapping("/laporandokter")
    public List<LaporanDto> getLaporanByDokter(@RequestParam(value = "email") String email){
        return laporanService.loadLaporanByEmailDokter(email);
    }

    @GetMapping("/laporanpasien")
    public List<LaporanDto> getLaporanByPelapor(@RequestParam(value = "email") String email){
        return laporanService.loadLaporanByEmailPelapor(email);
    }

    @PutMapping("/picklaporan")
    public Map<String, Object> pickLaporan(@RequestParam(value = "idLaporan") String idLaporan,
                                           @RequestParam(value = "emailDokter") String emailDokter){
        laporanService.pickLaporan(idLaporan, emailDokter);
        HashMap<String, Object> returnValue = new HashMap<>();
        returnValue.put("status", "sukses");
        return returnValue;
    }

    @GetMapping("/laporan/{idLaporan}")
    public Optional<LaporanRequest> getLaporanById(@PathVariable(value = "idLaporan") Long idLaporan){
        Optional<LaporanRequest> returnValue = Optional.of(new LaporanRequest());
        Optional<LaporanDto> laporanDto = laporanService.loadLaporanById(idLaporan);
        BeanUtils.copyProperties(laporanDto, returnValue);
        return returnValue;
    }


}
