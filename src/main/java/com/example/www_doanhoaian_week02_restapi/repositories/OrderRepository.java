package com.example.www_doanhoaian_week02_restapi.repositories;


import com.example.www_doanhoaian_week02_restapi.models.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }
    public void insertOrder(Order order){
        try {
            transaction.begin();
            em.persist(order);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public Optional<Order> getOrderLatest(){
       Order order =  em.createNamedQuery("Order.getOrderLast", Order.class)
                .getSingleResult();
       return Optional.ofNullable(Optional.of(order).orElseThrow(() -> new RuntimeException("Not found")));
    }

    public List<Order> getAll(){
        return em.createNamedQuery("Order.getAll",Order.class).getResultList();
    }
}
