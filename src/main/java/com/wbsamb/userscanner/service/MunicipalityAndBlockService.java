package com.wbsamb.userscanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wbsamb.userscanner.config.ResponseHandler;
import com.wbsamb.userscanner.model.MunicipalityAndBlockData;
import com.wbsamb.userscanner.repository.MunicipalityAndBlockDataRepository;

@Service
public class MunicipalityAndBlockService {
    
    @Autowired
    private MunicipalityAndBlockDataRepository municipalityAndBlockDataRepository;

    public ResponseEntity<?> fetchInfoById(Long id) {
        Optional<MunicipalityAndBlockData> all = municipalityAndBlockDataRepository.findByBlockLgdCode(id);
         return ResponseHandler.generateResponse("fetch all district list", HttpStatus.OK, all);
    }

    public ResponseEntity<?> fetchDataByDistId(Long distId) {
         List<MunicipalityAndBlockData> all = municipalityAndBlockDataRepository.findByDistrictLgdCode(distId);
         return ResponseHandler.generateResponse("fetch all district list", HttpStatus.OK, all);
    }

    public ResponseEntity<?> fetchDistrctData() {
       List<MunicipalityAndBlockData> all = municipalityAndBlockDataRepository.findAll();
         return ResponseHandler.generateResponse("fetch all district list", HttpStatus.OK, all);
    }
}
