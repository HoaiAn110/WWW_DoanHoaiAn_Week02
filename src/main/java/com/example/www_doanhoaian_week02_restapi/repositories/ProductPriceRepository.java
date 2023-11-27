package com.example.www_doanhoaian_week02_restapi.repositories;


import com.example.www_doanhoaian_week02_restapi.models.ProductPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//@ApplicationScoped
public class ProductPriceRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertProductPrice(ProductPrice productPrice){
        try {
            transaction.begin();
            em.persist(productPrice);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public Double getPrice(long productId){
        return em.createNamedQuery("ProductPrice.getPriceByProductId",Double.class)
                .setParameter("id",productId)
                .getSingleResult();
    }

    public Map<LocalDateTime, Double> getDateAndPriceByProductId(long productId) {
        try {
            return (Map<LocalDateTime, Double>) em.createNamedQuery("ProductPrice.getDateAndPriceByProductId")
                    .setParameter("productId", productId)
                    .getResultList()
                    .parallelStream()
                    .collect(Collectors.toMap((Object[] objects) -> {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                        return LocalDateTime.parse(objects[0].toString(), formatter);
                    }, (Object[] objects) -> ((Number) objects[1]).doubleValue(), Double::sum, TreeMap::new));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return new TreeMap<>();
    }
}
