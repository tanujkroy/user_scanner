package com.wbsamb.userscanner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wbsamb.userscanner.model.DistrictData;

public interface DistrictDataRepository extends JpaRepository<DistrictData, Long>{
  
 Optional<DistrictData> findByDistrictLgdCode(Long districtLgdCode);
 
    
}
