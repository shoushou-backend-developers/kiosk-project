package com.shoushoubackenddeveloper.kiosk_project.service;

import com.shoushoubackenddeveloper.kiosk_project.domain.Option;
import com.shoushoubackenddeveloper.kiosk_project.dto.OptionDto;
import com.shoushoubackenddeveloper.kiosk_project.repository.CoffeeOrderOptionRepository;
import com.shoushoubackenddeveloper.kiosk_project.repository.OptionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 주문 선택한 커피")
@ExtendWith(MockitoExtension.class)
public class CoffeeOrderOptionServiceTest {

    @InjectMocks private CoffeeOrderOptionService sut;
    @Mock private CoffeeOrderOptionRepository coffeeOrderOptionRepository;
    @Mock private OptionRepository optionRepository;



    @DisplayName("커피를 주문한 주문커피 ID로 조회하면, 해당하는 옵션을 반환한다.")
    @Test
    void givenCoffeeOrderOptionsId_whenSearchingOptions_thenReturnsOptions(){
        // Given
        Long coffeeOrderOptionId = 1L;
        Option expected = createOption("시럽", "Syrup",500);
        given(optionRepository.findByCoffeeOrderOption_Id(coffeeOrderOptionId)).willReturn(List.of(expected));

        // When
        List<OptionDto> actual = sut.searchOption(coffeeOrderOptionId);

        // Then
        assertThat(actual)
                .hasSize(1)
                .first().hasFieldOrPropertyWithValue("korName", expected.getKorName());
        then(optionRepository).should().findByCoffeeOrderOption_Id(coffeeOrderOptionId);
    }
    private Option createOption( String korName,String engName, Integer price){
        return Option.of(
                "시럽",
                "Syrup",
                500
        );
    }
}
