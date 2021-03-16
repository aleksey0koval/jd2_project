package it.academy.repository;

import it.academy.model.sensor.TypeSensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeSensorRepository extends JpaRepository<TypeSensor, Integer> {
}
