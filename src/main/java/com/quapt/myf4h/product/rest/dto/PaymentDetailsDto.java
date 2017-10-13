package com.quapt.myf4h.product.rest.dto;

import com.quapt.myf4h.product.domain.Notes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDetailsDto {

    @JsonProperty
    private String id;

    @JsonProperty
    private String email;

    @JsonProperty
    private String contact;

    @JsonProperty
    private String description;

    @JsonProperty
    private String amount;

    @JsonProperty
    private String fee;

    @JsonProperty
    private String entity;

    @JsonProperty("service_tax")
    private String serviceTax;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("notes")
    private Notes notes;

    @JsonProperty
    private String status;

    @JsonProperty
    private String currency;

    @JsonProperty
    private String bank;

    @JsonProperty
    private String captured;

    @JsonProperty
    private String method;

    @JsonProperty
    private String wallet;

    @JsonProperty
    private String vpa;

    @JsonProperty
    private String tax;

    @JsonProperty
    private String international;

    @JsonProperty("card_id")
    private String cardId;

    @JsonProperty("refund_status")
    private String refundStatus;

    @JsonProperty("amount_refunded")
    private String amountRefunded;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("error_description")
    private String errorDescription;

    @JsonProperty("created_at")
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

    public String getInternational() {
        return international;
    }

    public void setInternational(String international) {
        this.international = international;
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

    @Override
    public String toString() {
        return "PaymentDetailsDto [id=" + id + ", email=" + email + ", contact=" + contact + ", description="
                + description + ", amount=" + amount + ", fee=" + fee + ", entity=" + entity + ", serviceTax="
                + serviceTax + ", orderId=" + orderId + ", invoiceId=" + invoiceId + ", notes=" + notes + ", status="
                + status + ", currency=" + currency + ", bank=" + bank + ", captured=" + captured + ", method=" + method
                + ", wallet=" + wallet + ", vpa=" + vpa + ", international=" + international + ", cardId=" + cardId
                + ", refundStatus=" + refundStatus + ", amountRefunded=" + amountRefunded + ", errorCode=" + errorCode
                + ", errorDescription=" + errorDescription + ", createdAt=" + createdAt + "]";
    }

}
