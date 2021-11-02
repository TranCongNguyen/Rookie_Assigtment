package com.rookie.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long cartItemId;

    @NotNull
    private Long reviewId;

    @NotNull
    private Long userId;

    @NotNull
    private Long addressId;

    private Long amount;

    private String status;

    private LocalDateTime orderDate;

    private LocalDateTime updateDate;
}
