package com.rookie.shop.dto;

import javax.validation.constraints.NotNull;

public class BrandDto {
    @NotNull
    private Long brandId;

    private String brandName;
}
