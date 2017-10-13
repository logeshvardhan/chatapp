package com.quapt.myf4h.product.repository;

import com.quapt.myf4h.product.domain.OrderDetails;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderDetails, String>{

}
