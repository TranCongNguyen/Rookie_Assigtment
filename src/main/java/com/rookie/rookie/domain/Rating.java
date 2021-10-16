package com.rookie.rookie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="rating_id")
    private Integer ratingId;

    @Column(name="rating_like")
    private Integer like;
    @Column(name="rating_dislike")
    private Integer dislike;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_id")
    Product product;

}
