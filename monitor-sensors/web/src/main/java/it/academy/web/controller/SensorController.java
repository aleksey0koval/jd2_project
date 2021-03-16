package it.academy.web.controller;

import it.academy.model.sensor.DescriptionSensor;
import it.academy.model.sensor.Sensor;
import it.academy.service.SensorService;
import it.academy.dto.SensorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.logging.Logger;

@Controller
public class SensorController {

    private final static Logger log = Logger.getLogger(SensorController.class.getName());

    @Autowired(required = true)
    @Qualifier(value = "sensorService")
    SensorService sensorService;

    @GetMapping("/sensor")
    public String listSensor(Model model
                             // ,                             @PageableDefault(sort = {"id"})                                     Pageable pageable
    ) {
        model.addAttribute("sensorList", sensorService.findAll());
        return "sensor";
    }

    @GetMapping("/add-sensor")
    public String addSensor(Model model) {
        //model.addAttribute("sensorList", sensorService.findAll());
        return "add-sensor";
    }

    @PostMapping("/add")
    public String addSensor(@ModelAttribute("sensorDto") @Valid SensorDto sensorDto,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-sensor";
        }
        sensorService.createSensor(sensorDto);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editSensor(@PathVariable("id") String id,
                             @ModelAttribute("sensorDto") @Valid SensorDto sensorDto,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-sensor";
        }
        sensorService.updateSensor(id, sensorDto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteSensor(@PathVariable("id") String id) {
        sensorService.deleteSensor(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editSensor(@PathVariable("id") String id,
                             Model model, Model model1
    ) {

        model.addAttribute("sensor", sensorService.findSensorById(id));
        model1.addAttribute("sensorId", id);
        return "edit-sensor";
    }

}
