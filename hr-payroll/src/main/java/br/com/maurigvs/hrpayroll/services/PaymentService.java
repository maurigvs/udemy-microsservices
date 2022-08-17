package br.com.maurigvs.hrpayroll.services;

import br.com.maurigvs.hrpayroll.entities.Payment;
import br.com.maurigvs.hrpayroll.entities.Worker;
import br.com.maurigvs.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient client;

    public Payment getPayment(Long workerId, int daysWorked){

        Worker worker = client.selectById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), daysWorked);
    }
}