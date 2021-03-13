package it.academy.service;

import it.academy.dao.SensorDao;
import it.academy.model.sensor.Sensor;
import it.academy.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    SensorDao sensorDao;

//    private SensorRepository sensorRepository;
//
//    @Autowired
//    public SensorService(SensorRepository sensorRepository) {
//        this.sensorRepository = sensorRepository;
//    }

//    @Transactional
//    public List<Sensor> findAll(){
//        return (List<Sensor>) sensorRepository.findAll();
//    }
//
//    @Transactional
//    public void saveSensor(Sensor sensor){
//        sensorRepository.save(sensor);
//    }


    @Transactional
    public List<Sensor> findAll() {
        return sensorDao.findAllSensor();
    }

    @Transactional
    public void saveSensor(Sensor sensor) {
        sensorDao.saveSensor(sensor);
    }
//
//    @Transactional
//    public Sensor findByIdSensor(String id) {
//        return sensorDao.readSensor(id);
//    }
//
//
//    @Transactional
//    public void deleteSensor(Sensor sensor) {
//        sensorDao.deleteSensor(sensor);
//    }

}
