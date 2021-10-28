package com.rookie.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    @NotNull
    private Long orderId;

    @NotNull
    private LocalDateTime orderDate;

    @NotNull
    private Long amount;

    @NotBlank
    private String orderStatus;

    @NotNull
    private Long cartItemId;

    @NotNull
    private Long reviewId;
}
