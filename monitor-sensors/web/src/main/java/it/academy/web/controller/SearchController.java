package it.academy.web.controller;

import it.academy.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public String search(@RequestParam(value = "searchParam", required = false) String param,
                         Model model) {
        if (param != null && !"".equals(param.trim())) {
            model.addAttribute("searchResult", searchService.searchSensor(param));
            return "search";
        }
        return "search";
    }

}
