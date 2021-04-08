package it.academy.service.impl;

import it.academy.model.sensor.Sensor;
import it.academy.repository.SensorRepository;
import it.academy.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SearchServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> searchSensor(String param) {
        return sensorRepository.findAll()
                .stream()
                .filter(sensor -> List.of(
                        sensor.getSensorName(),
                        sensor.getDescriptionSensor().getDescriptionSensor(),
                        sensor.getDescriptionSensor().getModelName(),
                        sensor.getDescriptionSensor().getTypeName(),
                        sensor.getDescriptionSensor().getUnitName(),
                        sensor.getLocationName()
                        ).stream().
                                anyMatch(s -> s.toLowerCase().contains(param.toLowerCase()))
                )
                .collect(Collectors.toList());
    }
}
