package com.shoushoubackenddeveloper.kiosk_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/coffees")
@Controller
public class CoffeeController {

    @GetMapping
    public String coffees(ModelMap map){
        map.addAttribute("coffees", List.of());
        return "coffees/index";
    }

}
