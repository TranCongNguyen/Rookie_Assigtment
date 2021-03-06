package com.rookie.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Orders", indexes = {
            @Index(name = "od_us_index",columnList = "user_id")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
  @Id
  @GeneratedValue(generator = "Sequence-generator")
  @GenericGenerator(
      name = "sequence_generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "order_sequence"),
        @Parameter(name = "increment_size", value = "1")
      })
  private Long id;

  @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
  private Collection<CartItem> cartItems;

  @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
  private Collection<Review> review;

  @ManyToOne
  @JoinColumn(name = "address_id",nullable = false)
  private Address address;

  @ManyToOne
  @JoinColumn(name="user_id",nullable = false)
  private User user;

  @Column(name = "order_date")
  @NotNull
  private LocalDateTime oderDate;

  @Column(name="update_date")
  private LocalDateTime updateDate;

  @NotNull private Long amount;

  @NotBlank private String status;
}
