package com.example.www_doanhoaian_week02_restapi.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Customer.findAll",query = "select c from Customer c"
        )
})
public class Customer {
    @Column(length = 250)
    private String address;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long id;
    @Column(name = "cust_name",length = 150)
    private String name;
    @Column(length = 150)
    private String email;
    @Column(length = 15)
    private String phone;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer() {
    }

    public Customer(long id) {
        this.id = id;
    }

    public Customer(String address, long id, String name, String email, String phone) {
        this.address = address;
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Customer(String address, String name, String email, String phone) {
        this.address = address;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
