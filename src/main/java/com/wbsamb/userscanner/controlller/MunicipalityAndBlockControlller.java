package com.wbsamb.userscanner.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wbsamb.userscanner.service.MunicipalityAndBlockService;

@RestController
@RequestMapping("/api/block&municipality")
public class MunicipalityAndBlockControlller {

    @Autowired
    private MunicipalityAndBlockService municipalityAndBlockService;

    @GetMapping("/fetchAll")
    public ResponseEntity<?> fetchDistrctData() {
        return municipalityAndBlockService.fetchDistrctData();
    }

    @GetMapping("/findById")
    public ResponseEntity<?> fetchInfoById(@RequestParam String id) {
        return municipalityAndBlockService.fetchInfoById(id);
    }

    @GetMapping("/fetchDataByDistId")
    public ResponseEntity<?> fetchDataByDistId(@RequestParam String distId) {
        return municipalityAndBlockService.fetchDataByDistId(distId);
    }
}
