/**
 * 
 */
package com.quapt.myf4h.product.service;

import com.quapt.myf4h.product.domain.Invoice;
import com.quapt.myf4h.product.domain.PaymentDetails;
import com.quapt.myf4h.product.repository.PaymentRepository;
import com.quapt.myf4h.product.rest.dto.PaymentDetailsDto;
import com.quapt.myf4h.product.service.mapper.RazorpayMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.razorpay.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author logesh
 *
 */
@Service
public class RazorpayService {

    @Autowired
    private RazorpayMapper razorpayMapper;

    @Autowired
    private PaymentRepository paymentRepository;

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public PaymentDetailsDto toPaymentDetails(Payment payment) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            PaymentDetailsDto paymentDetailsDto = mapper.readValue(payment.toString(), PaymentDetailsDto.class);
            if (paymentDetailsDto != null) {
                PaymentDetails paymentDetails = razorpayMapper.toEntity(paymentDetailsDto);
                PaymentDetails entity = paymentRepository.insert(paymentDetails);
                PaymentDetailsDto result = razorpayMapper.toDto(entity);
                return result;
            }
        } catch (IOException e) {
            System.out.println("Exception " + e);
            e.printStackTrace();
        }
        return null;
    }

    public String generateRand() {
        String rand = randStr(10);
        System.out.println("string " + rand);
       // int randInteger = randInt();
        //System.out.println("integer " + randInteger);
        //String result = rand.concat(String.valueOf(randInteger));
        //System.out.println("generated string " + result);
        return rand;
    }

    /*public int randInt() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        for (int idx = 1; idx <= 10; ++idx) {
            randomInt = randomGenerator.nextInt(100);
            System.out.println("Generated : " + randomInt);
        }
        return randomInt;
    }*/

    public String randStr(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

}
