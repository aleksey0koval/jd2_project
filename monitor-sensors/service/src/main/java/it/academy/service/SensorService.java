package it.academy.service;

import it.academy.dto.SensorDto;
import it.academy.model.sensor.Sensor;

import java.util.List;

public interface SensorService {

    void createSensor(SensorDto sensorDto);

    void updateSensor(String id, SensorDto sensorDto);

    void deleteSensor(String id);

    Sensor findSensorById(String id);

    List<Sensor> findAll();

}
