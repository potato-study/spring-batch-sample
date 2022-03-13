package me.minikuma.batch.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
    private Long id;
    private String name;
    private int price;
    private String type;
}
