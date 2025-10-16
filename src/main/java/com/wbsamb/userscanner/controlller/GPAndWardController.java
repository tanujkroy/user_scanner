package com.wbsamb.userscanner.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wbsamb.userscanner.service.GPAndWardService;

@RestController
@RequestMapping("/api/gp&ward")
public class GPAndWardController {

    @Autowired
    private GPAndWardService gpAndWardService;

    @GetMapping("/fetchAll")
    public ResponseEntity<?> fetchDistrctData() {
        return gpAndWardService.fetchDistrctData();
    }

    @GetMapping("/findById")
    public ResponseEntity<?> fetchInfoById(@RequestParam Long id) {
        return gpAndWardService.fetchInfoById(id);
    }

    @GetMapping("/fetchAllDataByDistId")
    public ResponseEntity<?> fetchAllDataByDistId(@RequestParam Long distId) {
        return gpAndWardService.fetchAllDataByDistId(distId);
    }

    @GetMapping("/fetchAllDataByBlockId")
    public ResponseEntity<?> fetchAllDataByBlockId(@RequestParam Long blockId) {
        return gpAndWardService.fetchAllDataByBlockId(blockId);
    }

}
