package it.academy.repository;

import it.academy.model.sensor.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

    Page<Sensor> findAll(Pageable pageable);

    Page<Sensor> findByTag(String tag, Pageable pageable);

}
