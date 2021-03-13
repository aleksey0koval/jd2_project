package it.academy.model.sensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_DESCRIPTION_SENSOR")
public class DescriptionSensor {

    @Id
    @GeneratedValue(generator = "GENERATOR_DESCRIPTION_ID")
    @Column(name = "D_DESCRIPTION_ID")
    private Integer descriptionId;

    @Column(name = "D_DESCRIPTION_SENSOR")
    private String descriptionSensor;

    @OneToMany(mappedBy = "descriptionSensor")
    private List<Sensor> sensors;

    @OneToMany(mappedBy = "descriptionSensor")
    private List<ModelSensor> modelSensors;

    @OneToMany(mappedBy = "descriptionSensor")
    private List<TypeSensor> typeSensors;

    @OneToMany(mappedBy = "descriptionSensor")
    private List<RangeSensor> rangeSensors;
}