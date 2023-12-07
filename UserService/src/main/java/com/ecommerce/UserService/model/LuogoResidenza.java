package com.ecommerce.UserService.model;

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
public class LuogoResidenza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLuogoResidenza;

    private String stato;

    private String provincia;

    private String comune;

    private String indirizzo;

    private String civico;

    private String CAP;

    @OneToOne(mappedBy = "luogoResidenza")
    private Anagrafica anagrafica;
}
