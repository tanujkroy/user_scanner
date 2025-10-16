package com.wbsamb.userscanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "nic_district_block_mstr")
public class MunicipalityAndBlockData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockLgdCode;
    private Long districtLgdCode;
    private String blockName;
}
