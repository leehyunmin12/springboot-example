package com.example.fisrtproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String price;

    public Long getId() { return id; }

    public void patch(Coffee coffee) {
        if(coffee.name!=null){
            this.name = coffee.name;
        }
        if(coffee.price!=null){
            this.price = coffee.price;
        }
    }
}
