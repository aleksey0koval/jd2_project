package it.academy.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SensorDto {

    private String sensorIdDto;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String sensorNameDto;

    @NotEmpty(message = "Model should not be empty")
    @Size(min = 2, max = 15, message = "Model should be between 2 and 15 characters")
    private String modelNameDto;

    private Integer rangeFromSensorDto;

    private Integer rangeToSensorDto;

    private String typeNameDto;

    private String unitNameDto;

    @Size(max = 40, message = "Location should be max 40 characters")
    private String locationSensorDto;

    @Size(max = 200, message = "Description should be max 200 characters")
    private String descriptionSensorDto;

}