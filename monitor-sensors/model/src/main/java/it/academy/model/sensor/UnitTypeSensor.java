package it.academy.model.sensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_UNIT_TYPE")
public class UnitTypeSensor {

    @Id
    @GeneratedValue(generator = "GENERATOR_UNIT_ID")
    @Column(name = "U_UNIT_ID")
    private String unitId;

    @Column(name = "U_UNIT_NAME")
    private String unitName;

    @ManyToOne()
    @JoinColumn(name = "TYPE_ID")
    private TypeSensor typeSensor;
}