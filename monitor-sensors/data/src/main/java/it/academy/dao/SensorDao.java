package it.academy.dao;

import it.academy.model.sensor.Sensor;

import java.util.List;

public interface SensorDao {

    void createSensor(Sensor sensor);

    void updateSensor(Sensor sensor);

    Sensor getSensorById(String id);

    void deleteSensor(String id);

    List<Sensor> findAllSensor();


}
