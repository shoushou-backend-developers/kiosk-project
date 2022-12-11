package com.shoushoubackenddeveloper.kiosk_project.service;

import com.shoushoubackenddeveloper.kiosk_project.domain.Coffee;
import com.shoushoubackenddeveloper.kiosk_project.dto.CoffeeDto;
import com.shoushoubackenddeveloper.kiosk_project.repository.CoffeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 커피")
@ExtendWith(MockitoExtension.class)
class CoffeeServiceTest {

    @InjectMocks
    private CoffeeService sut;
    @Mock
    private CoffeeRepository coffeeRepository;

    @DisplayName("커피를 조회하면, 커피를 반환한다.")
    @Test
    void givenCoffeeId_whenSearchCoffee_thenReturnsCoffee() {
        // Given
        Long coffeeId = 1L;
        Coffee coffee = createCoffee();
        given(coffeeRepository.findById(coffeeId)).willReturn(Optional.of(coffee));

        // When
        CoffeeDto dto = sut.getCoffee(coffeeId);

        // Then
        assertThat(dto)
                .hasFieldOrPropertyWithValue("coffeeCode", coffee.getCoffeeCode())
                .hasFieldOrPropertyWithValue("korName", coffee.getKorName())
                .hasFieldOrPropertyWithValue("engName", coffee.getEngName())
                .hasFieldOrPropertyWithValue("price", coffee.getPrice())
                .hasFieldOrPropertyWithValue("orderStatus", coffee.getOrderStatus())
                .hasFieldOrPropertyWithValue("sizeSelectable", coffee.getSizeSelectable());

        then(coffeeRepository).should().findById(coffeeId);
    }

    @DisplayName("커피가 없으면, 예외를 던진다.")
    @Test
    void givenNonexistentCoffeeId_whenSearchingCoffee_thenThrowsException() {
        // Given
        Long coffeeId = 0L;
        given(coffeeRepository.findById(coffeeId)).willReturn(Optional.empty());

        // When
        Throwable t = catchThrowable(() -> sut.getCoffee(coffeeId));

        // Then
        assertThat(t)
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("커피가 없습니다 - coffeeId: " + coffeeId);

        then(coffeeRepository).should().findById(coffeeId);
    }

    @DisplayName("커피 정보를 입력하면, 커피를 등록한다.")
    @Test
    void givenCoffeeInfo_whenSavingCoffee_thenSavesCoffee() {
        // Given
        CoffeeDto dto = createCoffeeDto();
        given(coffeeRepository.save(any(Coffee.class))).willReturn(createCoffee());
        // When
        sut.saveCoffee(dto);

        // Then
        then(coffeeRepository).should().save(any(Coffee.class));
    }

    @DisplayName("커피의 수정 정보를 입력하면, 커피를 수정한다")
    @Test
    void givenModifiedCoffeeInfo_whenUpdatingArticle_thenUpdatesCoffee(){
        // Given
        Coffee coffee = createCoffee();
        CoffeeDto dto = createCoffeeDto("새코드", "한글명", "영문명", 4000, "판매 금지", false);
        given(coffeeRepository.getReferenceById(dto.id())).willReturn(coffee);

        // When
        sut.updateCoffee(dto);

        // Then

        assertThat(coffee)
                .hasFieldOrPropertyWithValue("coffeeCode", dto.coffeeCode())
                .hasFieldOrPropertyWithValue("korName", dto.korName())
                .hasFieldOrPropertyWithValue("engName", dto.engName())
                .hasFieldOrPropertyWithValue("price", dto.price())
                .hasFieldOrPropertyWithValue("orderStatus", dto.orderStatus())
                .hasFieldOrPropertyWithValue("sizeSelectable", dto.sizeSelectable());

        then(coffeeRepository).should().getReferenceById(dto.id());
    }

    @DisplayName("커피의 ID를 입력하면, 커피를 삭제한다")
    @Test
    void givenCoffeeId_whenDeletingArticle_thenDeletesCoffee(){
        // Given
        Long coffeeId = 1L;
        willDoNothing().given(coffeeRepository).deleteById(coffeeId);
        // When
        sut.deleteCoffee(1L);
        // Then
        then(coffeeRepository).should().deleteById(coffeeId);
    }



    private Coffee createCoffee(){
        Coffee coffee = Coffee.of(
                1L,
                "AME",
                "아메리카노",
                "Americano",
                4000,
                "판매 중",
                true

        );
        ReflectionTestUtils.setField(coffee,"id",1L);
        return coffee;
    }

    private CoffeeDto createCoffeeDto(){
        return createCoffeeDto("AME", "아메리카노", "Americano", 4000, "판매 중", true);
    }

    private CoffeeDto createCoffeeDto(  String coffeeCode, String korName, String engName ,Integer price , String orderStatus, boolean sizeSelectable){
        return CoffeeDto.of(
                1L,
                coffeeCode,
                korName,
                engName,
                price,
                orderStatus,
                sizeSelectable,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }



}