package com.ecommerce.OrderService.controller;

import com.ecommerce.OrderService.controller.abstraction.AbstractController;
import com.ecommerce.OrderService.dto.request.CreateProductRequest;
import com.ecommerce.OrderService.dto.request.UpdateProductRequest;
import com.ecommerce.OrderService.dto.response.ErrorsResponse;
import com.ecommerce.OrderService.model.Product;
import com.ecommerce.OrderService.service.ProductService;
import com.ecommerce.OrderService.utils.enums.SortingOrder;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController extends AbstractController<Product, Long> {
    @PostMapping("/crea-prodotto")
    @Operation(summary = "Crea un prodotto.")
    public ResponseEntity<?> creaProdotto (@Valid @RequestBody CreateProductRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ProductService)service).creaProdotto(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/leggi-prodotto")
    @Operation(summary = "Leggi un prodotto.")
    public ResponseEntity<?> leggiProdotto(@RequestParam("idProdotto") Long idProdotto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ProductService)service).leggiProdotto(idProdotto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping("/lista-prodotti")
    @Operation(summary = "Lista dei prodotti.")
    public ResponseEntity<?> listaProdotti() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ProductService)service).listaProdotti());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @GetMapping()
    @Operation(summary = "Lista paginata prodotti.")
    public ResponseEntity<?> listaProdottiPage(
                    @RequestParam(defaultValue = "0") Integer pageNumber,
                    @RequestParam(defaultValue = "10") Integer pageSize,
                    @RequestParam(defaultValue = "productName") String sortBy,
                    @RequestParam(defaultValue = "ASC") SortingOrder sortingOrder,
                    @RequestParam(required = false) String sortingFilter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ProductService)service).listaProdottiPage(pageNumber, pageSize, sortBy, sortingOrder, sortingFilter));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @PutMapping("/modifica-prodotto")
    @Operation(summary = "Modifica un prodotto.")
    public ResponseEntity<?> modificaProdotto(@Valid @RequestBody UpdateProductRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ProductService)service).modificaProdotto(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/elimijna-prodotto")
    @Operation(summary = "Elimina un prodotto.")
    public ResponseEntity<?> eliminaProdotto(@RequestParam("idProdotto") Long idProdotto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ProductService)service).eliminaProdotto(idProdotto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }
}
