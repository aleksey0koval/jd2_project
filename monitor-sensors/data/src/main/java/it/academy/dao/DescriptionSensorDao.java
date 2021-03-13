package it.academy.dao;

import it.academy.model.sensor.DescriptionSensor;

import java.util.List;

public interface DescriptionSensorDao{

    List<DescriptionSensor> findAllDescriptionSensor();

    DescriptionSensor read(String id);

    String save(DescriptionSensor descriptionSensor);

}
