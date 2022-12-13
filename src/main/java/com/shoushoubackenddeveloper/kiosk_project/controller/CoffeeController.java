package com.shoushoubackenddeveloper.kiosk_project.controller;

import com.shoushoubackenddeveloper.kiosk_project.domain.Coffee;
import com.shoushoubackenddeveloper.kiosk_project.dto.response.CoffeeResponse;
import com.shoushoubackenddeveloper.kiosk_project.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/coffees")
@Controller
public class CoffeeController {
    private final CoffeeService coffeeService;

    @GetMapping
    public String coffees(ModelMap map){
        map.addAttribute("coffees", List.of());
        return "coffees/index";
    }
    //커피 상세
    @GetMapping("/{coffeeId}")
    public String coffee(@PathVariable long coffeeId, ModelMap map){
        CoffeeResponse coffee = CoffeeResponse.from(coffeeService.getCoffee(coffeeId));
        map.addAttribute("coffee", coffee);

        return "coffees/detail";
    }

}
