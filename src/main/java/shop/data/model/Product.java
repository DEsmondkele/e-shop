package shop.data.model;

import lombok.Data;

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

    private String details;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> imageUrl;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Feedback> feedbacks;
}
