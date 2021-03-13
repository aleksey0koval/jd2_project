package it.academy.dao;

import it.academy.model.sensor.TypeSensor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class TypeSensorDaoImpl implements TypeSensorDao {

    private static final Logger log = Logger.getLogger(TypeSensorDaoImpl.class.getName());

    private SessionFactory sessionFactory;

    @Autowired
    public TypeSensorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TypeSensor> findAllType() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from TypeSensor", TypeSensor.class)
                .list();
    }

    @Override
    public TypeSensor read(String id) {
        return sessionFactory
                .getCurrentSession()
                .get(TypeSensor.class, id);
    }
}
