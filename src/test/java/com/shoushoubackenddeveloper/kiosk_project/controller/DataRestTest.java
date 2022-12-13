package com.shoushoubackenddeveloper.kiosk_project.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@Disabled("통합테스트 제외")
@DisplayName("REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @DisplayName("[api] 커피 리스트 조회")
    @Test
    void givenNothing_whenRequestingCoffees_thenReturnsCoffeesResponse() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/api/coffees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));


    }

    @DisplayName("[api] 커피 조회")
    @Test
    void givenNothing_whenRequestingCoffee_thenReturnsCoffeeResponse() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/api/coffees/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));

    }

    @DisplayName("[api] 주문 리스트 조회")
    @Test
    void givenNothing_whenRequestingOrders_thenReturnsOrdersResponse() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));

    }

    @DisplayName("[api] 주문 조회")
    @Test
    void givenNothing_whenRequestingOrder_thenReturnsOrderResponse() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));

    }
    @DisplayName("[api] 옵션 리스트 조회")
    @Test
    void givenNothing_whenRequestingOptions_thenReturnsOptionsResponse() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/api/options/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));

    }

    @DisplayName("[api] 옵션 조회")
    @Test
    void givenNothing_whenRequestingOption_thenReturnsOptionResponse() throws Exception {
        // Given

        // When&Then
        mvc.perform(get("/api/options/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));

    }
}

