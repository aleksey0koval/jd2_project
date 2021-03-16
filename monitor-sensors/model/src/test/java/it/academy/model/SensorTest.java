package it.academy.model;

import it.academy.model.sensor.DescriptionSensor;
import it.academy.model.sensor.Sensor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class SensorTest extends BaseTest {

    private final static Logger log = Logger.getLogger(SensorTest.class.getName());

    @Test
    public void save() {
        Sensor sensor = new Sensor();
        sensor.setSensorName("Test Sensor34321");
        sensor.setLocationName("Location Test save");

        DescriptionSensor ds = new DescriptionSensor();
        ds.setModelName("Test Model3");

        sensor.setDescriptionSensor(ds);
        ds.setSensors(new ArrayList());
        ds.getSensors().add(sensor);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sensor);
        transaction.commit();
    }

    @Test
    public void update() {

        Session session = factory.openSession();
        Sensor sensor = session.get(Sensor.class, "4028e49d783a3dc901783a3dd7dc0000");
        sensor.setSensorName("Test Sensor17");
        sensor.setLocationName("Location Test");
        DescriptionSensor ds = sensor.getDescriptionSensor();
        ds.setModelName("Test Model17");
        ds.setTypeName("Temp");
        ds.setDescriptionSensor("Test descr17");
        sensor.setDescriptionSensor(ds);
        ds.setSensors(new ArrayList());
        ds.getSensors().add(sensor);
        Transaction transaction = session.beginTransaction();
        session.update(sensor);
        transaction.commit();
    }

    @Test
    public void delete() {

        Session session = factory.openSession();
        Sensor sensor = session.get(Sensor.class, "4028e49d783a3dc901783a3dd7dc0000");
        Transaction transaction = session.beginTransaction();
        session.delete(sensor);
        transaction.commit();
    }


}