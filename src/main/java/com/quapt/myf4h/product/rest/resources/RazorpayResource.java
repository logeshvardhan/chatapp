/**
 * 
 */
package com.quapt.myf4h.product.rest.resources;

import com.quapt.myf4h.product.domain.OrderDetails;
import com.quapt.myf4h.product.domain.PaymentDetails;
import com.quapt.myf4h.product.persistence.config.RazorpayConfigurer;
import com.quapt.myf4h.product.repository.OrderRepository;
import com.quapt.myf4h.product.rest.dto.PaymentDetailsDto;
import com.quapt.myf4h.product.service.RazorpayService;
import com.quapt.myf4h.product.service.mapper.RazorpayMapper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author logesh
 *
 */
@RestController
@RequestMapping("/api/razorpay")
public class RazorpayResource {

    @Autowired
    private RazorpayConfigurer razorpayConfigurer;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RazorpayService razorpayService;
    
    @Autowired
    private RazorpayMapper razorpayMapper;

    @RequestMapping(value = "/payment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> payments() {
        try {

            List<Payment> payments = razorpayConfigurer.razorpayClient().Payments.fetchAll();
            System.out.println("--------------"
                    + "----------------------");
            System.out.println("payments " + payments);
            System.out.println("------------------------------------");
            return ResponseEntity.ok(payments);
        } catch (RazorpayException e) {
            System.out.println("Payment exception " + e.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> paymentsId(@PathVariable String id) {
        System.out.println("payment " + id);
        try {
            Payment payment = razorpayConfigurer.razorpayClient().Payments.fetch(id);
            System.out.println("------------------------------------");
            System.out.println("payment " + payment);
            System.out.println("------------------------------------");
            return ResponseEntity.ok(payment.toString());
        } catch (RazorpayException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/payment/{id}/capture", method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> paymentsCapture(@PathVariable String id, @RequestParam String amount) {
        System.out.println("payment " + id);
        try {
            JSONObject object = new JSONObject();
            int val = Integer.parseInt(amount);
            object.put("amount", val);
            Payment payment = razorpayConfigurer.razorpayClient().Payments.capture(id, object);
            PaymentDetailsDto result = razorpayService.toPaymentDetails(payment);
            System.out.println("------------------------------------");
            System.out.println("payment " + payment);
            System.out.println("paymentDetailsDto " + result.toString());
            System.out.println("------------------------------------");
            return ResponseEntity.ok(result);
        } catch (RazorpayException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/rand", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String readJsonObj() {
        
        return razorpayService.generateRand();
    }

    @RequestMapping(value = "/payment/map", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentDetails readJsonObj(@RequestBody String obj) {
        System.out.println("payment obj" + obj.toString());
        PaymentDetails paymentDetails = new PaymentDetails();
        PaymentDetailsDto paymentDetailsDto = new PaymentDetailsDto();
        ObjectMapper mapper = new ObjectMapper();
        try {
            paymentDetailsDto = mapper.readValue(obj, PaymentDetailsDto.class);
            System.out.println("paymentDetailsDto " + paymentDetailsDto.toString());            
            paymentDetails = razorpayMapper.toEntity(paymentDetailsDto);
            System.out.println("paymentDetails " + paymentDetails.toString());
            return paymentDetails;
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // JSONObject object = new JSONObject();

        return null;
        // PaymentDetails paymentDetails = razorpayService.objToPayment(obj);
        // return paymentDetails;
    }

    /*
     * @RequestMapping(value = "/orders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     * public ResponseEntity<?> orders(@RequestParam String amount, @RequestParam String currency,
     * 
     * @RequestParam String receipt, @RequestParam Boolean paymentCapture) { System.out.println("amount " + amount); try
     * { JSONObject orderRequest = new JSONObject(); orderRequest.put("amount", amount); // amount in paise
     * orderRequest.put("currency", "INR"); orderRequest.put("receipt", "test_1"); orderRequest.put("payment_capture",
     * paymentCapture); Order order = razorpayConfigurer.razorpayClient().Orders.create(orderRequest);
     * System.out.println("------------------------------------"); System.out.println("Payment order " + order);
     * System.out.println("------------------------------------"); return ResponseEntity.ok(order.toString()); } catch
     * (RazorpayException e) { System.out.println("Payment exception " + e.getMessage()); } return null; }
     */

    @RequestMapping(value = "/orders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> order(@RequestBody OrderDetails orderDetails) {
        System.out.println("order " + orderDetails.toString());
        OrderDetails details = orderRepository.insert(orderDetails);
        System.out.println("order " + details.toString());
        try {
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", details.getAmount() * 100); // amount in paise
            orderRequest.put("currency", "INR");

            orderRequest.put("receipt", details.getId());
            orderRequest.put("payment_capture", 0);
            Order order = razorpayConfigurer.razorpayClient().Orders.create(orderRequest);
            System.out.println("------------------------------------");
            System.out.println("Payment order " + order);
            System.out.println("------------------------------------");
            return ResponseEntity.ok(order.toString());
        } catch (RazorpayException e) {
            System.out.println("Payment exception " + e.getMessage());
        }
        return ResponseEntity.ok(details);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> orders() {
        System.out.println("Get Orders");
        try {
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("count", 2);
            orderRequest.put("skip", 1);
            List<Order> order = razorpayConfigurer.razorpayClient().Orders.fetchAll();
            System.out.println("------------------------------------");
            System.out.println("Payment order " + order);
            System.out.println("------------------------------------");
            return ResponseEntity.ok(order.toString());
        } catch (RazorpayException e) {
            System.out.println("Payment exception " + e.getMessage());
        }
        return null;
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> orders(@PathVariable String id) {
        System.out.println("Get Orders");
        try {
            Order order = razorpayConfigurer.razorpayClient().Orders.fetch(id);
            System.out.println("------------------------------------");
            System.out.println("Payment order " + order);
            System.out.println("------------------------------------");
            return ResponseEntity.ok(order.toString());
        } catch (RazorpayException e) {
            System.out.println("Payment exception " + e.getMessage());
        }
        return null;
    }

}
