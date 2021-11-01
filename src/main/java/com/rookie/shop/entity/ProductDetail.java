package com.rookie.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;


@Entity
@Table(name="ProductDetails",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
},indexes = {
        @Index(name="productDetails_on_index",columnList = "id",unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetail {
    @Id
    @GeneratedValue(generator = "Sequence-generator")
    @GenericGenerator(name= "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name="sequence_name", value="product_detail_sequence"),
            @Parameter(name="increment_size", value="1")
    })
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id",nullable=false)
    private Product product;

    @NotBlank
    private String color;

    @NotNull
    private Integer quantity;

    @NotNull
    private Long price;

    @OneToMany(mappedBy = "productDetail",fetch = FetchType.LAZY)
    private Collection<CartItem> cartItem;

    @OneToMany(mappedBy = "productDetail",fetch = FetchType.LAZY)
    private Collection<Review> reviews;


}
