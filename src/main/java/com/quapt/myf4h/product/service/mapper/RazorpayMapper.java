package com.quapt.myf4h.product.service.mapper;

import com.quapt.myf4h.product.domain.PaymentDetails;
import com.quapt.myf4h.product.rest.dto.PaymentDetailsDto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { NotesMapper.class })
public interface RazorpayMapper {

    PaymentDetails toEntity(PaymentDetailsDto paymentDto);

    PaymentDetailsDto toDto(PaymentDetails payment);

}
