package com.ecommerce.OrderService.controller;

import com.ecommerce.OrderService.controller.abstraction.AbstractController;
import com.ecommerce.OrderService.dto.request.SendOrderRequest;
import com.ecommerce.OrderService.dto.response.ErrorsResponse;
import com.ecommerce.OrderService.model.Orders;
import com.ecommerce.OrderService.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController extends AbstractController<Orders, Long> {
    @PostMapping("/ricezione-ordine")
    @Operation(summary = "Ricevi un ordine.")
    public ResponseEntity<?> riceviOrdine (@Valid @RequestBody SendOrderRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((OrderService)service).riceviOrdine(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }
}
