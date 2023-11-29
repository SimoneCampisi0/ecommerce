package com.ecommerce.UserService.service;

import com.ecommerce.UserService.model.LuogoResidenza;
import com.ecommerce.UserService.service.abstraction.GenericService;
import com.ecommerce.UserService.service.helper.LuogoResidenzaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LuogoResidenzaService extends GenericService<LuogoResidenza, Long> {
    @Autowired
    private LuogoResidenzaHelper helper;
}
