package com.example.www_doanhoaian_week02_restapi.repositories;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
    private static ConnectDB instance;
    private final EntityManagerFactory emf;

    private ConnectDB() {
        emf = Persistence.createEntityManagerFactory("bai02");
    }

    public static ConnectDB getInstance() {
        if(instance == null)
            instance = new ConnectDB();
        return instance;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
