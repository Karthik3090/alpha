package com.schiphol.alpha.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.OneToOne;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Driver {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String carType;
    private String ipAddress;
    private String lat;
    private String lng;
    private LocalDateTime lastUpdateTime;

}
