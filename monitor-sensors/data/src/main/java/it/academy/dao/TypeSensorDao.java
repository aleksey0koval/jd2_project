package it.academy.dao;

import it.academy.model.sensor.TypeSensor;

import java.util.List;

public interface TypeSensorDao {

    TypeSensor read(String id);

    List<TypeSensor> findAllType();
}
