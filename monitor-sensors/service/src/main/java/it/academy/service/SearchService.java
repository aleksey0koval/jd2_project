package it.academy.service;

import it.academy.dao.SensorDao;
import it.academy.model.sensor.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SearchService {

    @Autowired
    SensorDao sensorDao;

    public List<Sensor> searchSensor(String param) {
        return sensorDao.findAllSensor()
                .stream()
                .filter(sensor -> sensor.getSensorName().contains(param)
                        || sensor.getLocationName().contains(param)
                        || sensor.getDescriptionSensor().getModelName().contains(param)
                        || sensor.getDescriptionSensor().getDescriptionSensor().contains(param)
                        || sensor.getDescriptionSensor().getTypeName().contains(param)
                        || sensor.getDescriptionSensor().getUnitName().contains(param)
                )
                .collect(Collectors.toList());
    }
}
