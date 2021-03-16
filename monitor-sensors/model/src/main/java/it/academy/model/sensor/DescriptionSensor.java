package it.academy.model.sensor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
@Table(name = "T_DESCRIPTION")
public class DescriptionSensor {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "D_DESCRIPTION_ID")
    private String descriptionId;

    @Size(max = 200, message = "Description should be max 200 characters")
    @Column(name = "D_DESCRIPTION_SENSOR")
    private String descriptionSensor;

    @NotEmpty(message = "Model should not be empty")
    @Size(min = 2, max = 15, message = "Model should be between 2 and 15 characters")
    @Column(name = "D_MODEL_NAME")
    private String modelName;

    @Column(name = "D_TYPE_NAME")
    private String typeName;

    @Column(name = "D_RANGE_FROM")
    private Integer rangeFromSensor;

    @Column(name = "D_RANGE_TO")
    private Integer rangeToSensor;

    @Column(name = "D_UNIT_NAME")
    private String unitName;

    @OneToMany(mappedBy = "descriptionSensor", cascade = {CascadeType.REFRESH, CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH})
    private List<Sensor> sensors;
}