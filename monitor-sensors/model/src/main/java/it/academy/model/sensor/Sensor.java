package it.academy.model.sensor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "S_SENSOR_NAME")
    private String sensorName;

    @Size(max = 40, message = "Location should be max 40 characters")
    @Column(name = "S_LOCATION_NAME")
    private String locationName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DESCRIPTION_ID")
    private DescriptionSensor descriptionSensor;
}
