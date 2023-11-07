package com.ecommerce.OrderService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDetails { //per ogni prodotto associato all'ordine viene generata questa entità
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderDetails;

    private Double costoParziale;

    private Integer quantita;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product soldProduct;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders associateOrders;
}
