package it.academy.dao;

import it.academy.model.sensor.Sensor;

import java.util.List;

public interface SensorDao {

    List<Sensor> findAllSensor();

    Sensor readSensor(String id);

    void saveSensor(Sensor sensor);

    void deleteSensor(Sensor sensor);


}
