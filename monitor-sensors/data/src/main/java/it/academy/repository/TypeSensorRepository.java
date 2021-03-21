package it.academy.repository;

import it.academy.model.sensor.TypeSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeSensorRepository extends JpaRepository<TypeSensor, Integer> {
}
