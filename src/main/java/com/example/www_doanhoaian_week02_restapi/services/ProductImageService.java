package com.example.www_doanhoaian_week02_restapi.services;


import com.example.www_doanhoaian_week02_restapi.models.Product;
import com.example.www_doanhoaian_week02_restapi.models.ProductImage;
import com.example.www_doanhoaian_week02_restapi.repositories.ProductImageRepository;
import jakarta.persistence.NoResultException;

public class ProductImageService {
    private final ProductImageRepository productImageRepository;

    public ProductImageService() {
        productImageRepository = new ProductImageRepository();
    }
    public ProductImage getPatImage(long id){
        return productImageRepository.getImageByProductId(id);
    }

    public void insertProductImage(ProductImage productImage) {
        productImageRepository.insertProductImage(productImage);
    }

    public ProductImage getPatImage(Long productId) {
        try {
            // your existing code to retrieve ProductImage
            return productImageRepository.getImageByProductId(productId);
        } catch (NoResultException e) {
            // log the exception or handle it as appropriate
            return null; // or throw a custom exception
        }
    }

}
