package com.rookie.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "SubCategory", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"subCategoryTitle"})}, indexes = {
        @Index(name = "scate_index",columnList = "subCategoryTitle",unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubCategory {
    @Id
    @Column(name = "subCategory_id")
    private Long id;

    @NotBlank
    @Column(name = "subCategoryTitle")
    private String subCategoryTitle;

    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

}
