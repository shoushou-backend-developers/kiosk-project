package com.shoushoubackenddeveloper.kiosk_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "quantity"),
})
@Entity
public class CoffeeOrderOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO 연관관계 매핑 용현님과 의논 하여 확실하게 짜기
    @Setter @ManyToOne(optional = false) private Option option;
    @Setter @ManyToOne(optional = false) private CoffeeOrder coffeeOrder;
    @Setter @Column(nullable = false) private int quantity;

    private CoffeeOrderOption(Option option, CoffeeOrder coffeeOrder, int quantity) {
        this.option = option;
        this.coffeeOrder = coffeeOrder;
        this.quantity = quantity;
    }

    protected CoffeeOrderOption() {

    }

    public static  CoffeeOrderOption of(Option option, CoffeeOrder coffeeOrder, int quantity){
        return new CoffeeOrderOption(option, coffeeOrder, quantity);
    }
}
