package com.schiphol.alpha.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.schiphol.alpha.persistence.entity.Driver;
import com.schiphol.alpha.persistence.entity.StationPole;
import com.schiphol.alpha.persistence.repository.DriverRespository;
import com.schiphol.alpha.persistence.repository.StationPoleRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Veeramani Bagavathi Since 12/10/2016
 */
@RestController
@RequestMapping(value = "/api/")
public class SampleRestController {
    @Resource
    private DriverRespository driverRepository;
    @Resource
    private StationPoleRepository stationPoleRepository;

    @RequestMapping(value = "driver/saveDetails", method = GET)
    public Driver save(String emailId, String lat, String lng) {
        if (null != emailId) {
            Driver optionalDriver = driverRepository.findByEmailId(emailId);
            if (null != optionalDriver) {
                optionalDriver.setLat(lat);
                optionalDriver.setLng(lng);
                optionalDriver.setLastUpdateTime(LocalDateTime.now());
            }
            else {
                optionalDriver = new Driver();
                optionalDriver.setLat(lat);
                optionalDriver.setLng(lng);
                optionalDriver.setLastUpdateTime(LocalDateTime.now());
                optionalDriver.setEmailId(emailId);
            }
            return driverRepository.save(optionalDriver);
        }
        return null;
    }

    @RequestMapping(value = "driver/findAll", method = GET)
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @RequestMapping(value = "driver/getDriverDetail", method = GET)
    public Driver findDriverInfo(String emailId) {
        return driverRepository.findByEmailId(emailId);
    }

    @RequestMapping(value = "station/saveStationDetails", method = GET)
    public StationPole addStationDetails(String lat, String lng) {
        StationPole station = new StationPole();
        station.setLat(lat);
        station.setLng(lng);
        station.setAvailability("available");
        return stationPoleRepository.save(station);
    }

    @RequestMapping(value = "station/updateStationDetails", method = GET)
    public StationPole updateStationDetails(Long stationId, String emailId) {
        Driver driver = driverRepository.findByEmailId(emailId);
        if (null != driver) {
            StationPole station = stationPoleRepository.findOne(stationId);
            if (null != station) {
                station.setBlockedByEmailId(driver.getEmailId());
                station.setAvailability("blocked");
                return stationPoleRepository.save(station);
            }
        }
        return null;
    }

    @RequestMapping(value = "station/makeStationAvailable", method = GET)
    public StationPole makeStationAvailable(Long stationId) {
        StationPole optionalStation = stationPoleRepository.findOne(stationId);
        if (null != optionalStation) {
            optionalStation.setAvailability("available");
            optionalStation.setBlockedByEmailId(null);
            return stationPoleRepository.save(optionalStation);
        }
        return null;
    }

    @RequestMapping(value = "station/addnotificationList", method = GET)
    public StationPole addNotificationList(Long stationId, String emailId) {
        StationPole optionalStation = stationPoleRepository.findOne(stationId);
        if (null != optionalStation) {
            if (CollectionUtils.isEmpty(optionalStation.getEmailIds())) {
                optionalStation.setEmailIds(new ArrayList<>());
            }
            optionalStation.getEmailIds().add(emailId);
            return stationPoleRepository.save(optionalStation);
        }
        return null;

    }

    @RequestMapping(value = "station/getnotificationList", method = GET)
    public List<String> getNotificationList(Long stationId) {
        StationPole optionalStation = stationPoleRepository.findOne(stationId);
        if (null != optionalStation) {
            return optionalStation.getEmailIds();
        }
        return null;

    }

    @RequestMapping(value = "station/findAll", method = GET)
    public List<StationPole> findAllStation() {
        return stationPoleRepository.findAll();
    }

}
