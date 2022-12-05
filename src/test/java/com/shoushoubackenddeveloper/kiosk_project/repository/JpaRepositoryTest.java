package com.shoushoubackenddeveloper.kiosk_project.repository;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DisplayName("JPA 연결 테스트")
@DataJpaTest
class JpaRepositoryTest {

    private final CoffeeOrderRepository coffeeOrderRepository;
    private final CoffeeRepository coffeeRepository;
    private final OrderRepository orderRepository;

    public JpaRepositoryTest(
            @Autowired CoffeeOrderRepository coffeeOrderRepository,
            @Autowired CoffeeRepository coffeeRepository,
            @Autowired OrderRepository orderRepository
    ) {
        this.coffeeOrderRepository = coffeeOrderRepository;
        this.coffeeRepository = coffeeRepository;
        this.orderRepository = orderRepository;
    }


}
