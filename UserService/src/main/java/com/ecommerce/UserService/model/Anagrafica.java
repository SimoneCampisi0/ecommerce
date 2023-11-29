package com.ecommerce.UserService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Anagrafica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnagrafica;

    private String nome;

    private String cognome;

    private Date dataNascita;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "luogo_residenza_id", referencedColumnName = "idLuogoResidenza")
    private LuogoResidenza luogoResidenza;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;
}
