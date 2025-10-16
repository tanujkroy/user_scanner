package com.wbsamb.userscanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wbsamb.userscanner.model.MunicipalityAndBlockData;

import java.util.List;
import java.util.Optional;

@Repository
public interface MunicipalityAndBlockDataRepository extends JpaRepository<MunicipalityAndBlockData, Long>{
    @Query(value = "SELECT * FROM nic_district_block_mstr where block_lgd_code=?1", nativeQuery = true)
    Optional<MunicipalityAndBlockData> fetchByBlockCode(String blockLgdCode);

    @Query(value = "SELECT * FROM nic_district_block_mstr where district_lgd_code=?1", nativeQuery = true)
    List<MunicipalityAndBlockData> fetchAllByDistrictLgdCode(String districtLgdCode);
}
