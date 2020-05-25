package sap.gb.hibernate.lesson_one.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "product")
@NamedQuery(name = "Product.findAll", query = "select p from Product p")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int price;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "buyer_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "buyer_id"))
    private List<Buyer> buyers;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", buyers=" + buyers.toArray() +
                '}';
    }
}
