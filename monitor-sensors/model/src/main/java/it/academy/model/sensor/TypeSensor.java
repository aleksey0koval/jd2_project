package it.academy.model.sensor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_TYPE_SENSOR")
public class TypeSensor {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "TS_TYPE_ID")
    private String typeId;

    @Column(name = "TS_TYPE_NAME")
    private String typeName;

    @Column(name = "TS_UNIT_NAME")
    private String unitName;

    @ManyToOne
    @JoinColumn(name = "DESCRIPTION_ID")
    private DescriptionSensor descriptionSensor;
}

