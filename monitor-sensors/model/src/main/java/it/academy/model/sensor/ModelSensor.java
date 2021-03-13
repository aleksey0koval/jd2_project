package it.academy.model.sensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_MODEL_SENSOR")
public class ModelSensor {

    @Id
    @GeneratedValue(generator = "GENERATOR_MODEL_ID")
    @Column(name = "M_MODEL_ID")
    private Integer modelId;

    @Column(name = "M_MODEL_NAME")
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "DESCRIPTION_ID")
    private DescriptionSensor descriptionSensor;
}