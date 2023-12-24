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

    /* TODO: Le chiamate non provenienti dall'UserService danno errore 403. Risolvere.
        Le richieste non arrivano qui nel ProductService, ma si bloccano nel gateway.
        E' come se i CORS si rompessero nella comunicazione tra il Gateway e il microservizio ProductService.
        Possibili ipotesi:
        Indagando, NON bisogna impostare i CORS in ogni microservizio, ma soltanto nel gateway, così com'è ora.
        Piuttosto, sembra esserci un problema quando un microservizio, dopo che il gateway accetta la sua request, esegue la validazione.

        Controllare esattamente cosa avviene prima, dopo e durante la validazione, sembra essere lì il problema.
        Controlla anche la response HTTP ottenuta da Postman quando si interroga un microservizio.

        Può essere che il problema stia in Angular, nella chiamata get.

        RIVEDERE JWT e SECURITY

    */

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
    public ResponseEntity<?> listaProdottiPaginata(
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

    @DeleteMapping("/elimina-prodotto")
    @Operation(summary = "Elimina un prodotto.")
    public ResponseEntity<?> eliminaProdotto(@RequestParam("idProdotto") Long idProdotto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ProductService)service).eliminaProdotto(idProdotto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorsResponse(e.getMessage()));
        }
    }
}
