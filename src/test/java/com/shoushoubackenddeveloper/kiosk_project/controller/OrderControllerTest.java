package com.shoushoubackenddeveloper.kiosk_project.controller;

import com.shoushoubackenddeveloper.kiosk_project.dto.OrderDto;
import com.shoushoubackenddeveloper.kiosk_project.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 커피")
@WebMvcTest(OrderController.class)
class OrderControllerTest {

    private final MockMvc mvc;
    @MockBean
    private OrderService orderService;

    public OrderControllerTest(@Autowired MockMvc mvc){this.mvc =mvc;}

    @DisplayName("view-get 주문 상세 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingOrderView_thenReturnsOrderView() throws Exception {
        // Given
        Long orderId = 1L;
        given(orderService.getOrder(orderId)).willReturn((createOrderDto()));
        // When&Then
        mvc.perform(get("/orders/" + orderId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("orders/detail"))
                .andExpect(model().attributeExists("order"));
        then(orderService).should().getOrder(orderId);
    }

    private OrderDto createOrderDto(){
        return OrderDto.of(
                1L,
                1,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }


}