package com.shoushoubackenddeveloper.kiosk_project.repository;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DisplayName("JPA 연결 테스트")
@DataJpaTest
class JpaRepositoryTest {

    private final CoffeeOrderOptionRepository coffeeOrderOptionRepository;
    private final CoffeeOrderRepository coffeeOrderRepository;
    private final CoffeeRepository coffeeRepository;
    private final OptionRepository optionRepository;
    private final OrderRepository orderRepository;

    public JpaRepositoryTest(
            @Autowired CoffeeOrderOptionRepository coffeeOrderOptionRepository,
            @Autowired CoffeeOrderRepository coffeeOrderRepository,
            @Autowired CoffeeRepository coffeeRepository,
            @Autowired OptionRepository optionRepository,
            @Autowired OrderRepository orderRepository) {
        this.coffeeOrderOptionRepository = coffeeOrderOptionRepository;
        this.coffeeOrderRepository = coffeeOrderRepository;
        this.coffeeRepository = coffeeRepository;
        this.optionRepository = optionRepository;
        this.orderRepository = orderRepository;
    }

}
