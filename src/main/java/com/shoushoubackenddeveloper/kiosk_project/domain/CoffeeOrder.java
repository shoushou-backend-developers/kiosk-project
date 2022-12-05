package com.shoushoubackenddeveloper.kiosk_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "quantity")
})
@Entity
public class CoffeeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Setter ManyToOne Coffee coffee;
//    @Setter ManyToOne Order order;

    @Setter @Column(nullable = false) private int quantity;



    private CoffeeOrder(int quantity) {
        this.quantity = quantity;
    }

    protected CoffeeOrder() {
    }

    public static CoffeeOrder of(int quantity){
        return new CoffeeOrder(quantity);
    }
}
