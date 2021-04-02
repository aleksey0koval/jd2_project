package it.academy.service;

import it.academy.dao.SensorDao;
import it.academy.dto.SensorDto;
import it.academy.model.sensor.DescriptionSensor;
import it.academy.model.sensor.Sensor;

import it.academy.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SensorService {

    @Autowired
    SensorRepository sensorRepository;

    public void createSensor(SensorDto sensorDto){
        Sensor sensor = new Sensor();
        DescriptionSensor descriptionSensor = new DescriptionSensor();
        descriptionSensor.setModelName(sensorDto.getModelNameDto());
        descriptionSensor.setDescriptionSensor(sensorDto.getDescriptionSensorDto());
        descriptionSensor.setRangeFromSensor(sensorDto.getRangeFromSensorDto());
        descriptionSensor.setRangeToSensor(sensorDto.getRangeToSensorDto());
        descriptionSensor.setTypeName(sensorDto.getTypeNameDto());
        descriptionSensor.setUnitName(sensorDto.getUnitNameDto());

        sensor.setSensorName(sensorDto.getSensorNameDto());
        sensor.setLocationName(sensorDto.getLocationSensorDto());
        sensor.setDescriptionSensor(descriptionSensor);
        descriptionSensor.setSensors(new ArrayList<>());
        descriptionSensor.getSensors().add(sensor);

        sensorRepository.save(sensor);
    }

    public void updateSensor(String id, SensorDto sensorDto){

        Sensor sensor = sensorRepository.findById(id).get();
        DescriptionSensor descriptionSensor = sensor.getDescriptionSensor();

        descriptionSensor.setModelName(sensorDto.getModelNameDto());
        descriptionSensor.setDescriptionSensor(sensorDto.getDescriptionSensorDto());
        descriptionSensor.setRangeFromSensor(sensorDto.getRangeFromSensorDto());
        descriptionSensor.setRangeToSensor(sensorDto.getRangeToSensorDto());
        descriptionSensor.setTypeName(sensorDto.getTypeNameDto());
        descriptionSensor.setUnitName(sensorDto.getUnitNameDto());

        sensor.setSensorName(sensorDto.getSensorNameDto());
        sensor.setLocationName(sensorDto.getLocationSensorDto());
        sensor.setDescriptionSensor(descriptionSensor);
        //descriptionSensor.setSensors(new ArrayList());
        descriptionSensor.getSensors().add(sensor);

        sensorRepository.save(sensor);
    }

    public void deleteSensor(String id){
        sensorRepository.deleteById(id);
    }

    public Sensor findSensorById(String id){
        return sensorRepository.findById(id).get();
    }

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }
}
