package com.shoushoubackenddeveloper.kiosk_project.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class CoffeeOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false)
    private Order order;

    @Setter @ManyToOne(optional = false)
    private Coffee coffee;

    @Setter @Column(nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "coffeeOrder", cascade = CascadeType.ALL)
    @ToString.Exclude
    private final Set<CoffeeOrderOption> coffeeOrderOptions = new LinkedHashSet<>();

    private CoffeeOrder(Order order, Coffee coffee, Integer quantity){
        this.order = order;
        this.coffee = coffee;
        this.quantity = quantity;
    }

    public static CoffeeOrder of(Order order, Coffee coffee, Integer quantity){
        return new CoffeeOrder(order, coffee, quantity);
    }

}
