package com.ecommerce.OrderService.controller;

import com.ecommerce.OrderService.controller.abstraction.AbstractController;
import com.ecommerce.OrderService.dto.request.InvioOrdineRequest;
import com.ecommerce.OrderService.dto.response.ErrorsResponse;
import com.ecommerce.OrderService.model.Ordine;
import com.ecommerce.OrderService.service.OrdineService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controller")
public class OrdineController extends AbstractController<Ordine, Long> {
    @PostMapping("/ricezione-ordine")
    @Operation(summary = "Ricevi un ordine.")
    public ResponseEntity<?> riceviOrdine (@Valid @RequestBody InvioOrdineRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((OrdineService)service).riceviOrdine(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }
}
