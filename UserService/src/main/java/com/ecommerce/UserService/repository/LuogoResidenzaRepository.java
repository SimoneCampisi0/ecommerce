package com.ecommerce.UserService.repository;

import com.ecommerce.UserService.model.LuogoResidenza;
import com.ecommerce.UserService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuogoResidenzaRepository extends GenericRepository<LuogoResidenza, Long> {
}
