package it.academy.repository;

import it.academy.model.sensor.ModelSensor;
import org.springframework.data.repository.CrudRepository;

public interface ModelSensorRepository extends CrudRepository<ModelSensor, Integer> {
}
