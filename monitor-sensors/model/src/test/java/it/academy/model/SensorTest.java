package it.academy.model;

import it.academy.model.sensor.DescriptionSensor;
import it.academy.model.sensor.Sensor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;

public class SensorTest extends BaseTest {

    private final static Logger log = Logger.getLogger(SensorTest.class.getName());

    @Test
    public void save() {
        Sensor sensor = new Sensor();
        sensor.setSensorName("SensorTest");
        sensor.setLocationName("LocationTest");

        DescriptionSensor ds = new DescriptionSensor();
        ds.setModelName("ModelTest");
        ds.setDescriptionSensor("DescriptionTest");

        sensor.setDescriptionSensor(ds);
        ds.setSensors(new ArrayList());
        ds.getSensors().add(sensor);

        Session session = factory.openSession();

        Transaction tx = null;
        Serializable id;
        try {
            tx = session.beginTransaction();
            //do some work
            id = session.save(sensor);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        //Then
        assertNotNull(id);
    }
}