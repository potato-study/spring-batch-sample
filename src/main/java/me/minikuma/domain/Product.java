package me.minikuma.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    private Long id;
    private String name;
    private int price;
    private String type;
}
