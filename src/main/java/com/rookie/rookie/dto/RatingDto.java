package com.rookie.rookie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private Integer ratingId;
    private Integer productId;
    private Integer like;
    private Integer Dislike;
}
