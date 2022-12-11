package com.shoushoubackenddeveloper.kiosk_project.service;

import com.shoushoubackenddeveloper.kiosk_project.dto.OptionDto;
import com.shoushoubackenddeveloper.kiosk_project.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class OptionService {

    private final OptionRepository optionRepository;

    public void saveOption(OptionDto dto){
    }
    public void updateOption(OptionDto dto){
    }
    public void deleteOption(OptionDto dto){
    }
}
