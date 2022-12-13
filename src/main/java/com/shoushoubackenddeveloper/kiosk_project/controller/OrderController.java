package com.shoushoubackenddeveloper.kiosk_project.controller;

import com.shoushoubackenddeveloper.kiosk_project.dto.response.OrderResponse;
import com.shoushoubackenddeveloper.kiosk_project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequiredArgsConstructor
@RequestMapping("/orders")
@Controller
public class OrderController {

    private final OrderService orderService;
    @GetMapping
    public String orders(ModelMap map){
        map.addAttribute("orders", List.of());
        return "orders/index";
    }

    //오더 상세 페이지

    @GetMapping("/{orderId}")
    public String order(@PathVariable Long orderId, ModelMap map){
        OrderResponse order = OrderResponse.from(orderService.getOrder(orderId));
        map.addAttribute("order", order);

        return "orders/detail";
    }
}
