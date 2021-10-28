package com.shop.data.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    private  Double price;
    @Column(length = 500)
    private String details;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ElementCollection()
    @ToString.Exclude
    private List<String> imageUrl;

    @OneToMany
    @ToString.Exclude
    private List<Feedback> feedbacks;
}
