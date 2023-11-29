package com.ecommerce.UserService.dto.request;

import com.ecommerce.UserService.dto.request.abstraction.AbstractAnagraficaRequest;
import lombok.Data;

@Data
public class CreateAnagraficaRequest extends AbstractAnagraficaRequest {

    private CreateLuogoResidenzaRequest luogoResidenzaRequest;

}
