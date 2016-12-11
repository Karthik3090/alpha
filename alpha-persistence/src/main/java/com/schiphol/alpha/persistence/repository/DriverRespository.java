package com.schiphol.alpha.persistence.repository;

import com.schiphol.alpha.persistence.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRespository extends JpaRepository<Driver, Long> {
    Driver findByName(String name);
    Driver findByIpAddress(String ip);
    Driver findByEmailId(String emailId);
}
