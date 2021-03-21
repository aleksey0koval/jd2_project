package it.academy.model;

import it.academy.model.sensor.DescriptionSensor;
import it.academy.model.sensor.Sensor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SensorTest extends BaseTest {

    private final static Logger log = Logger.getLogger(SensorTest.class.getName());

    @Test
    public void save() {
        Sensor sensor = new Sensor();
       // sensor.setSensorId("4028e679784126f101784126fdfd0000");
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

//    @Test
//    public void read() {
//        //Given
//        //cleanInsert("SensorTest.xml");
//
//        //When
//        Session session = factory.openSession();
//        List<Sensor> sensors = session
//                .createQuery("from Sensor", Sensor.class).list();
//
//
//        //Then
//        assertNotNull(sensors);
//        assertEquals(1, sensors.size());
//        System.out.println( sensors.get(0).getLocationName());
//        deleteDataset();
//        session.close();
//    }
//
//
//
    @Test
    public void update() {
        cleanInsert("SensorTest.xml");

        Session session = factory.openSession();
        Sensor sensor = session.get(Sensor.class, "4028e679784126f101784126fdfd0000");
        sensor.setSensorName("SensorUp");
        sensor.setLocationName("LocationUp");
        DescriptionSensor ds = sensor.getDescriptionSensor();
        ds.setModelName("ModelUp");
        ds.setDescriptionSensor("DescriptionUp");
        ds.setTypeName("TemperatureUp");

        // ds.setSensors(new ArrayList());
        ds.getSensors().add(sensor);
        Transaction transaction = session.beginTransaction();
        session.update(sensor);
        transaction.commit();

        List<Sensor> sensors = session
                .createQuery("from Sensor", Sensor.class).list();

        //Then
        assertNotNull(sensors);
        assertEquals(1, sensors.size());
       // assertEquals("DescriptionUp", sensor.getDescriptionSensor().getDescriptionSensor());

        deleteDataset();
        session.close();
    }

    @Test
    public void delete() {

        //Given
        cleanInsert("SensorTest.xml");
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Sensor> sensors = session
                .createQuery("from Sensor", Sensor.class).list();

        //When
        sensors.forEach(session::delete);
                transaction.commit();

        //Then
        assertEquals(
                0,
                session.createQuery("from Sensor p").list().size()
        );
    }
}