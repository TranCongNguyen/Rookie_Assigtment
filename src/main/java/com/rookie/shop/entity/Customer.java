package com.rookie.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import  org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Customers", indexes = {
        @Index(name = "cm_us_index",columnList = "user_id")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(generator = "Sequence-generator")
    @GenericGenerator(
            name = "sequence_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "customer_sequence"),
                    @Parameter(name = "increment_size", value = "1")
            })
    private Long id;

    @NotBlank
    @Column(name="full_name")
    private String fullName;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",nullable = false)
    private User user;
}
