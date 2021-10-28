package com.rookie.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategoryDto {
    @NotNull
    private Long subCategoryId;

    @NotBlank
    private String subCategoryTitle;

    @NotBlank
    private String description;

    @NotNull
    private Long categoryId;

}
