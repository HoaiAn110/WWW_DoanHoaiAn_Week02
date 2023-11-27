package com.example.www_doanhoaian_week02_restapi.models;

import jakarta.persistence.*;

@Entity
@NamedQueries(
        @NamedQuery(
                name = "ProductImage.getImage",query = "select pi from ProductImage pi where pi.product.id =: id"
        )
)
@Table(name = "product_image")
public class ProductImage {
    private String alternative;
    private String path;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long id;

    public ProductImage() {
    }

    public ProductImage(String alternative, String path, Product product) {
        this.alternative = alternative;
        this.path = path;
        this.product = product;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
