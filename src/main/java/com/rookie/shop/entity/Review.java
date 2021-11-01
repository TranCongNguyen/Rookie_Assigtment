package com.rookie.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import org.hibernate.annotations.Parameter;

@Entity
@Table(
    name = "Reviews", indexes = {
            @Index(name = "rv_us_index", columnList = "user_id"),
            @Index(name = "rv_od_index",columnList = "order_id")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {
  @Id
  @GeneratedValue(generator = "Sequence-generator")
  @GenericGenerator(name= "sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
          @Parameter(name="sequence_name", value="review_sequence"),
          @Parameter(name="increment_size", value="1")
  })
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_detail_id", nullable = false)
  private ProductDetail productDetail;

  @ManyToOne
  @JoinColumn(name="user_id",nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @Column(name = "num_of_star")
  @NotNull
  private Short numOfStar;

  private String description;

  private short img;

  @Column(name = "create_date")
  @NotNull
  private LocalDateTime createDate;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @NotNull private Short status;
}
