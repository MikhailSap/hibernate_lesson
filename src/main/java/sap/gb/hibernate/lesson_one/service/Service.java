package sap.gb.hibernate.lesson_one.service;

import sap.gb.hibernate.lesson_one.dto.Buyer;
import sap.gb.hibernate.lesson_one.dto.Product;

import java.util.List;

public interface Service {

    List<Product> getProductsByBuyerId(long buyerId);

    List<Buyer> getBuyersByProductId(long productId);

    List<Buyer> getAllBuyers();

    List<Product> getAllProducts();

    void deleteBuyer(long id);

    void deleteProduct(long id);
}
