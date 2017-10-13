/**
 * 
 */
package com.quapt.myf4h.product.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author logesh
 *
 */
public class NotesDto {
    
    @JsonProperty
    private String address;
    
    @JsonProperty("order_id")
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
