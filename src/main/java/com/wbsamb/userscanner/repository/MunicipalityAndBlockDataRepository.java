package com.wbsamb.userscanner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wbsamb.userscanner.model.MunicipalityAndBlockData;
import java.util.List;



@Repository
public interface MunicipalityAndBlockDataRepository extends JpaRepository<MunicipalityAndBlockData, Long>{
   Optional<MunicipalityAndBlockData> findByBlockLgdCode(Long blockLgdCode);
   
  List<MunicipalityAndBlockData> findByDistrictLgdCode(Long districtLgdCode);

}
