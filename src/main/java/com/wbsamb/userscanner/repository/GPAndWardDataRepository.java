package com.wbsamb.userscanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wbsamb.userscanner.model.GPAndWardData;
import java.util.List;
import java.util.Optional;

@Repository
public interface GPAndWardDataRepository extends JpaRepository<GPAndWardData, Long>{

    List<GPAndWardData> findAllByBlockLgdCode(Long blockLgdCode);

    Optional<GPAndWardData> findByGpWardLgdCode(Long gpWardLgdCode);

    List<GPAndWardData> findAllByDistrictLgdCode(Long districtLgdCode);
    
}
