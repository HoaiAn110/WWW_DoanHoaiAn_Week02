package com.example.www_doanhoaian_week02_restapi.repositories;


import com.example.www_doanhoaian_week02_restapi.dto.Cart;
import com.example.www_doanhoaian_week02_restapi.enums.ProductStatus;
import com.example.www_doanhoaian_week02_restapi.models.Product;
import com.example.www_doanhoaian_week02_restapi.services.ProductPriceService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final ProductPriceService productPriceService = new ProductPriceService();
    private final EntityManager em;
    private final EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertProduct(Product product) {
        try {
            transaction.begin();
            em.persist(product);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void setStatus(Product product, ProductStatus status) {
        product.setProductStatus(status);
    }

    public void update(Product product) {
        try {
            transaction.begin();
            em.merge(product);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            logger.error(ex.getMessage());
        }
    }

    public Optional<Product> findById(long id) {
        Product rs = em.find(Product.class, id);
        return rs == null ? Optional.empty() : Optional.of(rs);
    }

    public List<Product> getProducts() {
        return em.createNamedQuery("Product.findAll", Product.class)
                .setParameter("status", ProductStatus.ACTIVE)
                .getResultList();
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        if (!cartList.isEmpty()) {
            for (Cart item : cartList) {
                Product product = em.find(Product.class, item.getId());
                System.out.println(product);
                Cart row = new Cart();
                row.setId(item.getId());
                row.setName(product.getName());
                row.setDescription(product.getDescription());
                row.setQuantity(item.getQuantity());
                double price = productPriceService.getPriceOfProduct(item.getId());
                row.setPrice(price * item.getQuantity());
                book.add(row);
            }
        }
        return book;
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        if (!cartList.isEmpty()) {
            for (Cart item : cartList) {
                double price = productPriceService.getPriceOfProduct(item.getId());
                sum += price * item.getQuantity();
            }
        }
        return sum;
    }

    public String getProductNameById(long id){
        return em.createNamedQuery("Product.getProductByName",String.class)
                .setParameter("id",id)
                .getSingleResult();
    }

}
