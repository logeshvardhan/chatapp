/**
 * 
 */
package com.quapt.myf4h.product.domain;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author logesh
 *
 */
public class Notes {
    @Field
    private String address;
    
    @Field("order_id")
    private String orderId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
