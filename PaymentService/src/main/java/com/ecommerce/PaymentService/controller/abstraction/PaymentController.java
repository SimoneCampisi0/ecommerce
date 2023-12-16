package com.ecommerce.PaymentService.controller.abstraction;

import com.ecommerce.PaymentService.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments-controller")
public class PaymentController extends AbstractController<Payment, Long> {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DATI_NON_VALIDI");
    }


}
