package com.wbsamb.userscanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wbsamb.userscanner.config.ResponseHandler;
import com.wbsamb.userscanner.model.GPAndWardData;
import com.wbsamb.userscanner.repository.GPAndWardDataRepository;

@Service
public class GPAndWardService {
    
    @Autowired
    private GPAndWardDataRepository gpAndWardDataRepository;

    public ResponseEntity<?> fetchDistrctData() {
        List<GPAndWardData> all = gpAndWardDataRepository.findAll();
         return ResponseHandler.generateResponse("fetch all district list", HttpStatus.OK, all);
    }

    public ResponseEntity<?> fetchInfoById(Long id) {
          Optional<GPAndWardData> all = gpAndWardDataRepository.findByGpWardLgdCode(id);
         return ResponseHandler.generateResponse("fetch all district list", HttpStatus.OK, all);
    }

    public ResponseEntity<?> fetchAllDataByDistId(Long distId) {
         List<GPAndWardData> all = gpAndWardDataRepository.findAllByDistrictLgdCode(distId);
         return ResponseHandler.generateResponse("fetch all district list", HttpStatus.OK, all);
    }

    public ResponseEntity<?> fetchAllDataByBlockId(Long blockId) {
       List<GPAndWardData> all = gpAndWardDataRepository.findAllByBlockLgdCode(blockId);
         return ResponseHandler.generateResponse("fetch all district list", HttpStatus.OK, all);
    }
}
