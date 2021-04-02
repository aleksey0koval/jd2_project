package it.academy.web.controller;

import it.academy.model.sensor.Sensor;
import it.academy.repository.SensorRepository;
import it.academy.service.PageService;
import it.academy.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SensorService sensorService;

//    @GetMapping("/")
//    public String home(
//
//            Model model) {
//
//
//        model.addAttribute("sensorList", sensorService.findAll());
//        return "sensor";
//    }

//    @GetMapping("/sensor?page={page}&size={size}")
//    public String home(
//                       @PathVariable("page") Integer page,
//                       @PathVariable("size") Integer size,
//                       Model model) {
//        List<Sensor> sensorList = sensorService.findAll();
//        model.addAttribute("page", page);
//        model.addAttribute("size", size);
//        model.addAttribute("listSize", sensorList.size());
//        model.addAttribute("url", "/");
//        model.addAttribute("sensorList", sensorService.findAll());
//        return "sensor";
//    }
//
//    @GetMapping("/")
//    public String homea(
//            Model model,
//            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
//    ) {
//        Page<Sensor> page = pageService.sensorsList(pageable);
//       // page.getTotalPages()
//        model.addAttribute("page", pageService.sensorsList(pageable));
//        model.addAttribute("url", "/");
//        model.addAttribute("sensorList", sensorService.findAll());
//        return "sensor";
//    }

//    @GetMapping("/")
//    public String homeee(Model model) {
//        List<Sensor> sensors = sensorService.findAll();
//        List<Integer> listSize = new ArrayList<>();
//        for (int i = 1; i <= sensors.size(); i++) {
//            listSize.add(i);
//        }
//        model.addAttribute("sensorList", sensors);
//        model.addAttribute("listSize", listSize);
//        return "sensor";
//    }

}
