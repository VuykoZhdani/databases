package com.lviv.iot.repository;

import com.lviv.iot.domain.SolarBattery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarBatteryRepository extends JpaRepository<SolarBattery, Integer> {
    SolarBattery findByModel(String model);

}