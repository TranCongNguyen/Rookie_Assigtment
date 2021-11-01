package com.rookie.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name="Brand",indexes = {
        @Index(name = "br_index",columnList = "brand_name")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(generator = "Sequence-generator")
    @GenericGenerator(name= "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name="sequence_name", value="brand_sequence"),
            @Parameter(name="increment_size", value="1")
    })
    private Long id;

    @NotBlank
    @Column(name = "brand_name")
    private String brandName;

    @OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
    private Collection<Product> products;




}
