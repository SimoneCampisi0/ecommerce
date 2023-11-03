package com.ecommerce.UserService.model;

import com.ecommerce.UserService.utils.enums.AuthServer;
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

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private AuthServer authServer;

}
