package com.example.www_doanhoaian_week02_restapi.services;



import com.example.www_doanhoaian_week02_restapi.models.Product;
import com.example.www_doanhoaian_week02_restapi.models.ProductPrice;
import com.example.www_doanhoaian_week02_restapi.repositories.ProductPriceRepository;

import java.time.LocalDateTime;
import java.util.Map;

public class ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    public ProductPriceService() {
        productPriceRepository = new ProductPriceRepository();
    }

    public Double getPriceOfProduct(long productId){
        return productPriceRepository.getPrice(productId);
    }
    public Map<LocalDateTime, Double> getDateAndPriceByProductId(long productId) {
        return productPriceRepository.getDateAndPriceByProductId(productId);
    }

    public void insertProductPrice(ProductPrice productPrice) {
        productPriceRepository.insertProductPrice(productPrice);
    }
}
