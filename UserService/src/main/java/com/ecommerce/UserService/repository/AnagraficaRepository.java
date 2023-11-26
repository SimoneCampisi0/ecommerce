package com.ecommerce.UserService.repository;

import com.ecommerce.UserService.model.Anagrafica;
import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnagraficaRepository extends GenericRepository<Anagrafica, Long> {

    Anagrafica findAnagraficaByUserIdUser(Long idUser);

}
