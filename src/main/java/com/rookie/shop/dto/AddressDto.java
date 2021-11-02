package com.rookie.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
    @NotNull
    private Long addressId;

    @NotNull
    private Long userId;

    @NotNull
    private Long orderId;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String ward;

    @NotBlank
    private String detail;

    @NotBlank
    private String contactName;

    @NotBlank
    private String contactNumber;

    private Boolean isDefault;

    private Boolean isPayment;
}
