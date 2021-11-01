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
@Table(name = "Addresses",indexes = {
        @Index(name = "ad_us_index",columnList = "user_id"),
        @Index(name = "ad_co_index1",columnList = "contact_name"),
        @Index(name = "ad_con_index2",columnList = "contact_number")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(generator = "Sequence-generator")
    @GenericGenerator(name= "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name="sequence_name", value="address_sequence"),
            @Parameter(name="increment_size", value="1")
    })
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String ward;

    @NotBlank
    private String detail;

    @NotBlank
    @Column(name="contact_name")
    private String contactName;

    @NotBlank
    @Column(name="contact_number")
    private String contactNumber;

    @Column(name="is_default_address")
    private Boolean isDefault;

    @Column(name="is_payment_address")
    private Boolean isPayment;

    @OneToMany(mappedBy = "address",fetch = FetchType.LAZY)
    private Collection<Order> order;
}
