package it.academy.service;

import it.academy.dao.TypeSensorDao;
import it.academy.model.sensor.TypeSensor;
import it.academy.repository.TypeSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeSensorService {

//    @Autowired
//    TypeSensorDao typeSensorDao;
//
//    public List<TypeSensor> findAllType(){
//        return typeSensorDao.findAllType();
//    }
}
