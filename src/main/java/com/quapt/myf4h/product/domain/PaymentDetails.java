package com.quapt.myf4h.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "payment")
public class PaymentDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field
    private String email;

    @Field
    private String contact;

    @Field
    private String description;

    @Field
    private String amount;

    @Field
    private String fee;

    @Field
    private String entity;

    @Field("service_tax")
    private String serviceTax;

    @Field("order_id")
    private String orderId;

    @Field("invoice_id")
    private String invoiceId;

    @Field("notes")
    private Notes notes;

    @Field
    private String status;

    @Field
    private String currency;

    @Field
    private String bank;

    @Field
    private String captured;

    @Field
    private String method;

    @Field
    private String wallet;

    @Field
    private String vpa;

    @Field
    private String tax;

    @Field
    private String international;

    @Field("card_id")
    private String cardId;

    @Field("refund_status")
    private String refundStatus;

    @Field("amount_refunded")
    private String amountRefunded;

    @Field("error_code")
    private String errorCode;

    @Field("error_description")
    private String errorDescription;

    @Field("created_at")
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(String serviceTax) {
        this.serviceTax = serviceTax;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCaptured() {
        return captured;
    }

    public void setCaptured(String captured) {
        this.captured = captured;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getVpa() {
        return vpa;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(String amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getInternational() {
        return international;
    }

    public void setInternational(String international) {
        this.international = international;
    }

    @Override
    public String toString() {
        return "PaymentDetails [id=" + id + ", email=" + email + ", contact=" + contact + ", description=" + description
                + ", amount=" + amount + ", fee=" + fee + ", entity=" + entity + ", serviceTax=" + serviceTax
                + ", orderId=" + orderId + ", invoiceId=" + invoiceId + ", notes=" + notes + ", status=" + status
                + ", currency=" + currency + ", bank=" + bank + ", captured=" + captured + ", method=" + method
                + ", wallet=" + wallet + ", vpa=" + vpa + ", international=" + international + ", cardId=" + cardId
                + ", refundStatus=" + refundStatus + ", amountRefunded=" + amountRefunded + ", errorCode=" + errorCode
                + ", errorDescription=" + errorDescription + ", createdAt=" + createdAt + "]";
    }
    
    

}
