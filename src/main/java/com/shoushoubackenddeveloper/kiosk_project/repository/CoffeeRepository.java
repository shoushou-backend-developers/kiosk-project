package com.shoushoubackenddeveloper.kiosk_project.repository;

import com.shoushoubackenddeveloper.kiosk_project.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
