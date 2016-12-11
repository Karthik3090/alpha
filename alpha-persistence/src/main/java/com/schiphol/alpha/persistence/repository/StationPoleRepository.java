package com.schiphol.alpha.persistence.repository;

import com.schiphol.alpha.persistence.entity.StationPole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Karthik on 12/10/2016.
 */
@Repository
public interface StationPoleRepository extends JpaRepository<StationPole, Long> {
    StationPole findByBlockedByEmailId(String emailId);
}
