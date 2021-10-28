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
public class ReviewDto {
    @NotNull
    private Long reviewId;

    @NotNull
    private Short numOfStar;

    private String description;

    private Short img;

    @NotNull
    private LocalDateTime createDate;

    @NotNull
    private LocalDateTime updateDate;

    @NotNull
    private Short status;

    @NotNull
    private Long productDetailId;

    @NotNull
    private Long userId;

    @NotNull
    private Long orderId;
}
