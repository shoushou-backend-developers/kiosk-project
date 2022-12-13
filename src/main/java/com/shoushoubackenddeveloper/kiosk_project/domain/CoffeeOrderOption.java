package com.shoushoubackenddeveloper.kiosk_project.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

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
    private CoffeeOrder coffeeOrder;

    @Setter @Column(nullable = false)
    private Integer quantity;
    @Setter @OneToMany(mappedBy = "coffeeOrderOption" , cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Option> option = new LinkedHashSet<>();

    private CoffeeOrderOption(Option option, CoffeeOrder coffeeOrder, Integer quantity) {
        this.coffeeOrder = coffeeOrder;
        this.quantity = quantity;
    }

    public static  CoffeeOrderOption of(Option option, CoffeeOrder coffeeOrder, Integer quantity){
        return new CoffeeOrderOption(option, coffeeOrder, quantity);
    }

}
