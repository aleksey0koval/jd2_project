package it.academy.dao;

import it.academy.model.sensor.DescriptionSensor;
import it.academy.model.sensor.Sensor;

public interface DescriptionSensorDao {

    DescriptionSensor getDescSensorById(Integer id);
}
