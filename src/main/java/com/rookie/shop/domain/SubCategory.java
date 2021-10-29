package com.rookie.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SubCategory", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"subCategory_title"})}, indexes = {
        @Index(name = "subcategory_index",columnList = "subCategory_title",unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategory {
    @Id
    @GeneratedValue(generator = "Sequence-generator")
    @GenericGenerator(name= "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name="sequence_name", value="subCategory_sequence"),
            @Parameter(name="increment_size", value="1")
    })
    @Column(name = "subCategory_id")
    private Long id;

    @NotBlank
    @Column(name = "subCategory_title")
    private String subCategoryTitle;

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

}
