package com.shoushoubackenddeveloper.kiosk_project.controller;

import com.shoushoubackenddeveloper.kiosk_project.dto.CoffeeDto;
import com.shoushoubackenddeveloper.kiosk_project.service.CoffeeService;
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
@WebMvcTest(CoffeeController.class)
class CoffeeControllerTest {

    private final MockMvc mvc;
    @MockBean
    private CoffeeService coffeeService;

    public  CoffeeControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @DisplayName("view-get 커피 리스트 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingCoffeesView_thenReturnsCoffeesView() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/coffees"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("coffees/index"))
                .andExpect(model().attributeExists("coffees"));
    }

    @DisplayName("view-get 커피 상세 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingCoffeeView_thenReturnsCoffeeView() throws Exception {
        // Given
        Long coffeeId = 1L;
        given(coffeeService.getCoffee(coffeeId)).willReturn((createCoffeeDto()));
        // When & Then
        mvc.perform(get("/coffees/" + coffeeId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("coffees/detail"))
                .andExpect(model().attributeExists("coffee"));
        then(coffeeService).should().getCoffee(coffeeId);
    }

    private CoffeeDto createCoffeeDto(){
        return CoffeeDto.of(
                1L,
                "AME",
                "아메리카노",
                "Americano",
                4000,
                "판매 중",
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}