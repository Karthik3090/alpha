package com.schiphol.alpha.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.schiphol.alpha.persistence.entity.Driver;
import com.schiphol.alpha.persistence.entity.StationPole;
import com.schiphol.alpha.persistence.repository.DriverRespository;
import com.schiphol.alpha.persistence.repository.StationPoleRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Veeramani Bagavathi Since 12/10/2016
 */
@RestController
@RequestMapping(value = "/api/")
public class SampleRestController {
    @Autowired
    private DriverRespository driverRepository;
    @Resource
    private StationPoleRepository stationPoleRepository;

    @RequestMapping(value = "add/{property}", method = GET)
    public Driver create(@PathVariable("property") String propertyValue) {
        final Driver driver = new Driver();
        driver.setName("Sample");
        driverRepository.save(driver);
        return driverRepository.save(driver);
    }

    @RequestMapping(value = "driver/saveDetails", method = GET)
    public Driver save(String my_ip, String lat, String lng) {
        Driver driver = null;
        Optional<Driver> optionalDriver = getMatchedDriver(my_ip);
        if (optionalDriver.isPresent()) {
            driver = optionalDriver.get();
            driver.setLat(lat);
            driver.setLng(lng);
            driver.setLastUpdateTime(LocalDateTime.now());
        }
        else {
            driver = new Driver();
            driver.setName("name");
            driver.setLat(lat);
            driver.setLng(lng);
            driver.setLastUpdateTime(LocalDateTime.now());
            driver.setIpAddress(my_ip);
        }
        return driverRepository.save(driver);
    }

    @RequestMapping(value = "driver/findAll", method = GET)
    public List<Driver> findAll() {
        return driverRepository.findAll();
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
    public StationPole updateStationDetails(Long stationId, String my_ip) {
        StationPole station = null;
        Optional<StationPole> optionalStation = getMatchedStationPole(stationId);
        if (optionalStation.isPresent()) {
            station = optionalStation.get();
            Optional<Driver> driver = getMatchedDriver(my_ip);
            if (driver.isPresent()) {
                station.setDriverId(driver.get().getId().intValue());
                station.setAvailability("blocked");
            }
            return stationPoleRepository.save(station);
        }
        return null;
    }

    @RequestMapping(value = "station/makeStationAvailable", method = GET)
    public StationPole makeStationAvailable(Long stationId) {
        StationPole station = null;
        Optional<StationPole> optionalStation = getMatchedStationPole(stationId);
        if (optionalStation.isPresent()) {
            station = optionalStation.get();
            station.setAvailability("available");
            station.setDriverId(0);
        }
        return stationPoleRepository.save(station);
    }

    @RequestMapping(value = "station/findAll", method = GET)
    public List<StationPole> findAllStation() {
        return stationPoleRepository.findAll();
    }

    private Optional<StationPole> getMatchedStationPole(Long stationId) {
        return stationPoleRepository.findAll().stream().filter(stationPole -> stationPole.getId().equals(stationId)).findFirst();
    }

    private Optional<Driver> getMatchedDriver(String my_ip) {
        return driverRepository.findAll().stream().filter(driverRepo -> driverRepo.getIpAddress().equals(my_ip)).findFirst();
    }

}
