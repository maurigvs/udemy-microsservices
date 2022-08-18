package br.com.maurigvs.hrpayroll.resources;

import br.com.maurigvs.hrpayroll.entities.Payment;
import br.com.maurigvs.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{daysWorked}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer daysWorked){

        Payment payment = service.getPayment(workerId, daysWorked);
        return ResponseEntity.ok().body(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer daysWorked){

        Payment payment = new Payment("Fake Worker", 1.0, daysWorked);
        return ResponseEntity.ok().body(payment);
    }
}
