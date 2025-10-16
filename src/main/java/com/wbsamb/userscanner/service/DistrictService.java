package com.wbsamb.userscanner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wbsamb.userscanner.config.ResponseHandler;
import com.wbsamb.userscanner.model.DistrictData;
import com.wbsamb.userscanner.repository.DistrictDataRepository;

@Service
public class DistrictService {

    @Autowired
    private DistrictDataRepository districtDataRepository;

    public ResponseEntity<?> fetchDistrctData() {
       List<DistrictData> all = districtDataRepository.findAll();
       return ResponseHandler.generateResponse("fetch all district list", HttpStatus.OK, all);

    }

    public ResponseEntity<?> fetchDistrictInfoById(String ids) {
         Optional<DistrictData> all = districtDataRepository.findByDistrictLgdCode(ids);
       return ResponseHandler.generateResponse("fetch all district list", HttpStatus.OK, all);
    }
    
}
