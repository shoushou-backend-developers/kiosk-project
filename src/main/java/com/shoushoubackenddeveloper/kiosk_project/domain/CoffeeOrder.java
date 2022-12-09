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
public class CoffeeOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false)
    private Orders orders;

    @Setter @ManyToOne(optional = false)
    private Coffee coffee;

    @Setter @Column(nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "coffeeOrder", cascade = CascadeType.ALL)
    private final Set<CoffeeOrderOption> coffeeOrderOptions = new LinkedHashSet<>();

    private CoffeeOrder(Orders orders, Coffee coffee, Integer quantity){
        this.orders = orders;
        this.coffee = coffee;
        this.quantity = quantity;
    }

    public static CoffeeOrder of(Orders orders, Coffee coffee, Integer quantity){
        return new CoffeeOrder(orders, coffee, quantity);
    }

}
