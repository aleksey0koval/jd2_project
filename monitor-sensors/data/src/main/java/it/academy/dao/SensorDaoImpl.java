package it.academy.dao;

import it.academy.model.sensor.Sensor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SensorDaoImpl implements SensorDao {

    private SessionFactory sessionFactory;

    @Autowired
    public SensorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Sensor> findAllSensor() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Sensor", Sensor.class)
                .list();
    }

    @Override
    public Sensor readSensor(String id) {
        return sessionFactory.openSession().get(Sensor.class, id);
    }

    @Override
    public void saveSensor(Sensor sensor) {
        Session session = sessionFactory
                .getCurrentSession();
        session.save(sensor);

    }

    @Override
    public void deleteSensor(Sensor sensor) {
        sessionFactory.getCurrentSession()
        .delete(sensor);
    }
}
