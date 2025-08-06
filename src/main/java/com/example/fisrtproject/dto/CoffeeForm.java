package com.example.fisrtproject.dto;

import com.example.fisrtproject.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CoffeeForm {
    private Long id;
    private String name;
    private String price;

    public Coffee ToEntity() {
        return new Coffee(id, name, price);
    }
}
