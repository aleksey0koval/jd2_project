package it.academy.web.controller;

import it.academy.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    SensorService sensorService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("sensorList", sensorService.findAll());
        return "sensor";
    }



}
