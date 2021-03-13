package it.academy.model.sensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_RANGE_SENSOR")
public class RangeSensor {

    @Id
    @GeneratedValue(generator = "GENERATOR_RANGE_ID")
    @Column(name = "R_RANGE_ID")
    private Integer rangId;

    @Column(name = "R_RANGE_FROM")
    private Integer rangeFromSensor;

    @Column(name = "R_RANGE_TO")
    private Integer rangeToSensor;

    @ManyToOne
    @JoinColumn(name = "DESCRIPTION_ID")
    private DescriptionSensor descriptionSensor;



}
