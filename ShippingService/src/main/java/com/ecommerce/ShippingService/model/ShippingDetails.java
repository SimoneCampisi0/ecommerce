package com.ecommerce.ShippingService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShippingDetails;

    private String indirizzoConsegna;

    private String corriere;

    private String numeroTracking;

    @OneToOne(mappedBy = "shippingDetails")
    private Shipping shipping;
}
