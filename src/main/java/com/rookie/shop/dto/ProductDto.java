package com.rookie.shop.dto;

import com.rookie.shop.entity.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

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
    private String model;

    @NotBlank
    private String size;

    @NotNull
    private Float weight;

    @NotBlank
    private String material;

    @NotBlank
    private String description;

    @NotNull
    private Short warranty;

    @NotNull
    private List<Short> img;

    @NotNull
    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    @NotNull
    private Long categoryId;


    @NotNull
    private Long brandId;

    @NotEmpty
    private Collection<ProductDetail> productDetailId;
}
