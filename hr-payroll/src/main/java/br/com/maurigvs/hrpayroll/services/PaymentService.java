package br.com.maurigvs.hrpayroll.services;

import br.com.maurigvs.hrpayroll.entities.Payment;
import br.com.maurigvs.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, int daysWorked){

        Map<String, String> params = new HashMap<>();
        params.put("id",""+workerId);

        String url = workerHost + "/workers/{id}";

        Worker worker = restTemplate.getForObject(url, Worker.class, params);

        return new Payment(worker.getName(), worker.getDailyIncome(), daysWorked);
    }
}
