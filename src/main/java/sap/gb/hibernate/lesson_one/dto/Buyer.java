package sap.gb.hibernate.lesson_one.dto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyer")
@NamedQuery(name = "Buyer.findAllId", query = "select b from Buyer b")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "buyer_product",
            joinColumns = @JoinColumn(name = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;


    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products.toArray() +
                '}';
    }
}

