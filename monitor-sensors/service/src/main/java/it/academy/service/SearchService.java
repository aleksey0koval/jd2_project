package it.academy.service;

import it.academy.model.sensor.Sensor;
import it.academy.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SearchService {

    @Autowired
    SensorRepository sensorRepository;

    public List<Sensor> searchSensor(String param) {
        return sensorRepository.findAll()
                .stream()
                .filter(sensor -> sensor.getSensorName().toLowerCase().contains(param.toLowerCase())
                        || sensor.getLocationName().toLowerCase().contains(param.toLowerCase())
                        || sensor.getDescriptionSensor().getModelName().toLowerCase().contains(param.toLowerCase())
                        || sensor.getDescriptionSensor().getDescriptionSensor().toLowerCase().contains(param.toLowerCase())
                        || sensor.getDescriptionSensor().getTypeName().toLowerCase().contains(param.toLowerCase())
                        || sensor.getDescriptionSensor().getUnitName().toLowerCase().contains(param.toLowerCase())
                )
                .collect(Collectors.toList());
    }
}
