package com.shoushoubackenddeveloper.kiosk_project.service;

import com.shoushoubackenddeveloper.kiosk_project.dto.OptionDto;
import com.shoushoubackenddeveloper.kiosk_project.repository.CoffeeOrderOptionRepository;
import com.shoushoubackenddeveloper.kiosk_project.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class CoffeeOrderOptionService {

    private final OptionRepository optionRepository;
    private final CoffeeOrderOptionRepository coffeeOrderOptionRepository;

    @Transactional(readOnly = true)
    public List<OptionDto> searchOption(long coffeeOrderOptionId) {
        return optionRepository.findByCoffeeOrderOption_Id(coffeeOrderOptionId)
                .stream()
                .map(OptionDto::from)
                .toList();
    }


}
