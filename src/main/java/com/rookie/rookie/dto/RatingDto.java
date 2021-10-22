package com.rookie.rookie.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    @NotEmpty
    private Integer ratingId;
    @NotEmpty
    private Integer productId;
    @NotEmpty
    private Integer like;
    @NotEmpty
    private Integer Dislike;
}
