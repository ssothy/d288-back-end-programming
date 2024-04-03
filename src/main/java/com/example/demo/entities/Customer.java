package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private Long id;

    @Column(name = "Customer_First_Name")
    private String firstName;

    @Column(name = "Customer_Last_Name")
    private String lastName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Postal_Code")
    private String postal_code;

    @Column(name = "Phone")
    private String phone;

    @CreationTimestamp
    @Column(name = "Create_Date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "Last_Update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "Division_ID", nullable = false)
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;

    public static void add(Cart cart) {
        Customer.add(cart);
    }
}
