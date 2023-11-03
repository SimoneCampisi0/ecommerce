package com.ecommerce.UserService.repository;

import com.ecommerce.UserService.model.User;
import com.ecommerce.UserService.repository.abstraction.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, Long> {
}
