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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String email;

    private String password;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "anagrafica_id", referencedColumnName = "idAnagrafica")
    @OneToOne(mappedBy = "user")
    private Anagrafica anagrafica;
}
