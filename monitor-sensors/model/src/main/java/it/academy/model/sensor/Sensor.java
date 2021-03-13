package it.academy.model.sensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_SENSOR")
public class Sensor {

    @Id
    @GeneratedValue(generator = "GENERATOR_SENSOR_ID")
    @Column(name = "S_SENSOR_ID")
    private Integer sensorId;

    @Column(name = "S_SENSOR_NAME", length = 200)
    private String sensorName;

    @ManyToOne()
    @JoinColumn(name = "DESCRIPTION_ID")
    private DescriptionSensor descriptionSensor;

    @OneToOne(mappedBy = "sensor")
    @JoinColumn(name = "LOCATION_ID" )
    private LocationSensor locationSensor;
}