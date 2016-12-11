package com.schiphol.alpha.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 * Created by Karthik
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
    private Long driverId;
    @ElementCollection(fetch= FetchType.EAGER)
    private List<String> emailIds = new ArrayList<>();
}
