package com.shoushoubackenddeveloper.kiosk_project.repository;

import com.shoushoubackenddeveloper.kiosk_project.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByCoffeeOrderOption_Id(Long coffeeOrderOptionId);
}
