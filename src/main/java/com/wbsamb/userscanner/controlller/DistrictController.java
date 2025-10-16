package com.wbsamb.userscanner.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbsamb.userscanner.service.DistrictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class DistrictController {
    
    @Autowired
    private DistrictService districtService;

    @GetMapping("/fetchDistrctData")
    public ResponseEntity<?> fetchDistrctData(){
        return districtService.fetchDistrctData();
    }

    @GetMapping("/fetchDistrictInfoById")
    public ResponseEntity<?> fetchDistrictInfoById(@RequestParam String id){
        return districtService.fetchDistrictInfoById(id);
    }
}
