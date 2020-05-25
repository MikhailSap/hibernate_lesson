package sap.gb.hibernate.lesson_one.service;

import sap.gb.hibernate.lesson_one.dto.Buyer;
import sap.gb.hibernate.lesson_one.dto.Product;
import sap.gb.hibernate.lesson_one.persist.BuyerDAO;
import sap.gb.hibernate.lesson_one.persist.ProductDAO;

import java.util.List;

public class ServiceImpl implements Service {
    private BuyerDAO buyerDAO;
    private ProductDAO productDAO;


    public ServiceImpl(BuyerDAO buyerDAO, ProductDAO productDAO) {
        this.buyerDAO = buyerDAO;
        this.productDAO = productDAO;
    }


    public List<Product> getProductsByBuyerId(long buyerId) {
        Buyer buyer = buyerDAO.findById(buyerId);
        List<Product> products = buyer.getProducts();
        return products;
    }

    public List<Buyer> getBuyersByProductId(long productId) {
        Product product = productDAO.findById(productId);
        List<Buyer> buyers = product.getBuyers();
        return buyers;
    }

    public List<Buyer> getAllBuyers() {
        return buyerDAO.findAll();
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public void deleteBuyer(long id) {
        buyerDAO.delete(id);

    }

    public void deleteProduct(long id) {
        productDAO.delete(id);
    }
}
