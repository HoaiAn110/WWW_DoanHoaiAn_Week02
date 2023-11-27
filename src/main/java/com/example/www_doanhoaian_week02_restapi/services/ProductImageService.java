package com.example.www_doanhoaian_week02_restapi.services;


import com.example.www_doanhoaian_week02_restapi.models.ProductImage;
import com.example.www_doanhoaian_week02_restapi.repositories.ProductImageRepository;

public class ProductImageService {
    private final ProductImageRepository productImageRepository;

    public ProductImageService() {
        productImageRepository = new ProductImageRepository();
    }
    public ProductImage getPatImage(long id){
        return productImageRepository.getImageByProductId(id);
    }
}
