package com.wbsamb.userscanner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wbsamb.userscanner.model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name="mst_user")
@JsonIgnoreProperties({ "password"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String mobile;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean status;
    private String qrCodePath; 
    private String userAddress;
    private String dist;
    private String municipalityOrBlock;
    private String panchayatName;
    private Integer pincode;
    private String postOffice;
    private String policeStation;

    @Transient
    private String rawPassword;
}
