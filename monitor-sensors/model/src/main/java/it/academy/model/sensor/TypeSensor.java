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
@Table(name = "T_TYPE_SENSOR")
public class TypeSensor {

    @Id
    @GeneratedValue(generator = "GENERATOR_TYPE_ID")
    @Column(name = "TS_TYPE_ID")
    private Integer typeId;

    @Column(name = "TS_TYPE_NAME")
    private String typeName;

    @OneToMany(mappedBy = "typeSensor")
    private List<UnitTypeSensor> unitTypeSensors;

    @ManyToOne()
    @JoinColumn(name = "DESCRIPTION_ID")
    private DescriptionSensor descriptionSensor;

}

