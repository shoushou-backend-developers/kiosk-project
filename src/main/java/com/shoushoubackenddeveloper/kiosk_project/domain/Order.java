package com.shoushoubackenddeveloper.kiosk_project.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "ORDER_TABLE")
public class Order extends AuditingFields {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false)
    private Integer orderNo;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private final Set<CoffeeOrder> coffeeOrder = new LinkedHashSet<>();

    private Order(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public static Order of(Integer orderNo) {
        return new Order(orderNo);
    }

}
