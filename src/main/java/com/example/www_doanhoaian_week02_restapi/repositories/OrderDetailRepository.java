package com.example.www_doanhoaian_week02_restapi.repositories;


import com.example.www_doanhoaian_week02_restapi.models.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public class OrderDetailRepository {
    private final EntityManager em;
    private final EntityTransaction transaction;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderDetailRepository() {
        em = ConnectDB.getInstance().getEntityManagerFactory().createEntityManager();
        transaction = em.getTransaction();
    }
    public void insertOrderDetail(OrderDetail orderDetail){
        try {
            transaction.begin();
            em.persist(orderDetail);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public void update(OrderDetail orderDetailUpdate){
        try {
            transaction.begin();
            em.merge(orderDetailUpdate);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }

    public double getTotalPrice(long orderId){
        return em.createNamedQuery("OrderDetail.getTotalPrice",Double.class)
                .setParameter("id",orderId)
                .getSingleResult();
    }

    public Map<Long, Double> staticsPriceByProduct() {
        try {
            List<Object[]> resultList = em.createNamedQuery("OrderDetail.staticsPriceByProduct")
                    .getResultList();
            return resultList.parallelStream()
                    .collect(Collectors.toMap(
                            objects -> ((Number) objects[0]).longValue(),
                            objects -> ((Number) objects[1]).doubleValue(),
                            (n1, n2) -> n2,
                            TreeMap::new
                    ));
        } catch (PersistenceException | IllegalStateException exception) {
            // Handle specific exceptions or log the entire exception stack trace
            System.out.println("Exception occurred: " + exception.getMessage());
        }
        return new TreeMap<>();
    }


}
