package com.rookie.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItemDto {
    @NotNull
    private Long cartItemId;

    @NotNull
    private Integer quantity;

    @NotNull
    private Long price;

    @NotNull
    private Long orderId;

    @NotNull
    private Long productDetailId;
}
