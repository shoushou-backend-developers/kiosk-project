package com.shoushoubackenddeveloper.kiosk_project.repository;

import com.shoushoubackenddeveloper.kiosk_project.domain.CoffeeOrderOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CoffeeOrderOptionRepository extends JpaRepository<CoffeeOrderOption, Long> {

    List<CoffeeOrderOption> findByCoffeeOrderId(Long coffeeOrderId);
}
