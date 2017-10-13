/**
 * 
 */
package com.quapt.myf4h.product.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author logesh
 *
 */
@Document(collection = "invoice")
public class Invoice {

    @Field("invoice_id")
    private String invoioceId;

    @Field
    private String fees;

    @Field
    private String gst;

    @Field
    private String total;

    @Field("sub_total")
    private String subTotal;

    @Field("user_name")
    private String userName;

    @Field
    private String email;

    @Field("item_name")
    private String itemName;

    @Field("item_id")
    private String itemId;

    @Field
    private String paid;

    @Field
    private String owing;

    @Field("payment_id")
    private String paymentId;

    @Field
    private String currency;

    @Field("consultation_data")
    private String cunsultationDate;

    @Field
    private String duration;

    @Field("created_at")
    private String createAt;

    public String getInvoioceId() {
        return invoioceId;
    }

    public void setInvoioceId(String invoioceId) {
        this.invoioceId = invoioceId;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getOwing() {
        return owing;
    }

    public void setOwing(String owing) {
        this.owing = owing;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCunsultationDate() {
        return cunsultationDate;
    }

    public void setCunsultationDate(String cunsultationDate) {
        this.cunsultationDate = cunsultationDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Invoice [invoioceId=" + invoioceId + ", fees=" + fees + ", gst=" + gst + ", total=" + total
                + ", subTotal=" + subTotal + ", userName=" + userName + ", email=" + email + ", itemName=" + itemName
                + ", itemId=" + itemId + ", paid=" + paid + ", owing=" + owing + ", paymentId=" + paymentId
                + ", currency=" + currency + ", cunsultationDate=" + cunsultationDate + ", duration=" + duration
                + ", createAt=" + createAt + "]";
    }

}
