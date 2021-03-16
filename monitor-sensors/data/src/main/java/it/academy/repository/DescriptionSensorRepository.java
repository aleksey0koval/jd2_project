package it.academy.repository;

import it.academy.model.sensor.DescriptionSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionSensorRepository
        extends JpaRepository<DescriptionSensor, Integer> {
}
