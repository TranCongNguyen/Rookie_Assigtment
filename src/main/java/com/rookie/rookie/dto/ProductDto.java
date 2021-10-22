package com.rookie.rookie.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotNull
    private Integer productId;
    @NotEmpty
    private String name;
    @NotEmpty
    private Double price;
    @NotEmpty
    private String images;
    @NotEmpty
    private Date createDate = new Date();
    @NotEmpty
    private Date updateDate = new Date();
    @NotEmpty
    private Integer categoryId;


}
