package com.ecommerce.PaymentService.model;

import com.ecommerce.PaymentService.utils.enums.StatoPagamento;
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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    private Double importo;

    private StatoPagamento statoPagamento;

    private Long codOrdine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_payment_method", referencedColumnName = "idPaymentMethod")
    private PaymentMethod paymentMethod;
}
