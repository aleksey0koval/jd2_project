package it.academy.dao;

import it.academy.model.sensor.Sensor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public void createSensor(Sensor sensor) {
        sensor.setSensorId(null);
        Session session = sessionFactory
                .getCurrentSession();
        session.save(sensor);
    }

    @Override
    public void updateSensor(Sensor sensor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sensor);
    }

    @Override
    public void deleteSensor(String id) {
        Session session = sessionFactory.getCurrentSession();
        Sensor sensor = session.get(Sensor.class, id);
        if (sensor != null) {
            session.delete(sensor);
        }
    }

    @Override
    public Sensor getSensorById(String id) {
        return sessionFactory.getCurrentSession().get(Sensor.class, id);
    }

    @Override
    public List<Sensor> findAllSensor() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Sensor", Sensor.class)
                .list();
    }
}
