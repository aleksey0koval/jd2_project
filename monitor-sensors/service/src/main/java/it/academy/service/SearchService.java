package it.academy.service;

import it.academy.model.sensor.Sensor;

import java.util.List;

public interface SearchService {

    List<Sensor> searchSensor(String param);

}
