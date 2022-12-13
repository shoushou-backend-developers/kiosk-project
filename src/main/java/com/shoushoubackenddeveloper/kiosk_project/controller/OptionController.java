package com.shoushoubackenddeveloper.kiosk_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/options")
@Controller
public class OptionController {

    @GetMapping
    public String options(ModelMap map){
        map.addAttribute("options", List.of());
        return "options/index";
    }
}
