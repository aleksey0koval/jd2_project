package it.academy.service;

import it.academy.dao.UnitTypeSensorDao;
import it.academy.model.sensor.UnitTypeSensor;
import it.academy.repository.UnitTypeSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UnitTypeSensorService {

//    @Autowired
//    UnitTypeSensorDao unitTypeSensorDao;
//
//    public List<UnitTypeSensor> findAllUnit(){
//        return unitTypeSensorDao.findAllUnit();
//    }
}
