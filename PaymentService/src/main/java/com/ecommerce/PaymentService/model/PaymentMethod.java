package com.ecommerce.PaymentService.model;

import com.ecommerce.PaymentService.dto.common.MetodoPagamentoEnum;
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
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaymentMethod;

    private MetodoPagamentoEnum metodoPagamentoEnum;

    private String titolareCarta;

    private String emittente;

    private String numeroCarta;

    private String scadenzaCarta;

    private String CVV;

    @OneToOne(mappedBy = "paymentMethod")
    private Payment payment;
}
