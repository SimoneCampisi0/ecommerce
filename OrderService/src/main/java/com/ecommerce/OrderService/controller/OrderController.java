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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/leggi-ordine")
    @Operation(summary = "Leggi un ordine.")
    public ResponseEntity<?> leggiOrdine(@RequestParam("idOrdine") Long idOrdine) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((OrderService)service).leggiOrdine(idOrdine));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/lista-ordini")
    @Operation(summary = "Lista degli ordini.")
    public ResponseEntity<?> listaOrdini() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((OrderService)service).listaOrdini());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/lista-ordini-per-cliente")
    @Operation(summary = "Lista degli ordini per cliente.")
    public ResponseEntity<?> listaOrdiniPerCliente(@RequestParam("idCliente") Long idCliente) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((OrderService)service).listaOrdiniPerCliente(idCliente));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }
}
