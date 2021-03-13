package it.academy.model.sensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_LOCATION_SENSOR")
public class LocationSensor {

    @Id
    @GeneratedValue(generator = "GENERATOR_LOCATION_ID")
    @Column(name = "L_LOCATION_ID")
    private Integer locationId;

    @Column(name = "L_LOCATION_NAME")
    private String locationName;

    @OneToOne()
    @JoinColumn(name = "SENSOR_ID")
    private Sensor sensor;
}