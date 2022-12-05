package com.shoushoubackenddeveloper.kiosk_project.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(indexes = {
        @Index(columnList = "coffeeCode"),
        @Index(columnList = "korName"),
        @Index(columnList = "engName")
})
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, unique = true, length = 3)
    private String coffeeCode;

    @Setter
    @Column(nullable = false, length = 10)
    private String korName;

    @Setter
    @Column(length = 20)
    private String engName;

    @Setter
    @Column(nullable = false)
    private Integer price;

    @Setter
    @Column(nullable = false, length = 6)
    private String orderStatus;

    private Coffee(String coffeeCode, String korName, String engName, Integer price, String orderStatus) {
        this.coffeeCode = coffeeCode;
        this.korName = korName;
        this.engName = engName;
        this.price = price;
        this.orderStatus = orderStatus;
    }

    public static Coffee of(String coffeeCode, String korName, String engName, Integer price, String orderStatus) {
        return new Coffee(coffeeCode, korName, engName, price, orderStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee that)) return false;
        return coffeeCode != null && !coffeeCode.isBlank() && coffeeCode.equals(that.getCoffeeCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeCode);
    }

}
