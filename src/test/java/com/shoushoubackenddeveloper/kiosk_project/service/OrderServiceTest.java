package com.shoushoubackenddeveloper.kiosk_project.service;

import com.shoushoubackenddeveloper.kiosk_project.domain.Order;
import com.shoushoubackenddeveloper.kiosk_project.dto.OrderDto;
import com.shoushoubackenddeveloper.kiosk_project.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 오더")
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks OrderService sut;
    @Mock
    private OrderRepository orderRepository;

    @DisplayName("주문을 조회하면, 주문을 반환한다.")
    @Test
    void givenOrderId_whenSearchOrder_thenReturnsOrder() {
        // Given
        Long orderId =1L;
        Order order = createOrder();
        given(orderRepository.findById(orderId)).willReturn(Optional.of(order));

        // When
        OrderDto dto = sut.getOrder(orderId);

        // Then
        assertThat(dto)
                .hasFieldOrPropertyWithValue("orderNo", order.getOrderNo());

        then(orderRepository).should().findById(orderId);
    }

    @DisplayName("주문이 없으면, 예외를 던진다.")
    @Test
    void givenNonexistentOrderId_whenSearchingOrder_thenThrowsException() {
        // Given
        Long orderId = 0L;
        given(orderRepository.findById(orderId)).willReturn(Optional.empty());

        // When
        Throwable t = catchThrowable(() -> sut.getOrder(orderId));

        // Then
        Assertions.assertThat(t)
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("주문이 없습니다 - orderId: " + orderId);

        then(orderRepository).should().findById(orderId);
    }

    @DisplayName("주문을 하면, 주문을 등록한다.")
    @Test
    void givenOrder_whenSavingOrder_thenSavesOrder() {
        // Given
        OrderDto dto = createOrderDto();
        given(orderRepository.save(any(Order.class))).willReturn(createOrder());

        // When
        sut.saveOrder(dto);

        // Then
        then(orderRepository).should().save(any(Order.class));
    }

    @DisplayName("주문의 ID를 입력하면, 주문을 삭제한다")
    @Test
    void givenOrderId_whenDeletingOrder_thenDeletesOrder() {
        // Given
        Long orderId = 1L;
        willDoNothing().given(orderRepository).deleteById(orderId);

        // When
        sut.deleteOrder(1L);

        // Then
        then(orderRepository).should().deleteById(orderId);
    }
    private Order createOrder() {
        Order order = Order.of(
                1L,
                1
        );
        ReflectionTestUtils.setField(order,"id",1L);
        return order;
    }

    private OrderDto createOrderDto(){
        return createOrderDto(1);
    }

    private OrderDto createOrderDto(Integer orderNo){
        return OrderDto.of(
                orderNo
        );
    }
}
