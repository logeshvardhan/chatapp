/**
 * 
 */
package com.quapt.myf4h.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author logesh
 *
 */
@Document(collection = "order_details")
public class OrderDetails implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String description;

    @Field
    private int amount;

    @Field
    private String currency;

    @Field("payment_capture")
    private String paymentCapture;

    @Field("user_id")
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderDetails [id=" + id + ", name=" + name + ", description=" + description + ", amount=" + amount
                + ", currency=" + currency + ", paymentCapture=" + paymentCapture + ", userId=" + userId + "]";
    }

}
