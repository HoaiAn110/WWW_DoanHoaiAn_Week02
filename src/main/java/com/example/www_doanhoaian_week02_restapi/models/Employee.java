package com.example.www_doanhoaian_week02_restapi.models;


import com.example.www_doanhoaian_week02_restapi.enums.EmployeeStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NamedQueries(
        {
                @NamedQuery(
                        name = "Employee.findAll", query = "select e from Employee e where e.employeeStatus =: status"
                )
        }
)
//@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
public class Employee {
    @Column(columnDefinition = "DATETIME(6)")
    private LocalDateTime dob;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(length = 150)
    private String email;
    @Column(length = 250)
    private String address;
    @Column(name = "status", columnDefinition = "INT(11)")
    private EmployeeStatus employeeStatus;
    @Column(length = 15)
    private String phone;
    @Column(name = "full_name", length = 150)
    private String fullName;
    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    public Employee() {
    }

    public Employee(long id) {
        this.id = id;
    }

    public Employee(LocalDateTime dob, long id, String email,
                    String address, EmployeeStatus employeeStatus, String phone, String fullName) {
        this.dob = dob;
        this.id = id;
        this.email = email;
        this.address = address;
        this.employeeStatus = employeeStatus;
        this.phone = phone;
        this.fullName = fullName;
    }

    public Employee(LocalDateTime dob, String email, String address, EmployeeStatus employeeStatus, String phone, String fullName) {
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.employeeStatus = employeeStatus;
        this.phone = phone;
        this.fullName = fullName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
