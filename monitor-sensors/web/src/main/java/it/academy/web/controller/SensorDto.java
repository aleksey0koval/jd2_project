package it.academy.web.controller;

import lombok.Data;

@Data
public class SensorDto {

    private String sensorNameDto;

    private String modelNameDto;

    private Integer rangeFromSensorDto;

    private Integer rangeToSensorDto;

    private String typeNameDto;

    private String unitNameDto;

    private String locationSensorDto;

    private String descriptionSensorDto;

}
