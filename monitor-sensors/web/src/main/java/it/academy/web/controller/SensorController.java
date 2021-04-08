package it.academy.web.controller;

import it.academy.dto.SensorDto;
import it.academy.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class SensorController {

    private final static Logger log = Logger.getLogger(SensorController.class.getName());

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/")
    public String listSensors(Model model) {

        model.addAttribute("sensorList", sensorService.findAll());
        return "sensor";
    }

    @GetMapping("/add-sensor")
    public String addSensor(Model model) {
        model.addAttribute("sensorList", sensorService.findAll());
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
