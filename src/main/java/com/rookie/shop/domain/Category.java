package com.rookie.shop.domain;


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
@Table(name="Categories", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"category_title"})},indexes = {
        @Index(name="categories_on_index", columnList = "category_title",unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(generator = "Sequence-generator")
    @GenericGenerator(name= "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name="sequence_name", value="category_sequence"),
            @Parameter(name="increment_size", value="1")
    })
    private Long id;

    @Column(name="category_title")
    @NotBlank
    private String categoryTitle;

    @NotBlank
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Collection<Product> product;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Collection<SubCategory> subCategories;

}
