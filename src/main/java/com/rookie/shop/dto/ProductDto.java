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
public class ProductDto {
    @NotNull
    private Long productId;

    @NotBlank
    private String productName;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Double weight;

    @NotNull
    private LocalDateTime createDate;

    @NotNull
    private Boolean status;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long productDetailId;
}
