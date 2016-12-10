package com.schiphol.alpha.web.controllers;

import com.schiphol.alpha.persistence.entity.Driver;
import com.schiphol.alpha.persistence.repository.DriverRespository;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Veeramani Bagavathi
 *         Since 12/10/2016
 */
@RestController
@RequestMapping(value = "/api/driver/")
public class SampleRestController {
    @Autowired
    private DriverRespository driverRepository;

    @RequestMapping(value = "add/{property}", method = GET)
    public Driver create(@PathVariable("property") String propertyValue) {
        final Driver driver = new Driver();
        driver.setName("Sample");
        driverRepository.save(driver);
        return driverRepository.save(driver);
    }

    @RequestMapping(value = "saveDetails", method = GET)
    public Driver save(String my_ip, String lat, String lng,HttpServletRequest httpRequest) {
        String ipAddress = httpRequest.getHeader("HTTP_X_FORWARDED_FOR");
        Driver driver = null;
        Optional<Driver> optionalDriver = driverRepository.findAll().stream().filter(driverRepo -> driverRepo.getIpAddress().equals(my_ip)).findFirst();
        if(optionalDriver.isPresent()) {
            driver = optionalDriver.get();
            driver.setLat(lat);
            driver.setLng(lng);
            driver.setLastUpdateTime(LocalDateTime.now());
        } else {
            driver = new Driver();
            driver.setName("Karthik");
            driver.setLat(lat);
            driver.setLng(lng);
            driver.setLastUpdateTime(LocalDateTime.now());
            driver.setIpAddress(my_ip);
        }
        return driverRepository.save(driver);
    }

    @RequestMapping(value = "findAll", method = GET)
    public List<Driver> findAll() {
      /*  if(!CollectionUtils.isEmpty(driverRepository.findAll())){
            driverRepository.findAll().stream().filter(driver -> driver.getLastUpdateTime())
        }*/
        return driverRepository.findAll();
    }

}
