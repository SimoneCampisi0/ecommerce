package com.ecommerce.OrderService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String productName;

    private String productDesq;

    private Double productCost;

    private Boolean available;

    private Long codSeller;

    @OneToMany(mappedBy = "soldProduct")
    Set<OrdersDetails> ordersDetails;

}
