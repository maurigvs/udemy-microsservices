package br.com.maurigvs.hrpayroll.services;

import br.com.maurigvs.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int daysWorked){
        return new Payment("Bob Brown", 250.00, daysWorked);
    }
}
