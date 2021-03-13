package it.academy.model;

import it.academy.model.sensor.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SensorTest extends BaseTest {

    private final static Logger log = Logger.getLogger(SensorTest.class.getName());

    @Test
    public void createTest() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        UnitTypeSensor unitType = new UnitTypeSensor();
        unitType.setUnitName("V");

        TypeSensor typeSensor = new TypeSensor();
        typeSensor.setTypeName("Voltage");
        typeSensor.setUnitTypeSensors(List.of(unitType));

        ModelSensor model = new ModelSensor();
        model.setModelName("Model1");

        RangeSensor range = new RangeSensor();
        range.setRangeFromSensor(0);
        range.setRangeToSensor(265);

        LocationSensor location = new LocationSensor();
        location.setLocationName("Room1");

        Sensor sensor = new Sensor();
        sensor.setSensorName("Sensor1");

        DescriptionSensor description = new DescriptionSensor();
        description.setDescriptionSensor("This sensor Volt");
        description.setModelSensors(List.of(model));
        description.setTypeSensors(List.of(typeSensor));
        description.setRangeSensors(List.of(range));
        description.setSensors(List.of(sensor));

        session.save(typeSensor);
        session.flush();
//        session.save(unitType);
//        session.flush();
        session.save(model);
        session.flush();
        session.save(range);
        session.flush();
        session.save(location);
        session.flush();
        session.save(sensor);
        session.flush();
        session.save(description);
        session.flush();

        tx.commit();
        session.close();
    }

    @Test
    public void create() {
        //Given

        LocationSensor location = new LocationSensor();
        location.setLocationName("Room1");


        Sensor sensor1 = new Sensor();

        sensor1.setSensorName("Sensor1");
        //When
        Session session = factory.openSession();
        Transaction tx = null;
        Serializable id;
        Serializable idLocation;
        try {
            tx = session.beginTransaction();
            id = session.save(sensor1);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }

        //Then
        assertNotNull(id);
    }

    @Test
    public void read() {
        //Given
        cleanInsert("SensorTest.xml");

        //When
        Session session = factory.openSession();
        List<Sensor> sensors = session
                .createQuery("from Sensor", Sensor.class).list();

        //Then
        assertNotNull(sensors);
        assertEquals(4, sensors.size());
        List<Sensor> sensorList = sensors.stream()
                .filter(sensor -> "Sensor2".equals(sensor.getSensorName()))
                .collect(Collectors.toList());

        assertNotNull(sensorList);
        assertEquals(1, sensorList.size());
        deleteDataset();
        session.close();
    }

    @Test
    public void delete() {
        //Given
        cleanInsert("SensorTest.xml");

        //When
        String name = "Sensor1";
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Sensor sensor = session.get(Sensor.class, name);
            session.delete(sensor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            log.log(Level.SEVERE, e.getMessage(), e);
        }

        //Then
        assertNull(session.get(Sensor.class, name));
        session.close();
        deleteDataset();
    }

}