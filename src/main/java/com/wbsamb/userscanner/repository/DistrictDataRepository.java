package com.wbsamb.userscanner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wbsamb.userscanner.model.DistrictData;


public interface DistrictDataRepository extends JpaRepository<DistrictData, Long>{
  @Query(value = "SELECT * FROM nic_district_mstr where district_lgd_code=?1", nativeQuery = true)
    Optional<DistrictData> findByDistrictLgdCode(String districtLgdCode);
    
}
