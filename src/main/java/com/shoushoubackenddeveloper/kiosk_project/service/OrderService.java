package com.shoushoubackenddeveloper.kiosk_project.service;

import com.shoushoubackenddeveloper.kiosk_project.dto.OrderDto;
import com.shoushoubackenddeveloper.kiosk_project.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDto getOrder(Long orderId){
        return orderRepository.findById(orderId)
                .map(OrderDto::from)
                .orElseThrow(() -> new EntityNotFoundException("주문이 없습니다 - orderId: " + orderId));
    }
    public void saveOrder(OrderDto dto){
        orderRepository.save(dto.toEntity());
    }

    public void deleteOrder(Long orderId){
        orderRepository.deleteById(orderId);
    }
}
