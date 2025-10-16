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
@Table(name = "nic_gp_ward_mstr")
public class GPAndWardData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gpWardLgdCode;
    private Long districtLgdCode;
    private Long blockLgdCode;
    private String gpWardName;
}
