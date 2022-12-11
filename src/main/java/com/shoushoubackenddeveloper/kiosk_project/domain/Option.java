package com.shoushoubackenddeveloper.kiosk_project.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "korName"),
        @Index(columnList = "engName"),
        @Index(columnList = "price"),
        @Index(columnList = "createdAt")

}, name = "OPTION_TABLE")
@Entity
public class Option extends AuditingFields {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false, length = 20)
    private String korName;

    @Setter @Column(length = 20)
    private String engName;

    @Setter
    private Integer price;

    @OneToMany(mappedBy = "option", cascade = CascadeType.ALL)
    private final Set<CoffeeOrderOption> coffeeOrderOptions = new LinkedHashSet<>();

    private Option(String korName, String engName, Integer price) {
        this.korName = korName;
        this.engName = engName;
        this.price = price;
    }

    public static Option of(String korName, String engName, Integer price){
        return new Option(korName, engName, price);
    }

}
