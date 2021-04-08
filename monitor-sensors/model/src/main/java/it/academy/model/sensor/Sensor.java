package it.academy.model.sensor;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_SENSOR")
public class Sensor {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "S_SENSOR_ID")
    private String sensorId;

    @Column(name = "S_SENSOR_NAME")
    private String sensorName;

    @Column(name = "S_LOCATION_NAME")
    private String locationName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DESCRIPTION_ID")
    private DescriptionSensor descriptionSensor;
}
