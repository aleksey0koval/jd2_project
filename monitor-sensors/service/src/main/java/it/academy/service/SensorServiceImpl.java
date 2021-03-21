package it.academy.service;

import it.academy.dto.SensorDto;
import it.academy.model.sensor.DescriptionSensor;
import it.academy.model.sensor.Sensor;
import it.academy.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorServiceImpl {
/*
  @Autowired
    SensorDao sensorDao;

    @Transactional
    public void createSensor(SensorDto sensorDto) {
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

        sensorDao.createSensor(sensor);
    }


    //DAO
    @Transactional
    public void updateSensor(String id, SensorDto sensorDto) {

        Sensor sensor = sensorDao.getSensorById(id);
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

        sensorDao.updateSensor(sensor);
    }


    @Transactional
    public void deleteSensor(String id) {
        sensorDao.deleteSensor(id);
    }


    //DAO
    @Transactional
    public Sensor findSensorById(String id) {
        return sensorDao.getSensorById(id);
    }


    //DAO
    @Transactional
    public List<Sensor> findAll() {
        return sensorDao.findAllSensor();
    }
  */


}
