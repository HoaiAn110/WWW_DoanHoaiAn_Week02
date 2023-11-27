package com.example.www_doanhoaian_week02_restapi.services;



import com.example.www_doanhoaian_week02_restapi.dto.Cart;
import com.example.www_doanhoaian_week02_restapi.enums.ProductStatus;
import com.example.www_doanhoaian_week02_restapi.models.Product;
import com.example.www_doanhoaian_week02_restapi.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    public void insertProduct(Product product) {
        productRepository.insertProduct(product);
    }

    public void deleteProduct(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            final var employeeStatus = ProductStatus.TERMINATED;
            productRepository.setStatus(product,employeeStatus);
            productRepository.update(product);
        }
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public List<Cart> getProductByCart(ArrayList<Cart> carts){
        return productRepository.getCartProducts(carts);
    }


}
