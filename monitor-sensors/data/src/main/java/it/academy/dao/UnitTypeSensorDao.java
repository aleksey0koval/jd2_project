package it.academy.dao;

import it.academy.model.sensor.UnitTypeSensor;

import java.util.List;

public interface UnitTypeSensorDao {

    List<UnitTypeSensor> findAllUnit();

    UnitTypeSensor read(String id);
}
