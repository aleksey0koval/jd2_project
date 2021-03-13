package it.academy.dao;

import it.academy.model.sensor.UnitTypeSensor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class UnitTypeSensorDaoImpl implements UnitTypeSensorDao {

    private static final Logger log = Logger.getLogger(UnitTypeSensorDaoImpl.class.getName());

    private SessionFactory sessionFactory;

    @Autowired
    public UnitTypeSensorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UnitTypeSensor> findAllUnit() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from UnitTypeSensor", UnitTypeSensor.class)
                .list();
    }

    @Override
    public UnitTypeSensor read(String id) {
        return sessionFactory
                .getCurrentSession()
                .get(UnitTypeSensor.class, id);
    }
}
