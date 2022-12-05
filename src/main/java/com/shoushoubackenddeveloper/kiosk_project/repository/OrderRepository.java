package com.shoushoubackenddeveloper.kiosk_project.repository;

import com.shoushoubackenddeveloper.kiosk_project.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
