package com.ecommerce.ShippingService.model;

import com.ecommerce.ShippingService.utils.enums.ShippingStatus;
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
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShipping;

    private Long codOrdine;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_status")
    private ShippingStatus shippingStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_details_id", referencedColumnName = "idShippingDetails")
    private ShippingDetails shippingDetails;
}
