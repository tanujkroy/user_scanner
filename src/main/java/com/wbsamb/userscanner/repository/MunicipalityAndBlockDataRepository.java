package com.wbsamb.userscanner.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wbsamb.userscanner.model.MunicipalityAndBlockData;

@Repository
public interface MunicipalityAndBlockDataRepository extends JpaRepository<MunicipalityAndBlockData, Long>{
   
    Optional<MunicipalityAndBlockData> findByBlockCode(Long blockLgdCode);

    List<MunicipalityAndBlockData> findAllByDistrictLgdCode(Long districtLgdCode);
}
