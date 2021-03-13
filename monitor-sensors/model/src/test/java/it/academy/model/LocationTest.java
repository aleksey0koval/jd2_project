package it.academy.model;

import it.academy.model.sensor.LocationSensor;
import it.academy.model.sensor.Sensor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LocationTest extends BaseTest {

    private final static Logger log = Logger.getLogger(LocationTest.class.getName());

    @Test
    public void create() {
        //Given

        LocationSensor location = new LocationSensor();
        location.setLocationName("Room1");


        Sensor sensor = new Sensor();


        //When
        Session session = factory.openSession();
        Transaction tx = null;
        Serializable id;
        Serializable idLocation;
        try {
            tx = session.beginTransaction();
            id = session.save(sensor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }

        //Then
        assertNotNull(id);
    }


}