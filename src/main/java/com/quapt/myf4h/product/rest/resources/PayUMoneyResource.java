/**
 * 
 *//*
package com.quapt.myf4h.product.rest.resources;

import com.quapt.myf4h.product.domain.Payment;
import com.quapt.myf4h.product.repository.PaymentRepository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

*//**
 * @author logesh
 *
 *//*
@RestController
@RequestMapping("/api/payumoney")
public class PayUMoneyResource {
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Payment>> list() {

        List<Payment> result = paymentRepository.findAll();
        return ResponseEntity.ok(result);

    }
    
    @RequestMapping(value = "/success", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> success() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Message", "Success");       
        Payment payment = new Payment();
        payment.setMessage("Success");
        payment.setStatus("true");
        Payment result = paymentRepository.insert(payment);
        return ResponseEntity.ok(result);

    }

    @RequestMapping(value = "/failure", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> failure() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Message", "Failure");
        Payment payment = new Payment();
        payment.setMessage("Failure");
        payment.setStatus("false");
        Payment result = paymentRepository.insert(payment);
        return ResponseEntity.ok(result);

    }

    @RequestMapping(value = "/cancel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cancel() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Message", "Canceled");
        Payment payment = new Payment();
        payment.setMessage("Canceled");
        payment.setStatus("false");
        Payment result = paymentRepository.insert(payment);
        return ResponseEntity.ok(result);

    }

}
*/