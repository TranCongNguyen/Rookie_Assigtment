package com.rookie.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CartItem",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})
} ,indexes = {
        @Index(name="ci_on_index",columnList = "id",unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(generator = "Sequence-generator")
    @GenericGenerator(name= "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name="sequence_name", value="cartItem_sequence"),
            @Parameter(name="increment_size", value="1")
    })
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id",nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_details_id",nullable = false)
    private ProductDetail productDetail;

    @NotNull
    private Integer quantity;

    @NotNull
    private Long price;


}
