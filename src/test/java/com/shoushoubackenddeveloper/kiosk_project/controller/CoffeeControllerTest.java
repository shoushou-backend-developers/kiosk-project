package com.shoushoubackenddeveloper.kiosk_project.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 커피")
@WebMvcTest(CoffeeController.class)
class CoffeeControllerTest {

    private final MockMvc mvc;

    public  CoffeeControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @DisplayName("view-get 커피 리스트 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingCoffeeView_thenReturnsCoffeeView() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/coffees"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("coffees/index"))
                .andExpect(model().attributeExists("coffees"));

    }
}