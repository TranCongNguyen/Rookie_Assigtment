package com.rookie.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Orders", uniqueConstraints = {
            @UniqueConstraint(columnNames = {"id"})}, indexes = {
            @Index(name = "od_on_index", columnList = "id", unique = true)})
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

  @Column(name = "order_date")
  @NotNull
  private LocalDateTime oderDate;

  @NotNull private Long amount;

  @Enumerated(EnumType.STRING)
  @NaturalId
  @Column(name = "order_status", length = 50)
  @NotNull
  private OrderStatus orderStatus;
}
