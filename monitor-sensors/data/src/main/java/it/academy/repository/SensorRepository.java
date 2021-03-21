package it.academy.repository;

import it.academy.model.sensor.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, String> {

    Page<Sensor> findAll(Pageable pageable);

    Page<Sensor> findBySensorName(String sensorName, Pageable pageable);

}

