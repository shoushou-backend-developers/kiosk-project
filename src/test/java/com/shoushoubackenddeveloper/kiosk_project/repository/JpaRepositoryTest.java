package com.shoushoubackenddeveloper.kiosk_project.repository;

import com.shoushoubackenddeveloper.kiosk_project.config.JpaConfig;
import com.shoushoubackenddeveloper.kiosk_project.domain.Coffee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
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

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        // Given

        // When
        List<Coffee> coffee = coffeeRepository.findAll();
        // Then
        assertThat(coffee)
                .isNotNull()
                .hasSize(2);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){
        // Given
        long preCnt = coffeeRepository.count();
        Coffee coffee = Coffee.of(3L, "CAR","카라멜", "caramel", 4000, "판매중", true);

        // When
        coffeeRepository.save(coffee);
        // Then
        assertThat(coffeeRepository.count()).isEqualTo(preCnt + 1);

    }
    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        // Given
        Coffee coffee = coffeeRepository.findById(1L).orElseThrow();
        Integer updatedPrice = 3500;
        coffee.setPrice(updatedPrice);
        // When
        Coffee saveCoffee = coffeeRepository.saveAndFlush(coffee);


        // Then
        assertThat(saveCoffee).hasFieldOrPropertyWithValue("price", updatedPrice);

    }
    @DisplayName("delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        // Given
        Coffee coffee = coffeeRepository.findById(1L).orElseThrow();
        long preCnt = coffeeRepository.count();
        // When
        coffeeRepository.delete(coffee);
        // Then
        assertThat(coffeeRepository.count()).isEqualTo(preCnt - 1);

    }

}
