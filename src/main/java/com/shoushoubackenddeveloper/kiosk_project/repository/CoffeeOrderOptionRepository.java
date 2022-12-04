package com.shoushoubackenddeveloper.kiosk_project.repository;

import com.shoushoubackenddeveloper.kiosk_project.domain.CoffeeOrderOption;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CoffeeOrderOptionRepository extends JpaRepository<CoffeeOrderOption, Long> {
}