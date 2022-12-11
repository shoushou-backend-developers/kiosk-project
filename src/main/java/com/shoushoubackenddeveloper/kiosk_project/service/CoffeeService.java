package com.shoushoubackenddeveloper.kiosk_project.service;

import com.shoushoubackenddeveloper.kiosk_project.domain.Coffee;
import com.shoushoubackenddeveloper.kiosk_project.dto.CoffeeDto;
import com.shoushoubackenddeveloper.kiosk_project.repository.CoffeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Transactional(readOnly = true)
    public CoffeeDto getCoffee(Long coffeeId){
        return coffeeRepository.findById(coffeeId)
                .map(CoffeeDto::from)
                .orElseThrow(() -> new EntityNotFoundException("커피가 없습니다 - coffeeId: " + coffeeId));
    }

    public void saveCoffee(CoffeeDto dto){
        coffeeRepository.save(dto.toEntity());

    }
    public void updateCoffee(CoffeeDto dto){
        try{

            Coffee coffee = coffeeRepository.getReferenceById(dto.id());
            if(dto.coffeeCode() != null) {coffee.setCoffeeCode(dto.coffeeCode());}
            if(dto.coffeeCode() != null) {coffee.setKorName(dto.korName());}
            if(dto.coffeeCode() != null) {coffee.setEngName(dto.engName());}
            if(dto.coffeeCode() != null) {coffee.setPrice(dto.price());}
            if(dto.coffeeCode() != null) {coffee.setOrderStatus(dto.orderStatus());}
            if(dto.coffeeCode() != null) {coffee.setSizeSelectable(dto.sizeSelectable());}

//        coffeeRepository.save(coffee);
// 클래스 단위로 트랜잭션이 되어있기때문에 save가 별도로 필요없다
        } catch (EntityNotFoundException e){
            log.warn("커피 업데이트 실패. 커피를 찾을 수 없습니다 - dto{}",dto);
        }

    }

    public void deleteCoffee(long coffeeId){
        coffeeRepository.deleteById(coffeeId);
    }
}
