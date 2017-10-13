package com.quapt.myf4h.product.repository;

import com.quapt.myf4h.product.domain.PaymentDetails;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentDetails, String>{

}
