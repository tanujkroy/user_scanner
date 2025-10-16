package com.wbsamb.userscanner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private String role;
    private boolean status;
    private String qrCodeData; 
    private String qrCodePath; 
    private String address;
    private String dist;
    private String municipalityOrBlock;
    private String panchayatName;
    private Integer pincode;
    private String postOffice;
    private String policeStation;

    @Transient
    private String rawPassword;
}
