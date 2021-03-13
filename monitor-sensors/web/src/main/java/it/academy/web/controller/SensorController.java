package it.academy.web.controller;

import it.academy.model.sensor.*;
import it.academy.service.SensorService;

import it.academy.service.TypeSensorService;
import it.academy.service.UnitTypeSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SensorController {

    @Autowired
    SensorService sensorService;

//    @Autowired
//    TypeSensorService typeSensorService;
//
//    @Autowired
//    UnitTypeSensorService unitTypeSensorService;

    @GetMapping("/sensor")
    public String sensor(Model model) {
        model.addAttribute("sensorList", sensorService.findAll());
        return "sensor";
    }
//
//    @GetMapping("/sensor/{id}")
//    public String getSensor(
//            @PathVariable(name = "id") String id,
//            Model model
//    ) {
//        try {
//            model.addAttribute("product", sensorService.findByIdSensor(id));
//            return "product";
//        } catch (Exception e) {
//            model.addAttribute("error-message", "Product not found");
//            return "error";
//        }
//    }


    @GetMapping("/add-sensor")
    public String addSensor(Model model1, Model model2) {
//        model.addAttribute("typeList", typeSensorService.findAllType());
//        model.addAttribute("unitList",unitTypeSensorService.findAllUnit());
        return "add-sensor";
    }

    @PostMapping("/sensor/add")
    public String addSensor(
            @ModelAttribute ("sensorDto") SensorDto sensorDto
    ) {
        ModelSensor modelSensor = new ModelSensor();
        modelSensor.setModelName(sensorDto.getModelNameDto());

        RangeSensor rangeSensor = new RangeSensor();
        rangeSensor.setRangeFromSensor(Integer.parseInt(sensorDto.getRangeFromSensorDto()));
        rangeSensor.setRangeToSensor(Integer.parseInt(sensorDto.getRangeToSensorDto()));

        UnitTypeSensor unitTypeSensor = new UnitTypeSensor();
        unitTypeSensor.setUnitName(sensorDto.getUnitNameDto());

        TypeSensor typeSensor = new TypeSensor();
        typeSensor.setTypeName(sensorDto.getTypeNameDto());
        typeSensor.setUnitTypeSensors(List.of(unitTypeSensor));

        DescriptionSensor descriptionSensor = new DescriptionSensor();
        descriptionSensor.setModelSensors(List.of(modelSensor));
        descriptionSensor.setRangeSensors(List.of(rangeSensor));
        descriptionSensor.setTypeSensors(List.of(typeSensor));

        LocationSensor locationSensor = new LocationSensor();
        locationSensor.setLocationName(sensorDto.getLocationSensorDto());

        Sensor sensor = new Sensor();
        sensor.setSensorName(sensorDto.getSensorNameDto());
        sensor.setDescriptionSensor(descriptionSensor);
        sensor.setLocationSensor(locationSensor);

        sensorService.saveSensor(sensor);

        return "redirect:/sensor";
    }

}
