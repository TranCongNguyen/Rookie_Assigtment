package com.rookie.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="Products", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"product_name"})}, indexes = {
        @Index(name = "product_on_index",columnList = "product_name",unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(generator = "Sequence-generator")
    @GenericGenerator(name= "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name="sequence_name", value="product_sequence"),
            @Parameter(name="increment_size", value="1")
    })
    private Long id;

    @Column(name = "product_name")
    @NotBlank
    private String productName;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Double weight;

    @NotNull
    private Integer size;

    @NotNull
    private String memory;

    @NotNull
    private String ram;

    @NotNull
    @Column(name="create_date")
    private LocalDateTime createDate;

    @Column(name="status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Collection<ProductDetail> productDetail;



}
