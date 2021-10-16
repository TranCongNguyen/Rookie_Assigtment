package com.rookie.rookie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer productId;
    private String name;
    private Double price;
    private MultipartFile images;
    private Date createDate;
    private Date updateDate;
    private Integer categoryId;
    private Integer ratingId;


}
