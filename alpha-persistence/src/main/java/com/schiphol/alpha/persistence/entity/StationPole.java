package com.schiphol.alpha.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

/**
 * Created by Karthik on 12/10/2016.
 */
@Entity
@Data
public class StationPole {
    @GeneratedValue
    @Id
    private Long id;
    private String poleName;
    private String lat;
    private String lng;
    private String availability;
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = false)
    @PrimaryKeyJoinColumn
    private Driver driver;
}
