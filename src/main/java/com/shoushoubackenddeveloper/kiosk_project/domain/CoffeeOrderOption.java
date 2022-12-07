package com.shoushoubackenddeveloper.kiosk_project.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "quantity"),
})
@Entity
public class CoffeeOrderOption {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false)
    private Option option;

    @Setter @ManyToOne(optional = false)
    private CoffeeOrder coffeeOrder;

    @Setter @Column(nullable = false)
    private Integer quantity;

    private CoffeeOrderOption(Option option, CoffeeOrder coffeeOrder, Integer quantity) {
        this.option = option;
        this.coffeeOrder = coffeeOrder;
        this.quantity = quantity;
    }

    public static  CoffeeOrderOption of(Option option, CoffeeOrder coffeeOrder, Integer quantity){
        return new CoffeeOrderOption(option, coffeeOrder, quantity);
    }

}
